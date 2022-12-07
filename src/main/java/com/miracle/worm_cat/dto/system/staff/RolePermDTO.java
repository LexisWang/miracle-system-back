package com.miracle.worm_cat.dto.system.staff;

import lombok.Data;

import java.io.Serializable;

/**
 * author: Miracle-
 * time: 2022/12/2 14:16
 */
@Data
public class RolePermDTO implements Serializable {
    private String permUri;
    private String reqMethod;

    private static final long serialVersionUID = 1L;
}
