package com.miracle.worm_cat.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.constant.CacheKeys;
import com.miracle.worm_cat.common.response.RespResult;
import com.miracle.worm_cat.common.utils.RedisUtil;
import com.miracle.worm_cat.domain.system.SysOrg;
import com.miracle.worm_cat.domain.system.SysStaff;
import com.miracle.worm_cat.dto.system.TreeOptsDTO;
import com.miracle.worm_cat.dto.system.staff.*;
import com.miracle.worm_cat.mapper.system.SysRoleButtonMapper;
import com.miracle.worm_cat.mapper.system.SysRoleMenuMapper;
import com.miracle.worm_cat.mapper.system.SysRolePermMapper;
import com.miracle.worm_cat.service.system.SysOrgService;
import com.miracle.worm_cat.service.system.SysStaffService;
import com.miracle.worm_cat.validate.AddGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * author: Miracle-
 * time: 2022/10/26 22:29
 */
@RestController
@RequestMapping(value = "system/admin")
public class StaffController {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private SysRolePermMapper rolePermMapper;
    @Resource
    private SysRoleMenuMapper roleMenuMapper;
    @Resource
    private SysRoleButtonMapper roleButtonMapper;

    @Resource
    private SysStaffService staffService;
    @Resource
    private SysOrgService orgService;

    /**
     * 职员登录
     */
    @PostMapping(value = "staffLogin")
    public RespResult<LoginResDTO> staffLogin(@RequestBody @Validated({AddGroup.class}) LoginDTO loginData) throws JsonProcessingException {
        /*LambdaQueryWrapper<SysStaff> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysStaff::getUsername, loginData.getUsername()).last("LIMIT 1");
        SysStaff staff = staffService.getOne(wrapper);
        if (null == staff) {
            return RespResult.failure(BaseConstant.PARAM_VALIDATE_FAIL, "账号不存在");
        } else if (staff.getStaffStatus() == 0) {
            return RespResult.failure(BaseConstant.PARAM_VALIDATE_FAIL, "该账户已被冻结，请联系管理员");
        } else {
            //密码错误的处理 todo
        }
        //1.获取该角色下的权限list
        Integer roleId = staff.getRoleId();
        List<RolePermDTO> rolePerms;
        boolean existsPerm = redisUtil.exists(CacheKeys.ROLE_PERM_KEY.concat(roleId.toString()));
        if (existsPerm) {
            rolePerms = (List<RolePermDTO>) redisUtil.get(CacheKeys.ROLE_PERM_KEY.concat(roleId.toString()));
        } else {
            rolePerms = rolePermMapper.authPermListByRole(roleId);
            if (null != rolePerms && rolePerms.size() > 0) {
                redisUtil.set(CacheKeys.ROLE_PERM_KEY.concat(roleId.toString()), rolePerms);
            }
        }
        //2.获取该角色下的菜单tree
        List<RoleMenuDTO> roleMenus;
        boolean existsMenu = redisUtil.exists(CacheKeys.ROLE_MENU_KEY.concat(roleId.toString()));
        if (existsMenu) {
            roleMenus = (List<RoleMenuDTO>) redisUtil.get(CacheKeys.ROLE_MENU_KEY.concat(roleId.toString()));
        } else {
            roleMenus = roleMenuMapper.authMenuListByRole(roleId, 0);
            menuChildren(roleMenus, roleId);
            if (roleMenus.size() > 0) {
                redisUtil.set(CacheKeys.ROLE_MENU_KEY.concat(roleId.toString()), roleMenus);
            }
        }
        //3.获取该角色下的按钮list
        List<RoleButtonDTO> roleButtons;
        boolean existsButton = redisUtil.exists(CacheKeys.ROLE_BUTTON_KEY.concat(roleId.toString()));
        if (existsButton) {
            roleButtons = (List<RoleButtonDTO>) redisUtil.get(CacheKeys.ROLE_BUTTON_KEY.concat(roleId.toString()));
        } else {
            roleButtons = roleButtonMapper.authButtonListByRole(roleId);
            if (null != roleButtons && roleButtons.size() > 0) {
                redisUtil.set(CacheKeys.ROLE_BUTTON_KEY.concat(roleId.toString()), roleButtons);
            }
        }*/

        LoginResDTO resDTO = new LoginResDTO();

        resDTO.setNickname("奇迹哥");
        resDTO.setJwtToken("iweoiriweiwioerw");

        String permMenusStr = "[\n" +
                "  {\n" +
                "    \"name\": \"home\",\n" +
                "    \"children\": [\n" +
                "      { \"name\": \"commonHome\" },\n" +
                "      {\n" +
                "        \"name\": \"system\",\n" +
                "        \"children\": [\n" +
                "          { \"name\": \"organization\" },\n" +
                "          { \"name\": \"permission\" },\n" +
                "          { \"name\": \"menu\" },\n" +
                "          { \"name\": \"button\" },\n" +
                "          { \"name\": \"role\" }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"order\",\n" +
                "        \"children\": [\n" +
                "          { \"name\": \"orderTrack\" },\n" +
                "          { \"name\": \"orderFund\" }\n" +
                "        ]\n" +
                "      },\n" +
                "      { \"name\": \"cargo\" }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        ObjectMapper objectMapper = new ObjectMapper();
        List<LoginResDTO.MenuResDTO> permMenus = (List<LoginResDTO.MenuResDTO>) objectMapper.readValue(permMenusStr, List.class);
        resDTO.setPermMenus(permMenus);

        return RespResult.success(resDTO);
    }

    /**
     * 创建person数据
     */
    @PostMapping(value = "createPerson")
    public RespResult<?> createPerson(@RequestBody SysOrg org) {
        orgService.save(org);
        return RespResult.success();
    }

    /**
     * 递归获取菜单选项
     */
    private void menuChildren(List<RoleMenuDTO> data, Integer roleId) {
        for (RoleMenuDTO datum : data) {
            List<RoleMenuDTO> children = roleMenuMapper.authMenuListByRole(roleId, datum.getId());
            if (null == children || children.size() == 0) {
                datum.setChildren(new ArrayList<>());
            } else {
                menuChildren(children, roleId);
                datum.setChildren(children);
            }
        }
    }

}
