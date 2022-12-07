package com.miracle.worm_cat.dto.system.staff;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * author: Miracle-
 * time: 2022/12/2 14:16
 */
@Data
public class RoleMenuDTO implements Serializable {
    private Integer id;
    private String name;
    private List<RoleMenuDTO> children;

    private static final long serialVersionUID = 1L;
}
