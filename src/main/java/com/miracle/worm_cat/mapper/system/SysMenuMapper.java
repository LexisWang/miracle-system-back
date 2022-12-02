package com.miracle.worm_cat.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.worm_cat.domain.system.SysMenu;
import com.miracle.worm_cat.dto.system.TreeOptsDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_menu(菜单表)】的数据库操作Mapper
* @createDate 2022-11-30 16:40:14
* @Entity com.miracle.worm_cat.domain.system.SysMenu
*/
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 获取可选择的菜单
     */
    List<TreeOptsDTO> menuOptsData(@Param("pid") Integer pid);
}




