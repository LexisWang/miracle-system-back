package com.miracle.worm_cat.common.constant;

import java.time.format.DateTimeFormatter;

/**
 * author: Miracle-
 * time: 2022/10/25 21:48
 */
public interface BaseConstant {

    /** 职员默认密码 */
    String STAFF_INIT_PWD = "A123456";

    /** JWT参数名 */
    String JWT_KEY = "Authorization";

    DateTimeFormatter DATE_TIME_FORMATTER_HYPHEN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter DATE_FORMATTER_HYPHEN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter DATE_TIME_FORMATTER_SLASH = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    DateTimeFormatter DATE_FORMATTER_SLASH = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /** 解析后的用户参数 */
    String USER_ID = "USER_ID";
    String USER_NICKNAME = "USER_NICKNAME'";
    String SUPER_ID = "SUPER_ID";
    String USER_SCOPE = "USER_SCOPE";
    String USER_ROLE_ID = "USER_ROLE_ID";
    String USER_ROLE_TYPE = "USER_ROLE_TYPE";

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
