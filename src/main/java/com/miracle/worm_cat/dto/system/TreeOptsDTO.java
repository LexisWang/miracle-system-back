package com.miracle.worm_cat.dto.system;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * author: Miracle-
 * time: 2022/11/25 21:01
 */
@Data
public class TreeOptsDTO implements Serializable {
    private Integer value;
    private String label;
    private String scopeKey;
    private List<TreeOptsDTO> children;

    private static final long serialVersionUID = 1L;
}
