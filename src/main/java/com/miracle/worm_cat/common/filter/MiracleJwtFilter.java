package com.miracle.worm_cat.common.filter;

import com.miracle.worm_cat.common.constant.BaseConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * author: Miracle-
 * time: 2022/11/25 20:07
 */
@Component
public class MiracleJwtFilter extends OncePerRequestFilter implements Ordered {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Map<String, Object> extraParams = new HashMap<>();
        extraParams.put(BaseConstant.USER_ID, 1);
        extraParams.put(BaseConstant.USER_NICKNAME, "奇迹哥");
        filterChain.doFilter(new ParamReqWrapper(request, extraParams), response);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
