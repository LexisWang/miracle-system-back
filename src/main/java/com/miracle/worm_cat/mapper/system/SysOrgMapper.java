package com.miracle.worm_cat.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.worm_cat.domain.system.SysOrg;
import com.miracle.worm_cat.dto.system.TreeOptsDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_org(部门组织)】的数据库操作Mapper
* @createDate 2022-11-21 20:46:38
* @Entity com.miracle.worm_cat.domain.system.SysOrg
*/
public interface SysOrgMapper extends BaseMapper<SysOrg> {
    /**
     * 获取可选择的部门组织
     */
    List<TreeOptsDTO> orgOptsData(@Param("pid") Integer pid);
}




