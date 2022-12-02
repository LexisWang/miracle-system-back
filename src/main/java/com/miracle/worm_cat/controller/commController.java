package com.miracle.worm_cat.controller;

import com.miracle.worm_cat.common.response.RespResult;
import com.miracle.worm_cat.dto.UserDTO;
import com.miracle.worm_cat.validate.AddGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author: Miracle-
 * time: 2022/10/25 21:43
 */
@RestController
@RequestMapping(value = "")
public class commController {

    /**
     * 项目跟路径
     */
    @GetMapping(value = "")
    public RespResult<?> rootResource() {
        return RespResult.success("You are access rootResource");
    }

    /**
     * 测试校验器
     */
    @PostMapping(value = "checkValidated")
    public RespResult<?> checkValidated(@RequestBody @Validated({AddGroup.class}) UserDTO userDTO) {
        return RespResult.success("Test validated success");
    }

}
