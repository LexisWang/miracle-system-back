package com.miracle.worm_cat.controller.system;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miracle.worm_cat.common.config.easy_excel.ExportCellStyleStrategy;
import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.constant.CacheKeys;
import com.miracle.worm_cat.common.domain.CheckResult;
import com.miracle.worm_cat.common.domain.NormalStatus;
import com.miracle.worm_cat.common.password_encode.PasswordEncoder;
import com.miracle.worm_cat.common.response.RespResult;
import com.miracle.worm_cat.common.utils.EncryptUtil;
import com.miracle.worm_cat.common.utils.ExportRespUtil;
import com.miracle.worm_cat.common.utils.JwtUtil;
import com.miracle.worm_cat.common.utils.RedisUtil;
import com.miracle.worm_cat.controller.system.dto.StaffParam;
import com.miracle.worm_cat.controller.system.dto.StaffUpdPwdParam;
import com.miracle.worm_cat.domain.system.SysOrg;
import com.miracle.worm_cat.domain.system.SysRole;
import com.miracle.worm_cat.domain.system.SysStaff;
import com.miracle.worm_cat.dto.system.BaseOptsDTO;
import com.miracle.worm_cat.dto.system.staff.*;
import com.miracle.worm_cat.mapper.system.SysRoleButtonMapper;
import com.miracle.worm_cat.mapper.system.SysRoleMenuMapper;
import com.miracle.worm_cat.mapper.system.SysRolePermMapper;
import com.miracle.worm_cat.mapper.system.SysStaffMapper;
import com.miracle.worm_cat.service.system.SysOrgService;
import com.miracle.worm_cat.service.system.SysRoleService;
import com.miracle.worm_cat.service.system.SysStaffService;
import com.miracle.worm_cat.validate.AddGroup;
import com.miracle.worm_cat.validate.UpdateGroup;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * author: Miracle-
 * time: 2022/10/26 22:29
 */
@RestController
@RequestMapping(value = "/system-mgr/sys-staff")
public class StaffController {

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private SysRolePermMapper rolePermMapper;
    @Resource
    private SysRoleMenuMapper roleMenuMapper;
    @Resource
    private SysRoleButtonMapper roleButtonMapper;
    @Resource
    private SysStaffMapper staffMapper;

    @Resource
    private SysStaffService staffService;
    @Resource
    private SysRoleService roleService;
    @Resource
    private SysOrgService orgService;

    /**
     * 获取职员选项数据
     */
    @PostMapping(value = "staffOptsData")
    public RespResult<List<BaseOptsDTO>> staffOptsData(@RequestParam(value = "flush", defaultValue = "false") Boolean flush,
                                                       @RequestParam(value = "roleCategory", defaultValue = "false") Integer roleCategory) {
        String cacheKey = CacheKeys.ROLE_CATEGORY_OPTS.get(roleCategory);
        List<BaseOptsDTO> staffOptsList;
        if (flush) {
            staffOptsList = staffMapper.staffOptsData(roleCategory, NormalStatus.AVAILABLE.getValue());
            redisUtil.set(cacheKey, staffOptsList);
        } else {
            boolean exist = redisUtil.exists(cacheKey);
            if (exist) {
                staffOptsList = (List<BaseOptsDTO>) redisUtil.get(cacheKey);
            } else {
                staffOptsList = staffMapper.staffOptsData(roleCategory, NormalStatus.AVAILABLE.getValue());
                redisUtil.set(cacheKey, staffOptsList);
            }
        }
        return RespResult.success(staffOptsList);
    }

    /**
     * 判断账号名或账号代码是否重复
     * */
    @PostMapping(value = "checkExist")
    public RespResult<CheckResult> checkOrgExist(@RequestBody SysStaff staff) {
        CheckResult checkRes = new CheckResult(false, "");
        boolean needCheckCode = !StringUtils.isEmpty(staff.getUsername());
        boolean needCheckName = !StringUtils.isEmpty(staff.getNickname());
        LambdaQueryWrapper<SysStaff> wrapper = new LambdaQueryWrapper<>();
        if (null == staff.getId()) {
            if (needCheckCode) {
                wrapper.eq(SysStaff::getUsername, staff.getUsername());
                int count = staffService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "账号重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysStaff::getNickname, staff.getNickname());
                int count = staffService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "昵称重复");
                }
                wrapper.clear();
            }
        } else {
            if (needCheckCode) {
                wrapper.eq(SysStaff::getUsername, staff.getUsername())
                        .ne(SysStaff::getId, staff.getId());
                int count = staffService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "账号重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysStaff::getNickname, staff.getNickname())
                        .ne(SysStaff::getId, staff.getId());
                int count = staffService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "昵称重复");
                }
                wrapper.clear();
            }
        }
        return RespResult.success(checkRes);
    }

    /**
     * 职员新增
     */
    @PostMapping(value = "staffAddData")
    public RespResult<?> staffAddData(@RequestBody @Validated({AddGroup.class}) SysStaff staff,
                                      HttpServletRequest request) {
        Long userid = Long.valueOf(request.getParameter(BaseConstant.USER_ID));
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        //1.校验是否重复
        CheckResult existResult = checkOrgExist(staff).getData();
        if (existResult.getOk()) {
            return RespResult.validateFailed(existResult.getMsg());
        }

        //2.1.填充部门名称
        SysOrg sysOrg = orgService.getById(staff.getOrgId());
        staff.setOrgName(sysOrg.getOrgName());
        //2.2.填充初始密码
        staff.setPassword(passwordEncoder.encode(EncryptUtil.Md5Encrypt(BaseConstant.STAFF_INIT_PWD)));
        //2.2.添加创建人和更新人
        staff.setCreatorId(userid);
        staff.setCreatorName(nickname);
        staff.setUpdaterId(userid);
        staff.setUpdaterName(nickname);

        //3.保存数据生成ID
        staffService.save(staff);

        //4.填充权限码
        SysRole role = roleService.getById(staff.getRoleId());
        if (role.getIsLeaf() == 1) {
            staff.setScopeKey(role.getScopeKey() + "$" + staff.getId());
        } else {
            staff.setScopeKey(role.getScopeKey());
        }
        staffService.updateById(staff);

        staffOptsData(true, role.getRoleCategory());
        return RespResult.success();

    }

    /**
     * 职员删除
     */
    @DeleteMapping(value = "staffDeleteData")
    public RespResult<?> staffAddData(@RequestBody List<Long> ids,
                                      @RequestParam("remark") String remark,
                                      HttpServletRequest request) {
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        LambdaUpdateWrapper<SysStaff> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(SysStaff::getRemark, nickname.concat("(删除): ").concat(remark))
                .in(SysStaff::getId, ids);
        staffService.update(updateWrapper);
        int effectRows = staffMapper.deleteBatchIds(ids);
        if (effectRows > 0) {
            SysRole role = roleService.getById(staffService.getById(ids.get(0)));
            staffOptsData(true, role.getRoleCategory());
        }
        return RespResult.success();
    }

    /**
     * 职员修改
     */
    @PutMapping(value = "staffUpdateData")
    public RespResult<?> staffUpdateData(@RequestBody @Validated({UpdateGroup.class}) SysStaff staff,
                                         HttpServletRequest request) {
        Long userid = Long.valueOf(request.getParameter(BaseConstant.USER_ID));
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        //1.校验是否重复
        CheckResult existResult = checkOrgExist(staff).getData();
        if (existResult.getOk()) {
            return RespResult.validateFailed(existResult.getMsg());
        }

        //2.填充权限码
        SysStaff oldStaff = staffService.getById(staff.getId());
        SysRole role = roleService.getById(staff.getRoleId());
        if (null != staff.getRoleId() && !oldStaff.getRoleId().equals(staff.getRoleId())) {
            if (role.getIsLeaf() == 1) {
                staff.setScopeKey(role.getScopeKey() + "$" + staff.getId());
            } else {
                staff.setScopeKey(role.getScopeKey());
            }
        }

        //3.添加更新人
        staff.setUpdaterId(userid);
        staff.setUpdaterName(nickname);
        staff.setVersion(oldStaff.getVersion());

        int effectRows = staffMapper.updateById(staff);
        if (effectRows > 0) {
            staffOptsData(true, role.getRoleCategory());
        }
        return RespResult.success();
    }

    /**
     * 获取职员列表数据
     * */
    @PostMapping(value = "staffPageData")
    public RespResult<Page<SysStaff>> rolePageData(@RequestBody StaffParam param) {
        Page<SysStaff> rolePage = new Page<>(param.getCurrent(), param.getSize());
        LambdaQueryWrapper<SysStaff> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isBlank(param.getUsername())) {
            wrapper.like(SysStaff::getUsername, param.getUsername().trim());
        }
        if (!StringUtils.isBlank(param.getNickname())) {
            wrapper.like(SysStaff::getNickname, param.getNickname().trim());
        }
        wrapper.eq(null != param.getRoleId(), SysStaff::getRoleId, param.getRoleId());
        if (null != param.getStaffStatus()) {
            if (param.getStaffStatus().size() == 1) {
                wrapper.eq(SysStaff::getStaffStatus, param.getStaffStatus().get(0));
            } else if (param.getStaffStatus().size() > 1) {
                wrapper.in(SysStaff::getStaffStatus, param.getStaffStatus());
            }
        }
        if (null != param.getOrgIdCascade()) {
            if (param.getOrgIdCascade().size() == 1) {
                wrapper.eq(SysStaff::getOrgId, param.getOrgIdCascade().get(0));
            } else if (param.getOrgIdCascade().size() > 1) {
                wrapper.in(SysStaff::getOrgId, param.getOrgIdCascade());
            }
        }
        wrapper.ge(null != param.getCreateTimeStart(), SysStaff::getCreateTime, param.getCreateTimeStart());
        wrapper.lt(null != param.getCreateTimeEnd(), SysStaff::getCreateTime, param.getCreateTimeEnd());
        if (!StringUtils.isBlank(param.getNicknames())) {
            String[] splitRes = param.getNicknames().split(" ");
            wrapper.in(SysStaff::getOrgName, Arrays.asList(splitRes));
        }
        wrapper.orderByDesc(SysStaff::getCreateTime);
        return RespResult.success(staffService.page(rolePage, wrapper));
    }

    /**
     * 职员导出
     */
    @PostMapping(value = "staffExportData")
    public void roleExportData(@RequestBody StaffParam param,
                               HttpServletResponse response) throws IOException {
        RespResult<Page<SysStaff>> result = rolePageData(param);
        ExportRespUtil.setResponseHeader("职员信息.xls", response);
        ExcelWriterBuilder excelBookWriter = EasyExcel.write(response.getOutputStream(), SysStaff.class)
                .registerWriteHandler(ExportCellStyleStrategy.getStyleStrategy());
        ExcelWriterSheetBuilder sheetFirstWriter = excelBookWriter.sheet("职员");
        sheetFirstWriter.doWrite(result.getData().getRecords());
    }

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
        } else if (!passwordEncoder.matches(loginData.getPassword(), staff.getPassword())){
            return RespResult.failure(BaseConstant.PARAM_VALIDATE_FAIL, "密码错误");
        }
        //1.获取该角色下的权限list
        Integer roleId = staff.getRoleId();
        List<RolePermDTO> rolePerms = getLoginStaffPerms(roleId, false);
        //2.获取该角色下的菜单tree
        List<RoleMenuDTO> roleMenus = getLoginStaffMenus(roleId, false);
        //3.获取该角色下的按钮list
        List<RoleButtonDTO> roleButtons = getLoginStaffButtons(roleId, false);
        //4.组装JWT令牌
        Long loginTime = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        Map<String, Object> jwtMap = new HashMap<>();
        jwtMap.put("userid", staff.getId());
        jwtMap.put("nickname", staff.getNickname());
        jwtMap.put("superId", staff.getSuperId());
        jwtMap.put("scopeKey", staff.getScopeKey());
        jwtMap.put("roleId", staff.getRoleId());
        jwtMap.put("roleType", roleService.getById(staff.getRoleId()).getRoleCategory());
        jwtMap.put("loginTime", loginTime);
        String jwtToken = jwtUtil.generatorToken(jwtMap);

        LoginResDTO resDTO = new LoginResDTO();
        resDTO.setUserid(staff.getId());
        resDTO.setNickname(staff.getNickname());
        resDTO.setSuperId(staff.getSuperId());
        resDTO.setRoleMenus(roleMenus);
        resDTO.setRoleButtons(roleButtons);
        resDTO.setJwtToken(jwtToken);
        redisUtil.set(CacheKeys.STAFF_JWT_START_TIME + staff.getId(), loginTime);*/

        LoginResDTO resDTO = new LoginResDTO();
        resDTO.setRoleButtons(getLoginStaffButtons(1, false));

        resDTO.setNickname("奇迹哥");
        LambdaQueryWrapper<SysStaff> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysStaff::getUsername, loginData.getUsername()).last("LIMIT 1");
        SysStaff staff = staffService.getOne(wrapper);
        Long loginTime = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        Map<String, Object> jwtMap = new HashMap<>();
        jwtMap.put("userid", staff.getId());
        jwtMap.put("nickname", staff.getNickname());
        jwtMap.put("superId", staff.getSuperId());
        jwtMap.put("scopeKey", staff.getScopeKey());
        jwtMap.put("roleId", staff.getRoleId());
        jwtMap.put("roleType", roleService.getById(staff.getRoleId()).getRoleCategory());
        jwtMap.put("loginTime", loginTime);
        String jwtToken = jwtUtil.generatorToken(jwtMap);
        resDTO.setJwtToken(jwtToken);

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
                "          { \"name\": \"role\" },\n" +
                "          { \"name\": \"staff\" }\n" +
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
        List<RoleMenuDTO> permMenus = (List<RoleMenuDTO>) objectMapper.readValue(permMenusStr, List.class);
        resDTO.setRoleMenus(permMenus);

        return RespResult.success(resDTO);
    }

    /**
     * 重置密码
     */
    @PostMapping(value = "staffResetPwd")
    public RespResult<?> staffResetPwd(@RequestBody @Validated StaffUpdPwdParam param) {
        LambdaUpdateWrapper<SysStaff> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(SysStaff::getPassword, passwordEncoder.encode(EncryptUtil.Md5Encrypt(BaseConstant.STAFF_INIT_PWD)))
                .eq(SysStaff::getId, param.getId());
        staffService.update(wrapper);
        return RespResult.success();
    }

    /**
     * 修改密码
     */
    @PutMapping(value = "staffUpdatePwd")
    public RespResult<?> staffUpdatePwd(@RequestBody @Validated({AddGroup.class}) StaffUpdPwdParam param) {
        LambdaUpdateWrapper<SysStaff> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(SysStaff::getPassword, passwordEncoder.encode(param.getNewPwd()))
                .eq(SysStaff::getId, param.getId());
        staffService.update(wrapper);
        return RespResult.success();
    }

    /**
     * 获取所有可选择的领导
     */
    @PostMapping(value = "staffSuperData")
    public RespResult<?> staffSuperData() {
        List<BaseOptsDTO> superData = staffMapper.staffSuperData();
        return RespResult.success(superData);
    }

    /**
     * 获取领导的组员
     */
    @PostMapping(value = "staffCrewsData")
    public RespResult<?> staffCrewsData(@RequestParam(value = "superId") Long superId) {
        List<BaseOptsDTO> crewsData = staffMapper.staffCrewsData(superId);
        return RespResult.success(crewsData);
    }

    /**
     * 重置登录职员的token缓存信息
     */
    @PostMapping(value = "staffResetRedisLoginTime")
    public RespResult<?> staffResetRedisLoginTime(@RequestBody @Validated StaffUpdPwdParam param) {
        //修改该职员的登录token缓存
        String cacheKey = CacheKeys.STAFF_JWT_START_TIME + param.getId();
        boolean exists = redisUtil.exists(cacheKey);
        if (exists) {
            Long loginTime = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
            redisUtil.set(cacheKey, loginTime);
        }
        return RespResult.success();
    }

    /**
     * 1.获取该角色下的权限list
     */
    public List<RolePermDTO> getLoginStaffPerms(Integer roleId, Boolean flush) {
        String cacheKey = CacheKeys.ROLE_PERM_KEY.concat(roleId.toString());
        List<RolePermDTO> rolePerms = null;
        if (flush) {
            rolePerms = rolePermMapper.authPermListByRole(roleId);
            if (null != rolePerms && rolePerms.size() > 0) {
                redisUtil.set(cacheKey, rolePerms);
            }
        } else {
            boolean exists = redisUtil.exists(cacheKey);
            if (exists) {
                rolePerms = (List<RolePermDTO>) redisUtil.get(cacheKey);
            } else {
                getLoginStaffPerms(roleId, true);
            }
        }
        return rolePerms;
    }

    /**
     * 2.获取该角色下的菜单tree
     */
    public List<RoleMenuDTO> getLoginStaffMenus(Integer roleId, Boolean flush) {
        String cacheKey = CacheKeys.ROLE_MENU_KEY.concat(roleId.toString());
        List<RoleMenuDTO> roleMenus = null;
        if (flush) {
            roleMenus = roleMenuMapper.authMenuListByRole(roleId, 0);
            menuChildren(roleMenus, roleId);
            if (roleMenus.size() > 0) {
                redisUtil.set(cacheKey, roleMenus);
            }
        } else {
            boolean exists = redisUtil.exists(cacheKey);
            if (exists) {
                roleMenus = (List<RoleMenuDTO>) redisUtil.get(cacheKey);
            } else {
                getLoginStaffMenus(roleId, true);
            } 
        }
        return roleMenus;
    }

    /**
     * 3.获取该角色下的按钮list
     */
    public List<RoleButtonDTO> getLoginStaffButtons(Integer roleId, Boolean flush) {
        String cacheKey = CacheKeys.ROLE_BUTTON_KEY.concat(roleId.toString());
        List<RoleButtonDTO> roleButtons = null;
        if (flush) {
            roleButtons = roleButtonMapper.authButtonListByRole(roleId);
            if (null != roleButtons && roleButtons.size() > 0) {
                redisUtil.set(cacheKey, roleButtons);
            }
        } else {
            boolean exists = redisUtil.exists(cacheKey);
            if (exists) {
                roleButtons = (List<RoleButtonDTO>) redisUtil.get(cacheKey);
            } else {
                getLoginStaffButtons(roleId, true);
            }
        }
        return roleButtons;
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
