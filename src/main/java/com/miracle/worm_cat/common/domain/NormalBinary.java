package com.miracle.worm_cat.common.domain;

import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.exception.MiracleException;

/**
 * author: Miracle-
 * time: 2022/11/27 0:54
 */
public enum NormalBinary {
    DISABLED(0, "否"),
    AVAILABLE(1, "是");


    private final Integer value;
    private final String label;

    NormalBinary(Integer value, String label) {
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
            case 0:
                return DISABLED.getLabel();
            case 1:
                return AVAILABLE.getLabel();
            default:
                throw new MiracleException(BaseConstant.RESPONSE_CODE_FAILURE, value + "对应的文字不存在");
        }
    }
}
