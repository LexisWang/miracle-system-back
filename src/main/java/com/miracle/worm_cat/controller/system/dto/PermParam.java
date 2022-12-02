package com.miracle.worm_cat.controller.system.dto;

import lombok.Data;

import java.util.List;

/**
 * author: Miracle-
 * time: 2022/11/21 18:57
 */
@Data
public class PermParam {
    private Integer current = 1;
    private Integer size = 10;
    private String permCode;
    private String permName;
    private List<Integer> permStatus;
    private List<Integer> pidCascade;
    private Long createTimeStart;
    private Long createTimeEnd;
    private String permNames;
}
