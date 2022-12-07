package com.miracle.worm_cat.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miracle.worm_cat.common.constant.CacheKeys;
import com.miracle.worm_cat.common.domain.CheckResult;
import com.miracle.worm_cat.common.response.RespResult;
import com.miracle.worm_cat.common.utils.RedisUtil;
import com.miracle.worm_cat.controller.system.dto.ButtonParam;
import com.miracle.worm_cat.domain.system.SysButton;
import com.miracle.worm_cat.domain.system.SysMenu;
import com.miracle.worm_cat.domain.system.SysRoleMenu;
import com.miracle.worm_cat.dto.system.BaseOptsDTO;
import com.miracle.worm_cat.dto.system.TreeOptsDTO;
import com.miracle.worm_cat.mapper.system.SysButtonMapper;
import com.miracle.worm_cat.mapper.system.SysMenuMapper;
import com.miracle.worm_cat.service.system.SysButtonService;
import com.miracle.worm_cat.service.system.SysMenuService;
import com.miracle.worm_cat.validate.AddGroup;
import com.miracle.worm_cat.validate.UpdateGroup;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * author: Miracle-
 * time: 2022/11/30 17:20
 */
@RestController
@RequestMapping(value = "/system-mgr/sys-button")
public class SysButtonController {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private SysMenuMapper menuMapper;
    @Resource
    private SysButtonMapper buttonMapper;

    @Resource
    private SysButtonService buttonService;
    @Resource
    private SysMenuService menuService;

    /**
     * 可选择的按钮数据
     */
    @PostMapping(value = "buttonOptsData")
    public RespResult<List<TreeOptsDTO>> buttonOptsData(@RequestParam(value = "flush", defaultValue = "false") Boolean flush) {
        List<TreeOptsDTO> buttonOptsList;
        if (flush) {
            buttonOptsList = menuMapper.menuOptsData(0);
            menuChildren(buttonOptsList);
            redisUtil.set(CacheKeys.BUTTON_OPTS_KEY, buttonOptsList);
        } else {
            boolean exists = redisUtil.exists(CacheKeys.BUTTON_OPTS_KEY);
            if (exists) {
                buttonOptsList = (List<TreeOptsDTO>) redisUtil.get(CacheKeys.BUTTON_OPTS_KEY);
            } else {
                buttonOptsList = menuMapper.menuOptsData(0);
                menuChildren(buttonOptsList);
                redisUtil.set(CacheKeys.BUTTON_OPTS_KEY, buttonOptsList);
            }
        }
        return RespResult.success(buttonOptsList);
    }

    /**
     * 判断按钮名称是否重复
     */
    @PostMapping(value = "checkExist")
    public RespResult<?> checkExist(@RequestBody SysButton button) {
        CheckResult checkRes = new CheckResult(false, "");
        boolean needCheckCode = null != button.getCode();
        boolean needCheckName = !StringUtils.isEmpty(button.getName());
        LambdaQueryWrapper<SysButton> wrapper = new LambdaQueryWrapper<>();
        if (null == button.getId()) {
            if (needCheckCode) {
                wrapper.eq(SysButton::getCode, button.getCode())
                        .eq(SysButton::getMenuId, button.getMenuId());
                int count = buttonService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "按钮代码重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysButton::getName, button.getName())
                        .eq(SysButton::getMenuId, button.getMenuId());
                int count = buttonService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "按钮名称重复");
                }
                wrapper.clear();
            }
        } else {
            if (needCheckCode) {
                wrapper.eq(SysButton::getCode, button.getCode())
                        .eq(SysButton::getMenuId, button.getMenuId())
                        .ne(SysButton::getId, button.getId());
                int count = buttonService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "按钮代码重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysButton::getName, button.getName())
                        .eq(SysButton::getMenuId, button.getMenuId())
                        .ne(SysButton::getId, button.getId());
                int count = buttonService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "按钮名称重复");
                }
                wrapper.clear();
            }
        }
        return RespResult.success(checkRes);
    }

    /**
     * 新增按钮数据
     */
    @PostMapping(value = "buttonAddData")
    public RespResult<?> buttonAddData(@RequestBody @Validated({AddGroup.class}) SysButton button) {
        SysMenu menu = menuService.getById(button.getMenuId());
        button.setMenuName(menu.getMenuName());
        buttonService.save(button);
        buttonOptsData(true);
        return RespResult.success();
    }

    /**
     * 删除按钮数据
     */
    @DeleteMapping(value = "buttonDeleteData")
    public RespResult<?> buttonDeleteData(@RequestBody List<Integer> ids) {
        buttonService.removeByIds(ids);
        return RespResult.success();
    }

    /**
     * 更新按钮数据
     */
    @PutMapping(value = "buttonUpdateData")
    public RespResult<?> buttonUpdateData(@RequestBody @Validated({UpdateGroup.class}) SysButton button) {
        SysButton oldButton = buttonService.getById(button.getId());
        if (null != button.getMenuId() && !oldButton.getMenuId().equals(button.getMenuId())) {
            SysMenu menu = menuService.getById(button.getMenuId());
            button.setMenuName(menu.getMenuName());
        }
        int effectRows = buttonMapper.updateById(button);
        if (effectRows > 0) {
            buttonOptsData(true);
        }
        return RespResult.success();
    }

    /**
     * 按钮列表数据
     */
    @PostMapping(value = "buttonPageData")
    public RespResult<Page<SysButton>> buttonPageData(@RequestBody ButtonParam param) {
        Page<SysButton> buttonPage = new Page<>();
        LambdaQueryWrapper<SysButton> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isBlank(param.getCode())) {
            wrapper.like(SysButton::getCode, param.getCode().trim());
        }
        if (!StringUtils.isBlank(param.getName())) {
            wrapper.like(SysButton::getName, param.getName().trim());
        }
        if (null != param.getMenuIdCascade()) {
            if (param.getMenuIdCascade().size() == 1) {
                wrapper.eq(SysButton::getMenuId, param.getMenuIdCascade().get(0));
            } else if (param.getMenuIdCascade().size() > 1) {
                wrapper.in(SysButton::getMenuId, param.getMenuIdCascade());
            }
        }
        wrapper.eq(null != param.getSortNo(), SysButton::getSortNo, param.getSortNo());
        wrapper.orderByDesc(SysButton::getId);
        return RespResult.success(buttonService.page(buttonPage, wrapper));
    }

    /**
     * 递归获取菜单选项
     */
    private void menuChildren(List<TreeOptsDTO> data) {
        for (TreeOptsDTO datum : data) {
            List<TreeOptsDTO> children = menuMapper.menuOptsData(datum.getValue());
            if (null == children || children.size() == 0) {
                List<TreeOptsDTO> buttons = buttonMapper.buttonsByMenuId(datum.getValue());
                datum.setChildren(buttons);
            } else {
                menuChildren(children);
                datum.setChildren(children);
            }
        }
    }

}
