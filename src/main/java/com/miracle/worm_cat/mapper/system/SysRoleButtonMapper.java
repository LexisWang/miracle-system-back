package com.miracle.worm_cat.mapper.system;

import com.miracle.worm_cat.domain.system.SysRoleButton;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.worm_cat.dto.system.staff.RoleButtonDTO;
import com.miracle.worm_cat.dto.system.staff.RolePermDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_role_button(角色按钮(中间表))】的数据库操作Mapper
* @createDate 2022-11-30 17:26:01
* @Entity com.miracle.worm_cat.domain.system.SysRoleButton
*/
public interface SysRoleButtonMapper extends BaseMapper<SysRoleButton> {
    /**
     * 根据角色id获取按钮
     */
    List<Integer> buttonsByRoleId(@Param("roleId") Integer roeId);

    /**
     * 根据角色id获取按钮列表
     */
    List<RoleButtonDTO> authButtonListByRole(@Param("roleId") Integer roeId);
}




