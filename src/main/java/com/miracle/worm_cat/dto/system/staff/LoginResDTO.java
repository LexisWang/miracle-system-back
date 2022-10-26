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

    private String nickname;

    private List<MenuResDTO> permMenus;

    private String jwtToken;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MenuResDTO {
        private String name;
        private List<MenuResDTO> children;
    }

}
