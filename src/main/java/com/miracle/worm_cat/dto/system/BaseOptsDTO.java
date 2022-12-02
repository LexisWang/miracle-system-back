package com.miracle.worm_cat.dto.system;

import lombok.Data;

import java.io.Serializable;

/**
 * author: Miracle-
 * time: 2022/11/25 21:01
 */
@Data
public class BaseOptsDTO implements Serializable {
    private Integer value;
    private String label;

    private static final long serialVersionUID = 1L;
}
