package com.miracle.worm_cat.controller.system;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miracle.worm_cat.common.response.RespResult;
import com.miracle.worm_cat.domain.system.SysOrg;
import com.miracle.worm_cat.dto.system.staff.LoginDTO;
import com.miracle.worm_cat.dto.system.staff.LoginResDTO;
import com.miracle.worm_cat.service.system.SysOrgService;
import com.miracle.worm_cat.validate.AddGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @Resource
    private SysOrgService orgService;

    /**
     * 职员登陆
     */
    @PostMapping(value = "staffLogin")
    public RespResult<LoginResDTO> staffLogin(@RequestBody @Validated({AddGroup.class}) LoginDTO loginData) throws JsonProcessingException {
        LoginResDTO resDTO = new LoginResDTO();

        resDTO.setNickname("奇迹哥");
        resDTO.setJwtToken("iweoiriweiwioerw");

        String permMenusStr = "[\n" +
                "  {\n" +
                "    \"name\": \"home\",\n" +
                "    \"children\": [\n" +
                "      { \"name\": \"commonHome\" },\n" +
                "      {\n" +
                "        \"name\": \"system\",\n" +
                "        \"children\": [\n" +
                "          { \"name\": \"organization\" }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"order\",\n" +
                "        \"children\": [\n" +
                "          { \"name\": \"orderTrack\" },\n" +
                "          { \"name\": \"orderFund\" }\n" +
                "        ]\n" +
                "      },\n" +
                "      { \"name\": \"cargo\" }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        ObjectMapper objectMapper = new ObjectMapper();
        List<LoginResDTO.MenuResDTO> permMenus = (List<LoginResDTO.MenuResDTO>) objectMapper.readValue(permMenusStr, List.class);
        resDTO.setPermMenus(permMenus);

        return RespResult.success(resDTO);
    }

    /**
     * 创建person数据
     */
    @PostMapping(value = "createPerson")
    public RespResult<Object> createPerson(@RequestBody SysOrg org) {
        orgService.save(org);
        return RespResult.success();
    }

}
