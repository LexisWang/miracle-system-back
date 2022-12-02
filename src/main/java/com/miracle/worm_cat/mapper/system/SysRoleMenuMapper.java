package com.miracle.worm_cat.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.worm_cat.domain.system.SysRoleMenu;
import com.miracle.worm_cat.dto.system.staff.RoleMenuDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_role_menu(角色菜单(中间表))】的数据库操作Mapper
* @createDate 2022-11-30 17:09:33
* @Entity com.miracle.worm_cat.domain.system.SysRoleMenu
*/
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    /**
     * 根据角色id获取菜单
     */
    List<Integer> menusByRoleId(@Param("roleId") Integer roeId);

    /**
     * 根据角色id获取菜单列表
     */
    List<RoleMenuDTO> authMenuListByRole(@Param("roleId") Integer roeId,
                                         @Param("pId") Integer pId);
}




