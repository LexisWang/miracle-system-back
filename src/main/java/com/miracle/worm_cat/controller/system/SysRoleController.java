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
import com.miracle.worm_cat.controller.system.dto.RoleParam;
import com.miracle.worm_cat.domain.system.*;
import com.miracle.worm_cat.dto.system.BaseOptsDTO;
import com.miracle.worm_cat.mapper.system.SysRoleButtonMapper;
import com.miracle.worm_cat.mapper.system.SysRoleMapper;
import com.miracle.worm_cat.mapper.system.SysRoleMenuMapper;
import com.miracle.worm_cat.mapper.system.SysRolePermMapper;
import com.miracle.worm_cat.service.system.*;
import com.miracle.worm_cat.validate.AddGroup;
import com.miracle.worm_cat.validate.UpdateGroup;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * author: Miracle-
 * time: 2022/11/21 18:54
 */
@RestController
@RequestMapping(value = "/system-mgr/sys-role")
public class SysRoleController {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private SysRoleMapper roleMapper;
    @Resource
    private SysRolePermMapper rolePermMapper;
    @Resource
    private SysRoleMenuMapper roleMenuMapper;
    @Resource
    private SysRoleButtonMapper roleButtonMapper;

    @Resource
    private SysRoleService roleService;
    @Resource
    private SysOrgService orgService;
    @Resource
    private SysRolePermService rolePermService;
    @Resource
    private SysRoleMenuService roleMenuService;
    @Resource
    private SysRoleButtonService roleButtonService;

    @Resource
    private StaffController staffController;

    /**
     * 获取角色选择
     */
    @PostMapping(value = "roleOptsData")
    public RespResult<List<BaseOptsDTO>> roleOptsData(@RequestParam(value = "flush", defaultValue = "false") Boolean flush,
                                                      @RequestParam(value = "orgId") Integer orgId) {
        String cacheKey = CacheKeys.ROLE_OPTS_KEY + orgId;
        List<BaseOptsDTO> roleOptsList;
        if (flush) {
            roleOptsList = roleMapper.orgOptsData(orgId);
            redisUtil.set(cacheKey, roleOptsList);
        } else {
            boolean exists = redisUtil.exists(cacheKey);
            if (exists) {
                roleOptsList = (List<BaseOptsDTO>) redisUtil.get(cacheKey);
            } else {
                roleOptsList = roleMapper.orgOptsData(orgId);
                redisUtil.set(cacheKey, roleOptsList);
            }
        }
        return RespResult.success(roleOptsList);
    }

    /**
     * 判断角色名或角色代码是否重复
     */
    @PostMapping(value = "checkExist")
    public RespResult<CheckResult> checkOrgExist(@RequestBody SysRole role) {
        CheckResult checkRes = new CheckResult(false, "");
        boolean needCheckCode = !StringUtils.isEmpty(role.getRoleCode());
        boolean needCheckName = !StringUtils.isEmpty(role.getRoleCode());
        boolean needCheckSortNo = null != role.getSortNo() && role.getSortNo() > 0;
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        if (null == role.getId()) {
            if (needCheckCode) {
                wrapper.eq(SysRole::getRoleCode, role.getRoleCode())
                        .eq(SysRole::getOrgId, role.getOrgId());
                int count = roleService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "角色代码重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysRole::getRoleName, role.getRoleName())
                        .eq(SysRole::getOrgId, role.getOrgId());
                int count = roleService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "角色名称重复");
                }
                wrapper.clear();
            }
            if (needCheckSortNo) {
                wrapper.eq(SysRole::getSortNo, role.getSortNo())
                        .eq(SysRole::getOrgId, role.getOrgId());
                int count = roleService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "排序号重复");
                }
                wrapper.clear();
            }
        } else {
            if (needCheckCode) {
                wrapper.eq(SysRole::getRoleCode, role.getRoleCode())
                        .eq(SysRole::getOrgId, role.getOrgId())
                        .ne(SysRole::getId, role.getId());
                int count = roleService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "角色代码重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysRole::getRoleName, role.getRoleName())
                        .eq(SysRole::getOrgId, role.getOrgId())
                        .ne(SysRole::getId, role.getId());
                int count = roleService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "角色名称重复");
                }
                wrapper.clear();
            }
            if (needCheckSortNo) {
                wrapper.eq(SysRole::getSortNo, role.getSortNo())
                        .eq(SysRole::getOrgId, role.getOrgId())
                        .ne(SysRole::getId, role.getId());
                int count = roleService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "排序号重复");
                }
                wrapper.clear();
            }
        }
        return RespResult.success(checkRes);
    }

    /**
     * 角色新增
     */
    @PostMapping(value = "roleAddData")
    public RespResult<?> roleAddData(@RequestBody @Validated({AddGroup.class}) SysRole role,
                                     HttpServletRequest request) {
        Long userid = Long.valueOf(request.getParameter(BaseConstant.USER_ID));
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        //1.校验是否重复
        CheckResult existResult = checkOrgExist(role).getData();
        if (existResult.getOk()) {
            return RespResult.validateFailed(existResult.getMsg());
        }

        //2.填充权限码
        SysOrg sysOrg = orgService.getById(role.getOrgId());
        if (role.getIsLeaf() == 1) {
            role.setScopeKey(sysOrg.getScopeKey() + "-" + role.getSortNo());
        } else {
            role.setScopeKey(sysOrg.getScopeKey());
        }

        //2.添加创建人和更新人
        role.setCreatorId(userid);
        role.setCreatorName(nickname);
        role.setUpdaterId(userid);
        role.setUpdaterName(nickname);

        roleService.save(role);
        roleOptsData(true, role.getOrgId());
        return RespResult.success();
    }

    /**
     * 角色删除
     */
    @DeleteMapping(value = "roleDeleteData")
    public RespResult<?> roleDeleteData(@RequestBody List<Integer> ids,
                                        @RequestParam("remark") String remark,
                                        HttpServletRequest request) {
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        LambdaUpdateWrapper<SysRole> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(SysRole::getRoleRemark, nickname.concat("(删除): ").concat(remark))
                .in(SysRole::getId, ids);
        roleService.update(updateWrapper);
        int effectRows = roleMapper.deleteBatchIds(ids);
        if (effectRows > 0) {
            roleOptsData(true, roleService.getById(ids.get(0)).getOrgId());
        }
        return RespResult.success();
    }

    /**
     * 角色修改
     */
    @PutMapping(value = "roleUpdateData")
    public RespResult<?> roleUpdateData(@RequestBody @Validated({UpdateGroup.class}) SysRole role,
                                        HttpServletRequest request) {
        Long userid = Long.valueOf(request.getParameter(BaseConstant.USER_ID));
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        //1.校验是否重复
        CheckResult existResult = checkOrgExist(role).getData();
        if (existResult.getOk()) {
            return RespResult.validateFailed(existResult.getMsg());
        }

        //2.填充权限码
        SysRole oldRole = roleMapper.selectById(role.getId());
        Integer orgId = role.getOrgId();
        if (null != role.getIsLeaf() && null != role.getSortNo() && null != role.getOrgId() &&
                (!oldRole.getOrgId().equals(orgId)
                        || !oldRole.getIsLeaf().equals(role.getIsLeaf())
                        || !oldRole.getSortNo().equals(role.getSortNo()))
        ) {
            SysOrg sysOrg = orgService.getById(role.getOrgId());
            if (role.getIsLeaf() == 1) {
                role.setScopeKey(sysOrg.getScopeKey() + "-" + role.getSortNo());
            } else {
                role.setScopeKey(sysOrg.getScopeKey());
            }
        }

        //3.添加更新人
        role.setUpdaterId(userid);
        role.setUpdaterName(nickname);
        role.setVersion(oldRole.getVersion());

        int effectRows = roleMapper.updateById(role);
        if (effectRows > 0) {
            roleOptsData(true, null == role.getOrgId() ? oldRole.getOrgId(): role.getOrgId());
        }
        return RespResult.success();
    }

    /**
     * 获取角色列表数据
     */
    @PostMapping(value = "rolePageData")
    public RespResult<Page<SysRole>> rolePageData(@RequestBody RoleParam param) {
        Page<SysRole> rolePage = new Page<>(param.getCurrent(), param.getSize());
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isBlank(param.getRoleCode())) {
            wrapper.like(SysRole::getRoleCode, param.getRoleCode().trim());
        }
        if (!StringUtils.isBlank(param.getRoleName())) {
            wrapper.like(SysRole::getRoleName, param.getRoleName().trim());
        }
        if (null != param.getRoleStatus()) {
            if (param.getRoleStatus().size() == 1) {
                wrapper.eq(SysRole::getRoleStatus, param.getRoleStatus().get(0));
            } else if (param.getRoleStatus().size() > 1) {
                wrapper.in(SysRole::getRoleStatus, param.getRoleStatus());
            }
        }
        if (null != param.getOrgIdCascade()) {
            if (param.getOrgIdCascade().size() == 1) {
                wrapper.eq(SysRole::getOrgId, param.getOrgIdCascade().get(0));
            } else if (param.getOrgIdCascade().size() > 1) {
                wrapper.in(SysRole::getOrgId, param.getOrgIdCascade());
            }
        }
        wrapper.ge(null != param.getCreateTimeStart(), SysRole::getCreateTime, param.getCreateTimeStart());
        wrapper.lt(null != param.getCreateTimeEnd(), SysRole::getCreateTime, param.getCreateTimeEnd());
        if (!StringUtils.isBlank(param.getRoleNames())) {
            String[] splitRes = param.getRoleNames().split(" ");
            wrapper.in(SysRole::getOrgName, Arrays.asList(splitRes));
        }
        wrapper.orderByDesc(SysRole::getCreateTime);
        return RespResult.success(roleService.page(rolePage, wrapper));
    }

    /**
     * 角色导出
     */
    @PostMapping(value = "roleExportData")
    public void roleExportData(@RequestBody RoleParam param,
                               HttpServletResponse response) throws IOException {
        RespResult<Page<SysRole>> result = rolePageData(param);
        ExportRespUtil.setResponseHeader("角色信息.xls", response);
        ExcelWriterBuilder excelBookWriter = EasyExcel.write(response.getOutputStream(), SysOrg.class)
                .registerWriteHandler(ExportCellStyleStrategy.getStyleStrategy());
        ExcelWriterSheetBuilder sheetFirstWriter = excelBookWriter.sheet("角色");
        sheetFirstWriter.doWrite(result.getData().getRecords());
    }

    /**
     * 获取某一角色对应的权限
     */
    @PostMapping(value = "rolePerms/{roleId}")
    public RespResult<List<Integer>> rolePerms(@PathVariable(value = "roleId") Integer roleId) {
        List<Integer> rolePerms = rolePermMapper.permsByRoleId(roleId);
        return RespResult.success(rolePerms);
    }

    /**
     * 获取某一角色对应的菜单
     */
    @PostMapping(value = "roleMenus/{roleId}")
    public RespResult<List<Integer>> roleMenus(@PathVariable(value = "roleId") Integer roleId) {
        List<Integer> roleMenus = roleMenuMapper.menusByRoleId(roleId);
        return RespResult.success(roleMenus);
    }

    /**
     * 获取某一角色对应的按钮
     */
    @PostMapping(value = "roleButtons/{roleId}")
    public RespResult<List<Integer>> roleButtons(@PathVariable(value = "roleId") Integer roleId) {
        List<Integer> roleButtons = roleButtonMapper.buttonsByRoleId(roleId);
        return RespResult.success(roleButtons);
    }

    /**
     * 更新某一角色的权限
     */
    @PutMapping(value = "rolePerms/{roleId}")
    public RespResult<?> rolePerms(@PathVariable(value = "roleId") Integer roleId,
                                   @RequestBody @Validated({UpdateGroup.class}) List<SysRolePerm> rolePerms) {
        //1.删除原数据
        LambdaQueryWrapper<SysRolePerm> updateWrapper = new LambdaQueryWrapper<>();
        updateWrapper.eq(SysRolePerm::getRoleId, roleId);
        rolePermService.remove(updateWrapper);
        //2.新增数据
        rolePermService.saveBatch(rolePerms);
        staffController.getLoginStaffPerms(roleId, true);
        return RespResult.success();
    }

    /**
     * 更新某一角色的菜单
     */
    @PutMapping(value = "roleMenus/{roleId}")
    public RespResult<?> roleMenus(@PathVariable(value = "roleId") Integer roleId,
                                   @RequestBody @Validated({UpdateGroup.class}) List<SysRoleMenu> roleMenus) {
        //1.删除原数据
        LambdaQueryWrapper<SysRoleMenu> updateWrapper = new LambdaQueryWrapper<>();
        updateWrapper.eq(SysRoleMenu::getRoleId, roleId);
        roleMenuService.remove(updateWrapper);
        //2.新增数据
        roleMenuService.saveBatch(roleMenus);
        staffController.getLoginStaffMenus(roleId, true);
        return RespResult.success();
    }

    /**
     * 更新某一角色的按钮
     */
    @PutMapping(value = "roleButtons/{roleId}")
    public RespResult<?> roleButtons(@PathVariable(value = "roleId") Integer roleId,
                                     @RequestBody @Validated({UpdateGroup.class}) List<SysRoleButton> roleButtons) {
        //1.删除原数据
        LambdaQueryWrapper<SysRoleButton> updateWrapper = new LambdaQueryWrapper<>();
        updateWrapper.eq(SysRoleButton::getRoleId, roleId);
        roleButtonService.remove(updateWrapper);
        //2.新增数据
        roleButtonService.saveBatch(roleButtons);
        staffController.getLoginStaffButtons(roleId, true);
        return RespResult.success();
    }

}
