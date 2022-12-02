package com.miracle.worm_cat.controller.system;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miracle.worm_cat.common.config.easy_excel.ExportCellStyleStrategy;
import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.constant.CacheKeys;
import com.miracle.worm_cat.common.domain.CheckResult;
import com.miracle.worm_cat.common.response.RespResult;
import com.miracle.worm_cat.common.utils.ExportRespUtil;
import com.miracle.worm_cat.common.utils.RedisUtil;
import com.miracle.worm_cat.controller.system.dto.MenuParam;
import com.miracle.worm_cat.domain.system.SysMenu;
import com.miracle.worm_cat.dto.system.TreeOptsDTO;
import com.miracle.worm_cat.mapper.system.SysMenuMapper;
import com.miracle.worm_cat.service.system.SysMenuService;
import com.miracle.worm_cat.validate.AddGroup;
import com.miracle.worm_cat.validate.UpdateGroup;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: Miracle-
 * time: 2022/11/21 18:54
 */
@RestController
@RequestMapping(value = "/system-mgr/sys-menu")
public class SysMenuController {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private SysMenuMapper menuMapper;

    @Resource
    private SysMenuService menuService;

    /**
     * 获取父级菜单选项
     */
    @PostMapping(value = "menuOptsData")
    public RespResult<List<TreeOptsDTO>> menuOptsData(@RequestParam(value = "flush", defaultValue = "false") Boolean flush) {
        List<TreeOptsDTO> menuOptsList;
        if (flush) {
            menuOptsList = menuMapper.menuOptsData(0);
            menuChildren(menuOptsList);
            redisUtil.set(CacheKeys.MENU_OPTS_KEY, menuOptsList);
        } else {
            boolean exists = redisUtil.exists(CacheKeys.MENU_OPTS_KEY);
            if (exists) {
                menuOptsList = (List<TreeOptsDTO>) redisUtil.get(CacheKeys.MENU_OPTS_KEY);
            } else {
                menuOptsList = menuMapper.menuOptsData(0);
                menuChildren(menuOptsList);
                redisUtil.set(CacheKeys.MENU_OPTS_KEY, menuOptsList);
            }
        }
        return RespResult.success(menuOptsList);
    }

    /**
     * 判断组织名或取组织代码是否重复
     */
    @PostMapping(value = "checkExist")
    public RespResult<CheckResult> checkOrgExist(@RequestBody SysMenu menu) {
        CheckResult checkRes = new CheckResult(false, "");
        boolean needCheckCode = !StringUtils.isEmpty(menu.getMenuCode());
        boolean needCheckName = !StringUtils.isEmpty(menu.getMenuName());
        boolean needCheckSortNo = null != menu.getSortNo() && menu.getSortNo() > 0;
        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
        if (null == menu.getId()) {
            if (needCheckCode) {
                wrapper.eq(SysMenu::getMenuCode, menu.getMenuCode());
                int count = menuService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "菜单代码重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysMenu::getMenuName, menu.getMenuName());
                int count = menuService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "菜单名称重复");
                }
                wrapper.clear();
            }
            if (needCheckSortNo) {
                wrapper.eq(SysMenu::getSortNo, menu.getSortNo())
                        .eq(SysMenu::getpId, menu.getpId());
                int count = menuService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "排序号重复");
                }
                wrapper.clear();
            }
        } else {
            if (needCheckCode) {
                wrapper.eq(SysMenu::getMenuCode, menu.getMenuCode())
                        .ne(SysMenu::getId, menu.getId());
                int count = menuService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "菜单代码重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysMenu::getMenuName, menu.getMenuName())
                        .ne(SysMenu::getId, menu.getId());
                int count = menuService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "菜单名称重复");
                }
                wrapper.clear();
            }
            if (needCheckSortNo) {
                wrapper.eq(SysMenu::getSortNo, menu.getSortNo())
                        .eq(SysMenu::getpId, menu.getpId())
                        .ne(SysMenu::getId, menu.getId());
                int count = menuService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "排序号重复");
                }
                wrapper.clear();
            }
        }
        return RespResult.success(checkRes);
    }

    /**
     * 菜单新增
     */
    @PostMapping(value = "menuAddData")
    public RespResult<?> menuAddData(@RequestBody @Validated({AddGroup.class}) SysMenu menu,
                                     HttpServletRequest request) {
        Long userid = Long.valueOf(request.getParameter(BaseConstant.USER_ID));
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        //1.校验是否重复
        CheckResult existResult = checkOrgExist(menu).getData();
        if (existResult.getOk()) {
            return RespResult.validateFailed(existResult.getMsg());
        }

        //2.添加创建人和更新人
        menu.setCreatorId(userid);
        menu.setCreatorName(nickname);
        menu.setUpdaterId(userid);
        menu.setUpdaterName(nickname);

        menuService.save(menu);
        menuOptsData(true);
        return RespResult.success();
    }

    /**
     * 菜单删除
     */
    @DeleteMapping(value = "menuDeleteData")
    public RespResult<?> menuDeleteData(@RequestBody List<Integer> ids,
                                        @RequestParam("remark") String remark,
                                        HttpServletRequest request) {
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        LambdaUpdateWrapper<SysMenu> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(SysMenu::getMenuRemark, nickname.concat("(删除): ").concat(remark))
                .in(SysMenu::getId, ids);
        menuService.update(updateWrapper);
        int effectRows = menuMapper.deleteBatchIds(ids);
        if (effectRows > 0) {
            menuOptsData(true);
        }
        return RespResult.success();
    }

    /**
     * 菜单修改
     */
    @PutMapping(value = "menuUpdateData")
    public RespResult<?> menuUpdateData(@RequestBody @Validated({UpdateGroup.class}) SysMenu menu,
                                        HttpServletRequest request) {
        Long userid = Long.valueOf(request.getParameter(BaseConstant.USER_ID));
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        //1.校验是否重复
        CheckResult existResult = checkOrgExist(menu).getData();
        if (existResult.getOk()) {
            return RespResult.validateFailed(existResult.getMsg());
        }

        //3.添加更新人
        SysMenu oldPerm = menuMapper.selectById(menu.getId());
        menu.setUpdaterId(userid);
        menu.setUpdaterName(nickname);
        menu.setVersion(oldPerm.getVersion());

        int effectRows = menuMapper.updateById(menu);
        if (effectRows > 0) {
            menuOptsData(true);
        }
        return RespResult.success();
    }

    /**
     * 获取菜单列表数据
     */
    @PostMapping(value = "menuPageData")
    public RespResult<Page<SysMenu>> menuPageData(@RequestBody MenuParam param) {
        Page<SysMenu> menuPage = new Page<>(param.getCurrent(), param.getSize());
        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isBlank(param.getMenuCode()), SysMenu::getMenuCode, param.getMenuCode());
        wrapper.like(!StringUtils.isBlank(param.getMenuName()), SysMenu::getMenuName, param.getMenuName());
        if (null != param.getMenuStatus()) {
            if (param.getMenuStatus().size() == 1) {
                wrapper.eq(SysMenu::getMenuStatus, param.getMenuStatus().get(0));
            } else if (param.getMenuStatus().size() > 1) {
                wrapper.in(SysMenu::getMenuStatus, param.getMenuStatus());
            }
        }
        if (null != param.getPidCascade()) {
            if (param.getPidCascade().size() == 1) {
                wrapper.eq(SysMenu::getpId, param.getPidCascade().get(0));
            } else if (param.getPidCascade().size() > 1) {
                wrapper.in(SysMenu::getpId, param.getPidCascade());
            }
        }
        wrapper.ge(null != param.getCreateTimeStart(), SysMenu::getCreateTime, param.getCreateTimeStart());
        wrapper.lt(null != param.getCreateTimeEnd(), SysMenu::getCreateTime, param.getCreateTimeEnd());
        if (!StringUtils.isBlank(param.getMenuNames())) {
            String[] splitRes = param.getMenuNames().split(" ");
            wrapper.in(SysMenu::getMenuName, Arrays.asList(splitRes));
        }
        wrapper.orderByDesc(SysMenu::getCreateTime);
        return RespResult.success(menuService.page(menuPage, wrapper));
    }

    /**
     * 菜单导出
     */
    @PostMapping(value = "menuExportData")
    public void menuExportData(@RequestBody MenuParam param,
                               HttpServletResponse response) throws IOException {
        RespResult<Page<SysMenu>> result = menuPageData(param);
        ExportRespUtil.setResponseHeader("菜单信息.xls", response);
        ExcelWriterBuilder excelBookWriter = EasyExcel.write(response.getOutputStream(), SysMenu.class)
                .registerWriteHandler(ExportCellStyleStrategy.getStyleStrategy());
        ExcelWriterSheetBuilder sheetFirstWriter = excelBookWriter.sheet("菜单");
        sheetFirstWriter.doWrite(result.getData().getRecords());
    }

    /**
     * 递归获取菜单选项
     */
    private void menuChildren(List<TreeOptsDTO> data) {
        for (TreeOptsDTO datum : data) {
            List<TreeOptsDTO> children = menuMapper.menuOptsData(datum.getValue());
            if (null == children || children.size() == 0) {
                datum.setChildren(new ArrayList<>());
            } else {
                menuChildren(children);
                datum.setChildren(children);
            }
        }
    }

}
