package com.miracle.worm_cat.controller.system.dto;

import lombok.Data;

import java.util.List;

/**
 * author: Miracle-
 * time: 2022/11/21 18:57
 */
@Data
public class OrgParam {
    private Integer current = 1;
    private Integer size = 10;
    private String orgCode;
    private String orgName;
    private List<Integer> orgStatus;
    private List<Integer> pidCascade;
    private Long createTimeStart;
    private Long createTimeEnd;
    private String orgNames;
}
