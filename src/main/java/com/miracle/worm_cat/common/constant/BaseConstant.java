package com.miracle.worm_cat.common.constant;

/**
 * author: Miracle-
 * time: 2022/10/25 21:48
 */
public interface BaseConstant {

    /** 加密 Token 的密钥 */
    String TOKEN_SIGNATURE_SECRET = "-lx7b@9nzhat9rtdp986f(kbdg35m0fkj$zif_)y5!v7lm=y@o";

    /** Token有效时间，7天(单位毫秒) */
    Long TOKEN_EXPIRATION = 7 * 24 * 3600_000L;

    /** 响应状态码 */
    Integer RESPONSE_CODE_SUCCESS = 200;
    Integer RESPONSE_CODE_FAILURE = 500;
    Integer BIND_EXCEPTION = 418;
    Integer PARAM_VALIDATE_FAIL = 400;
    Integer LOGOUT_OR_UNAUTHORIZED = 401;
    Integer ACCESS_FORBIDDEN = 403;

}
