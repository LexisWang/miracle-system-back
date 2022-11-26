package com.miracle.worm_cat.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miracle.worm_cat.domain.system.BimTask;
import com.miracle.worm_cat.service.system.BimTaskService;
import com.miracle.worm_cat.mapper.system.BimTaskMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【bim_task(定时任务)】的数据库操作Service实现
* @createDate 2022-11-21 20:46:38
*/
@Service
public class BimTaskServiceImpl extends ServiceImpl<BimTaskMapper, BimTask>
    implements BimTaskService{

}




