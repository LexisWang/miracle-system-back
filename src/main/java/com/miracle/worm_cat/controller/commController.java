package com.miracle.worm_cat.controller;

import com.miracle.worm_cat.common.domain.JwtUserInfo;
import com.miracle.worm_cat.common.domain.dto.FileUploadDto;
import com.miracle.worm_cat.common.response.RespResult;
import com.miracle.worm_cat.dto.UserDTO;
import com.miracle.worm_cat.validate.AddGroup;
import com.miracle.worm_cat.web_socket.WebSocketServer;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * author: Miracle-
 * time: 2022/10/25 21:43
 */
@RestController
@RequestMapping(value = "")
public class commController {

    @Resource
    private WebSocketServer socketServer;

    /**
     * 项目跟路径
     */
    @PostMapping(value = "")
    public RespResult<?> rootResource(FileUploadDto uploadDto, HttpServletRequest request) {
        JwtUserInfo reqUser = (JwtUserInfo) request.getAttribute("reqUser");
        System.out.println("&&&&&&&&&&-" + reqUser);
        try {
            WebSocketServer.sendInfo("You are access rootResource" + LocalDateTime.now(), 1L);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
