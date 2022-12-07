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
import com.miracle.worm_cat.controller.system.dto.PermParam;
import com.miracle.worm_cat.domain.system.SysPerm;
import com.miracle.worm_cat.dto.system.TreeOptsDTO;
import com.miracle.worm_cat.mapper.system.SysPermMapper;
import com.miracle.worm_cat.service.system.SysPermService;
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
@RequestMapping(value = "/system-mgr/sys-perm")
public class SysPermController {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private SysPermMapper permMapper;

    @Resource
    private SysPermService permService;

    /**
     * 获取父级权限选项
     */
    @PostMapping(value = "permOptsData")
    public RespResult<List<TreeOptsDTO>> permOptsData(@RequestParam(value = "flush", defaultValue = "false") Boolean flush) {
        List<TreeOptsDTO> permOptsList;
        if (flush) {
            permOptsList = permMapper.permOptsData(0);
            permChildren(permOptsList);
            redisUtil.set(CacheKeys.PERM_OPTS_KEY, permOptsList);
        } else {
            boolean exists = redisUtil.exists(CacheKeys.PERM_OPTS_KEY);
            if (exists) {
                permOptsList = (List<TreeOptsDTO>) redisUtil.get(CacheKeys.PERM_OPTS_KEY);
            } else {
                permOptsList = permMapper.permOptsData(0);
                permChildren(permOptsList);
                redisUtil.set(CacheKeys.PERM_OPTS_KEY, permOptsList);
            }
        }
        return RespResult.success(permOptsList);
    }

    /**
     * 判断权限名或权限代码是否重复
     */
    @PostMapping(value = "checkExist")
    public RespResult<CheckResult> checkOrgExist(@RequestBody SysPerm perm) {
        CheckResult checkRes = new CheckResult(false, "");
        boolean needCheckCode = !StringUtils.isEmpty(perm.getPermCode());
        boolean needCheckName = !StringUtils.isEmpty(perm.getPermName());
        boolean needCheckSortNo = null != perm.getSortNo() && perm.getSortNo() > 0;
        LambdaQueryWrapper<SysPerm> wrapper = new LambdaQueryWrapper<>();
        if (null == perm.getId()) {
            if (needCheckCode) {
                wrapper.eq(SysPerm::getPermCode, perm.getPermCode());
                int count = permService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "权限代码重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysPerm::getPermName, perm.getPermName());
                int count = permService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "权限名称重复");
                }
                wrapper.clear();
            }
            if (needCheckSortNo) {
                wrapper.eq(SysPerm::getSortNo, perm.getSortNo())
                        .eq(SysPerm::getpId, perm.getpId());
                int count = permService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "排序号重复");
                }
                wrapper.clear();
            }
        } else {
            if (needCheckCode) {
                wrapper.eq(SysPerm::getPermCode, perm.getPermCode())
                        .ne(SysPerm::getId, perm.getId());
                int count = permService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "权限代码重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysPerm::getPermName, perm.getPermName())
                        .ne(SysPerm::getId, perm.getId());
                int count = permService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "权限名称重复");
                }
                wrapper.clear();
            }
            if (needCheckSortNo) {
                wrapper.eq(SysPerm::getSortNo, perm.getSortNo())
                        .eq(SysPerm::getId, perm.getId())
                        .ne(SysPerm::getId, perm.getId());
                int count = permService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "排序号重复");
                }
                wrapper.clear();
            }
        }
        return RespResult.success(checkRes);
    }

    /**
     * 权限新增
     */
    @PostMapping(value = "permAddData")
    public RespResult<?> permAddData(@RequestBody @Validated({AddGroup.class}) SysPerm perm,
                                     HttpServletRequest request) {
        Long userid = Long.valueOf(request.getParameter(BaseConstant.USER_ID));
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        //1.校验是否重复
        CheckResult existResult = checkOrgExist(perm).getData();
        if (existResult.getOk()) {
            return RespResult.validateFailed(existResult.getMsg());
        }

        //2.添加创建人和更新人
        perm.setCreatorId(userid);
        perm.setCreatorName(nickname);
        perm.setUpdaterId(userid);
        perm.setUpdaterName(nickname);

        permService.save(perm);
        permOptsData(true);
        return RespResult.success();
    }

    /**
     * 权限删除
     */
    @DeleteMapping(value = "permDeleteData")
    public RespResult<?> permDeleteData(@RequestBody List<Integer> ids,
                                        @RequestParam("remark") String remark,
                                        HttpServletRequest request) {
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        LambdaUpdateWrapper<SysPerm> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(SysPerm::getPermRemark, nickname.concat("(删除): ").concat(remark))
                .in(SysPerm::getId, ids);
        permService.update(updateWrapper);
        int effectRows = permMapper.deleteBatchIds(ids);
        if (effectRows > 0) {
            permOptsData(true);
        }
        return RespResult.success();
    }

    /**
     * 权限修改
     */
    @PutMapping(value = "permUpdateData")
    public RespResult<?> permUpdateData(@RequestBody @Validated({UpdateGroup.class}) SysPerm perm,
                                        HttpServletRequest request) {
        Long userid = Long.valueOf(request.getParameter(BaseConstant.USER_ID));
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        //1.校验是否重复
        CheckResult existResult = checkOrgExist(perm).getData();
        if (existResult.getOk()) {
            return RespResult.validateFailed(existResult.getMsg());
        }

        //3.添加更新人
        SysPerm oldPerm = permMapper.selectById(perm.getId());
        perm.setUpdaterId(userid);
        perm.setUpdaterName(nickname);
        perm.setVersion(oldPerm.getVersion());

        int effectRows = permMapper.updateById(perm);
        if (effectRows > 0) {
            permOptsData(true);
        }
        return RespResult.success();
    }

    /**
     * 获取权限列表数据
     */
    @PostMapping(value = "permPageData")
    public RespResult<Page<SysPerm>> permPageData(@RequestBody PermParam param) {
        Page<SysPerm> permPage = new Page<>(param.getCurrent(), param.getSize());
        LambdaQueryWrapper<SysPerm> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isBlank(param.getPermCode())) {
            wrapper.like(SysPerm::getPermCode, param.getPermCode().trim());
        }
        if (!StringUtils.isBlank(param.getPermName())) {
            wrapper.like(SysPerm::getPermName, param.getPermName().trim());
        }
        if (null != param.getPermStatus()) {
            if (param.getPermStatus().size() == 1) {
                wrapper.eq(SysPerm::getPermStatus, param.getPermStatus().get(0));
            } else if (param.getPermStatus().size() > 1) {
                wrapper.in(SysPerm::getPermStatus, param.getPermStatus());
            }
        }
        if (null != param.getPidCascade()) {
            if (param.getPidCascade().size() == 1) {
                wrapper.eq(SysPerm::getpId, param.getPidCascade().get(0));
            } else if (param.getPidCascade().size() > 1) {
                wrapper.in(SysPerm::getpId, param.getPidCascade());
            }
        }
        wrapper.ge(null != param.getCreateTimeStart(), SysPerm::getCreateTime, param.getCreateTimeStart());
        wrapper.lt(null != param.getCreateTimeEnd(), SysPerm::getCreateTime, param.getCreateTimeEnd());
        if (!StringUtils.isBlank(param.getPermNames())) {
            String[] splitRes = param.getPermNames().split(" ");
            wrapper.in(SysPerm::getPermName, Arrays.asList(splitRes));
        }
        wrapper.orderByDesc(SysPerm::getCreateTime);
        return RespResult.success(permService.page(permPage, wrapper));
    }

    /**
     * 权限导出
     */
    @PostMapping(value = "permExportData")
    public void permExportData(@RequestBody PermParam param,
                               HttpServletResponse response) throws IOException {
        RespResult<Page<SysPerm>> result = permPageData(param);
        ExportRespUtil.setResponseHeader("权限信息.xls", response);
        ExcelWriterBuilder excelBookWriter = EasyExcel.write(response.getOutputStream(), SysPerm.class)
                .registerWriteHandler(ExportCellStyleStrategy.getStyleStrategy());
        ExcelWriterSheetBuilder sheetFirstWriter = excelBookWriter.sheet("权限");
        sheetFirstWriter.doWrite(result.getData().getRecords());
    }

    /**
     * 递归获取权限选项
     */
    private void permChildren(List<TreeOptsDTO> data) {
        for (TreeOptsDTO datum : data) {
            List<TreeOptsDTO> children = permMapper.permOptsData(datum.getValue());
            if (null == children || children.size() == 0) {
                datum.setChildren(new ArrayList<>());
            } else {
                permChildren(children);
                datum.setChildren(children);
            }
        }
    }

}
