package com.miracle.worm_cat.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miracle.worm_cat.domain.system.SysPerm;
import com.miracle.worm_cat.service.system.SysPermService;
import com.miracle.worm_cat.mapper.system.SysPermMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【sys_perm(权限表)】的数据库操作Service实现
* @createDate 2022-11-21 20:46:38
*/
@Service
public class SysPermServiceImpl extends ServiceImpl<SysPermMapper, SysPerm>
    implements SysPermService{

}




