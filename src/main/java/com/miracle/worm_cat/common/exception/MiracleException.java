package com.miracle.worm_cat.common.exception;

/**
 * author: Miracle-
 * time: 2022/7/28 23:08
 */
public class MiracleException extends RuntimeException{

    private final Integer errCode;

    public MiracleException(Integer errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    public MiracleException(Integer errCode, Throwable cause) {
        super(cause);
        this.errCode = errCode;
    }

    public MiracleException(Integer errCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errCode = errCode;
    }

    public Integer getErrCode() {
        return errCode;
    }
}
