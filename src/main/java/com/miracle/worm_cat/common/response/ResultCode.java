package com.miracle.worm_cat.common.response;

import com.miracle.worm_cat.common.constant.BaseConstant;

/**
 * author: Miracle-
 * time: 2022/10/25 21:49
 */
public enum ResultCode implements IErrorCode{

    SUCCESS(BaseConstant.RESPONSE_CODE_SUCCESS, "操作成功"),
    FAILURE(BaseConstant.RESPONSE_CODE_FAILURE, "操作失败"),
    VALIDATE_FAILED(BaseConstant.PARAM_VALIDATE_FAIL, "参数校验错误"),
    BIND_EXCEPTION(BaseConstant.BIND_EXCEPTION, "参数类型错误"),
    UNAUTHORIZED(BaseConstant.LOGOUT_OR_UNAUTHORIZED, "未登录或登陆过期"),
    FORBIDDEN(BaseConstant.ACCESS_FORBIDDEN, "无访问权限");

    private final Integer code;
    private final String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
