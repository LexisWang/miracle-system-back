package com.miracle.worm_cat.dto.system.staff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author: Miracle-
 * time: 2022/10/26 22:34
 */
@Data
public class LoginResDTO {

    private Long userid;
    private String nickname;
    private Long superId;

    private List<RoleMenuDTO> roleMenus;
    private List<RoleButtonDTO> roleButtons;
    private String jwtToken;

}
