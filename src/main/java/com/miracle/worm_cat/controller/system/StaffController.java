package com.miracle.worm_cat.controller.system;

import com.miracle.worm_cat.common.response.RespResult;
import com.miracle.worm_cat.dto.system.staff.LoginDTO;
import com.miracle.worm_cat.dto.system.staff.LoginResDTO;
import com.miracle.worm_cat.validate.AddGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: Miracle-
 * time: 2022/10/26 22:29
 */
@RestController
@RequestMapping(value = "system/admin")
public class StaffController {

    /**
     * 职员登陆
     */
    @PostMapping(value = "staffLogin")
    public RespResult<LoginResDTO> staffLogin(@RequestBody @Validated({AddGroup.class}) LoginDTO loginData) {
        LoginResDTO resDTO = new LoginResDTO();

        resDTO.setNickname("Miracle-");
        resDTO.setJwtToken("iweoiriweiwioerw");
        List<LoginResDTO.MenuResDTO> permMenus = new ArrayList<>();
        LoginResDTO.MenuResDTO home = new LoginResDTO.MenuResDTO();
        home.setName("home");
        home.setChildren(Arrays.asList(new LoginResDTO.MenuResDTO("order", null), new LoginResDTO.MenuResDTO("cargo", null)));
        LoginResDTO.MenuResDTO about = new LoginResDTO.MenuResDTO("about", null);
        permMenus.add(home);
        permMenus.add(about);
        resDTO.setPermMenus(permMenus);

        return RespResult.success(resDTO);
    }

}
