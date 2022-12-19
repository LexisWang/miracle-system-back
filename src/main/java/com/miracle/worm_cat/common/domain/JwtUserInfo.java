package com.miracle.worm_cat.common.domain;

import lombok.Builder;
import lombok.Data;

/**
 * author: Miracle-
 * time: 2022/12/6 22:26
 */
@Data
@Builder
public class JwtUserInfo {
    private Long userid;
    private String nickname;
    private Long superId;
    private String scopeKey;
    private Integer roleId;
    private Integer roleType;
    private Long loginTime;
    private Long exp;
}
