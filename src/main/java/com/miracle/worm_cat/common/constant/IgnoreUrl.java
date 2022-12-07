package com.miracle.worm_cat.common.constant;

import java.util.Arrays;
import java.util.List;

/**
 * author: Miracle-
 * time: 2022/12/7 9:27
 */
public interface IgnoreUrl {

    /** 职员登录 */
    String LONG_URL = "/system-mgr/sys-staff/staffLogin";

    List<String> URLS = Arrays.asList(
            LONG_URL
    );
}
