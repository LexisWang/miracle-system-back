package com.miracle.worm_cat.controller.system.dto;

import lombok.Data;

import java.util.List;

/**
 * author: Miracle-
 * time: 2022/11/21 18:57
 */
@Data
public class ButtonParam {
    private Integer current = 1;
    private Integer size = 10;
    private String code;
    private String name;
    private List<Integer> menuIdCascade;
    private List<Integer> sortNo;
}
