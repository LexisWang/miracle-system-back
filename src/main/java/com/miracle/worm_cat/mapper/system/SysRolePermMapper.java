package com.miracle.worm_cat.mapper.system;

import com.miracle.worm_cat.domain.system.SysRolePerm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.worm_cat.dto.system.staff.RolePermDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_role_perm(角色权限(中间表))】的数据库操作Mapper
* @createDate 2022-11-30 17:09:33
* @Entity com.miracle.worm_cat.domain.system.SysRolePerm
*/
public interface SysRolePermMapper extends BaseMapper<SysRolePerm> {
    /**
     * 根据角色id获取权限Id
     */
    List<Integer> permsByRoleId(@Param("roleId") Integer roeId);

    /**
     * 根据角色id获取权限列表
     */
    List<RolePermDTO> authPermListByRole(@Param("roleId") Integer roeId);
}




