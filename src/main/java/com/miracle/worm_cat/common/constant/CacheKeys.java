package com.miracle.worm_cat.common.constant;

import java.util.HashMap;
import java.util.Map;

public interface CacheKeys {
    /** 组织选项key */
    String ORG_OPTS_KEY = "ORG-OPTS-KEY";
    /** 权限选项key */
    String PERM_OPTS_KEY = "PERM-OPTS-KEY";
    /** 菜单选项key */
    String MENU_OPTS_KEY = "MENU-OPTS-KEY";
    /** 按钮选项key */
    String BUTTON_OPTS_KEY = "BUTTON-OPTS-KEY";
    /** 角色选项key */
    String ROLE_OPTS_KEY = "ROLE-OPTS-KEY->";
    /** 某一角色的权限key */
    String ROLE_PERM_KEY = "ROLE-PERM-KEY->";
    /** 某一角色的菜单key */
    String ROLE_MENU_KEY = "ROLE-MENU-KEY->";
    /** 某一角色的按钮key */
    String ROLE_BUTTON_KEY = "ROLE-BUTTON-KEY->";

    /** 开发者职员key */
    String DEVELOPER_STAFF_KEY = "DEVELOPER-STAFF-KEY";
    /** 业务职员key */
    String SALESMAN_STAFF_KEY = "SALESMAN-STAFF-KEY";
    /** 关务职员key */
    String SERVICE_STAFF_KEY = "SERVICE-STAFF-KEY";
    /** 操作职员key */
    String OPERATE_STAFF_KEY = "OPERATE-STAFF-KEY";
    /** 仓务职员key */
    String STORE_STAFF_KEY = "STORE-STAFF-KEY";
    /** 质检职员key */
    String AUDITOR_STAFF_KEY = "AUDITOR-STAFF-KEY";
    /** 财务职员key */
    String FINANCE_STAFF_KEY = "FINANCE-STAFF-KEY";
    Map<Integer, String> ROLE_CATEGORY_OPTS = new HashMap<Integer, String>(){{
        put(1, DEVELOPER_STAFF_KEY);
        put(5, SALESMAN_STAFF_KEY);
        put(10, SERVICE_STAFF_KEY);
        put(15, OPERATE_STAFF_KEY);
        put(20, STORE_STAFF_KEY);
        put(25, AUDITOR_STAFF_KEY);
        put(30, FINANCE_STAFF_KEY);
    }};

    /** 职员登录token时间缓存key */
    String STAFF_JWT_START_TIME = "STAFF-JWT-START-TIME->";

}
