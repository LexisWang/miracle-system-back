package com.miracle.worm_cat;

import com.miracle.worm_cat.domain.system.SysOrg;
import com.miracle.worm_cat.mapper.system.SysOrgMapper;
import com.miracle.worm_cat.service.system.SysOrgService;
import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class WormCatApplicationTests {

    @Resource
    private SysOrgMapper orgMapper;
    @Resource
    private SysOrgService orgService;

    @Test
    void contextLoads() {
    }

}
