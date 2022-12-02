package com.miracle.worm_cat.controller.system.dto;

import lombok.Data;

import java.util.List;

/**
 * author: Miracle-
 * time: 2022/11/21 18:57
 */
@Data
public class RoleParam {
    private Integer current = 1;
    private Integer size = 10;
    private String roleCode;
    private String roleName;
    private List<Integer> roleStatus;
    private List<Integer> orgIdCascade;
    private Long createTimeStart;
    private Long createTimeEnd;
    private String roleNames;
}
