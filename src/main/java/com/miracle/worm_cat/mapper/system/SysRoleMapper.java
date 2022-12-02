package com.miracle.worm_cat.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.worm_cat.domain.system.SysRole;
import com.miracle.worm_cat.dto.system.BaseOptsDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_role(部门角色)】的数据库操作Mapper
* @createDate 2022-11-21 20:46:38
* @Entity com.miracle.worm_cat.domain.system.SysRole
*/
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 获取可选择的角色
     */
    List<BaseOptsDTO> orgOptsData(@Param("orgId") Integer orgId);
}




