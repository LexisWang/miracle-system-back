package com.miracle.worm_cat.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.worm_cat.domain.system.SysPerm;
import com.miracle.worm_cat.dto.system.TreeOptsDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_perm(权限表)】的数据库操作Mapper
* @createDate 2022-11-30 15:57:36
* @Entity com.miracle.worm_cat.domain.system.SysPerm
*/
public interface SysPermMapper extends BaseMapper<SysPerm> {
    /**
     * 获取可选择的权限
     */
    List<TreeOptsDTO> permOptsData(@Param("pid") Integer pid);
}




