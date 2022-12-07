package com.miracle.worm_cat.mapper.system;

import com.miracle.worm_cat.domain.system.SysStaff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miracle.worm_cat.dto.system.BaseOptsDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_staff(部门职员)】的数据库操作Mapper
* @createDate 2022-11-21 20:46:38
* @Entity com.miracle.worm_cat.domain.system.SysStaff
*/
public interface SysStaffMapper extends BaseMapper<SysStaff> {
    /**
     * 获取各类型职员选项数据
     */
    List<BaseOptsDTO> staffOptsData(@Param("roleCategory") Integer roleCategory,
                                    @Param("staffStatus") Integer staffStatus);

    /**
     * 获取所有领导选项数据
     */
    List<BaseOptsDTO> staffSuperData();

    /**
     * 获取领导手下的组员
     */
    List<BaseOptsDTO> staffCrewsData(@Param("superId") Long superId);
}




