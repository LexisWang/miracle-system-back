package com.miracle.worm_cat.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * author: Miracle-
 * time: 2022/10/25 21:51
 */
@Data
@AllArgsConstructor
public class RespResult<T> {

    private Integer code;
    private String msg;
    private Boolean success;
    private T data;

    /**
     * 无 Data 成功的返回
     */
    public static <T> RespResult<T> success() {
        return new RespResult<>(
                ResultCode.SUCCESS.getCode(),
                ResultCode.SUCCESS.getMsg(),
                ResultCode.SUCCESS.getSuccess(),
                null
        );
    }

    /**
     * 无 Data, 自定义 Msg 成功的返回
     */
    public static <T> RespResult<T> success(String msg) {
        return new RespResult<>(
                ResultCode.SUCCESS.getCode(),
                msg,
                ResultCode.SUCCESS.getSuccess(),
                null
        );
    }

    /**
     * 有 Data 成功的返回
     */
    public static <T> RespResult<T> success(T data) {
        return new RespResult<>(
                ResultCode.SUCCESS.getCode(),
                ResultCode.SUCCESS.getMsg(),
                ResultCode.SUCCESS.getSuccess(),
                data
        );
    }

    /**
     * 有 Data, 自定义 Msg 成功的返回
     */
    public static <T> RespResult<T> success(T data, String msg) {
        return new RespResult<>(
                ResultCode.SUCCESS.getCode(),
                msg,
                ResultCode.SUCCESS.getSuccess(),
                data
        );
    }

    /**
     * 无 Data 失败的返回
     */
    public static <T> RespResult<T> failure(Integer errCode) {
        return new RespResult<>(
                errCode,
                ResultCode.FAILURE.getMsg(),
                ResultCode.FAILURE.getSuccess(),
                null
        );
    }

    /**
     * 无 Data, 自定义 Msg 失败的返回
     */
    public static <T> RespResult<T> failure(Integer errCode, String msg) {
        return new RespResult<>(
                errCode,
                msg,
                ResultCode.FAILURE.getSuccess(),
                null
        );
    }

    /**
     * 有 Data 失败的返回
     */
    public static <T> RespResult<T> failure(Integer errCode, T data) {
        return new RespResult<>(
                errCode,
                ResultCode.FAILURE.getMsg(),
                ResultCode.FAILURE.getSuccess(),
                data
        );
    }

    /**
     * 有 Data, 自定义 Msg 失败的返回
     */
    public static <T> RespResult<T> failure(Integer errCode, String msg, T data) {
        return new RespResult<>(
                errCode,
                msg,
                ResultCode.FAILURE.getSuccess(),
                data
        );
    }

    /**
     * 请求参数错误的返回
     */
    public static <T> RespResult<T> validateFailed(T data) {
        return new RespResult<>(
                ResultCode.VALIDATE_FAILED.getCode(),
                ResultCode.VALIDATE_FAILED.getMsg(),
                ResultCode.VALIDATE_FAILED.getSuccess(),
                data
        );
    }

    /**
     * 未登录或登陆过期的返回
     */
    public static <T> RespResult<T> logoutOrUnauthorized(T data) {
        return new RespResult<>(
                ResultCode.UNAUTHORIZED.getCode(),
                ResultCode.UNAUTHORIZED.getMsg(),
                ResultCode.UNAUTHORIZED.getSuccess(),
                data
        );
    }

    /**
     * 无访问权限的返回
     */
    public static <T> RespResult<T> accessForbidden(T data) {
        return new RespResult<>(
                ResultCode.FORBIDDEN.getCode(),
                ResultCode.FORBIDDEN.getMsg(),
                ResultCode.FORBIDDEN.getSuccess(),
                data
        );
    }

}
