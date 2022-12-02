package com.miracle.worm_cat.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.worm_cat.domain.system.SysButton;
import com.miracle.worm_cat.dto.system.TreeOptsDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_button(按钮配置表)】的数据库操作Mapper
* @createDate 2022-11-30 17:26:01
* @Entity com.miracle.worm_cat.domain.system.SysButton
*/
public interface SysButtonMapper extends BaseMapper<SysButton> {
    /**
     * 获取某一菜单下的所有按钮
     */
    List<TreeOptsDTO> buttonsByMenuId(@Param("menuId") Integer menuId);
}




