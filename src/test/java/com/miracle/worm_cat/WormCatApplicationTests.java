package com.miracle.worm_cat;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.password_encode.PasswordEncoder;
import com.miracle.worm_cat.common.utils.EncryptUtil;
import com.miracle.worm_cat.domain.system.SysStaff;
import com.miracle.worm_cat.mapper.system.SysOrgMapper;
import com.miracle.worm_cat.service.system.SysOrgService;
import com.miracle.worm_cat.service.system.SysStaffService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WormCatApplicationTests {

    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private SysStaffService staffService;

    @Test
    void contextLoads() {
        LambdaUpdateWrapper<SysStaff> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(SysStaff::getPassword, passwordEncoder.encode(EncryptUtil.Md5Encrypt(BaseConstant.STAFF_INIT_PWD)))
                .eq(SysStaff::getId, 1);
        staffService.update(wrapper);
    }

}
