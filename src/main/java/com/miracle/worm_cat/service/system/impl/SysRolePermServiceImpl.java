package com.miracle.worm_cat.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miracle.worm_cat.domain.system.SysRolePerm;
import com.miracle.worm_cat.service.system.SysRolePermService;
import com.miracle.worm_cat.mapper.system.SysRolePermMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【sys_role_perm(角色权限(中间表))】的数据库操作Service实现
* @createDate 2022-11-30 17:09:33
*/
@Service
public class SysRolePermServiceImpl extends ServiceImpl<SysRolePermMapper, SysRolePerm>
    implements SysRolePermService{

}




