package com.miracle.worm_cat.dto.system.staff;

import lombok.Data;

import java.util.List;

/**
 * author: Miracle-
 * time: 2022/12/2 14:16
 */
@Data
public class RoleMenuDTO {
    private Integer id;
    private String name;
    private List<RoleMenuDTO> children;
}
