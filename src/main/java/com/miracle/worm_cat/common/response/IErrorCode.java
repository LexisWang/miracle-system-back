package com.miracle.worm_cat.common.response;

/**
 * author: Miracle-
 * time: 2022/10/25 21:46
 */
public interface IErrorCode {
    Integer getCode();

    String getMsg();

    default Boolean getSuccess() {
        return true;
    }
}
