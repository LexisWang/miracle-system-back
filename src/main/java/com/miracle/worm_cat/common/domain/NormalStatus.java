package com.miracle.worm_cat.common.domain;

import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.exception.MiracleException;

/**
 * author: Miracle-
 * time: 2022/11/27 0:54
 */
public enum NormalStatus {
    DEFAULT(-1, "默认"),
    DISABLED(0, "禁用"),
    AVAILABLE(1, "启用");


    private final Integer value;
    private final String label;

    NormalStatus(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static String getLabelByValue(Integer value) {
        switch (value) {
            case -1:
                return DEFAULT.getLabel();
            case 0:
                return DISABLED.getLabel();
            case 1:
                return AVAILABLE.getLabel();
            default:
                throw new MiracleException(BaseConstant.RESPONSE_CODE_FAILURE, value + "对应的文字不存在");
        }
    }
}
