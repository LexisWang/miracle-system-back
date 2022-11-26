package com.miracle.worm_cat.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miracle.worm_cat.domain.system.BimValue;
import com.miracle.worm_cat.service.system.BimValueService;
import com.miracle.worm_cat.mapper.system.BimValueMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【bim_value(配置字典值)】的数据库操作Service实现
* @createDate 2022-11-21 20:46:38
*/
@Service
public class BimValueServiceImpl extends ServiceImpl<BimValueMapper, BimValue>
    implements BimValueService{

}




