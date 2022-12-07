package com.miracle.worm_cat.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.constant.CacheKeys;
import com.miracle.worm_cat.common.constant.IgnoreUrl;
import com.miracle.worm_cat.common.domain.JwtUserInfo;
import com.miracle.worm_cat.common.response.RespResult;
import com.miracle.worm_cat.common.utils.JwtUtil;
import com.miracle.worm_cat.common.utils.RedisUtil;
import com.miracle.worm_cat.dto.system.staff.RolePermDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * author: Miracle-
 * time: 2022/11/25 20:07
 */
@Component
public class MiracleJwtFilter extends OncePerRequestFilter implements Ordered {

    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /*String uri = request.getRequestURI();
        String method = request.getMethod();
        PathMatcher pathMatcher = new AntPathMatcher();
        response.setContentType("text/json;charset=utf-8");
        // 1.判断请求 URL 是否是忽略的
        for (String url : IgnoreUrl.URLS) {
            if (pathMatcher.match(url, uri)) { filterChain.doFilter(request, response); return; }
        }
        //2.1.请求头中获取token
        String token = request.getHeader(BaseConstant.JWT_KEY);
        //2.2.从Cookie中获取token
        Cookie[] cookies = request.getCookies();
        if (null == token && null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (Objects.equals(cookie.getName(), "token")) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        //2.2.请求查询字符串参数中获取 token
        if (null == token) {
            token = request.getParameter(BaseConstant.JWT_KEY);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        if (StringUtils.isEmpty(token)) {
            response.getWriter().write(objectMapper.writeValueAsString(RespResult.logoutOrUnauthorized(null)));
        } else {
            Boolean tokenExpired = jwtUtil.isTokenExpired(token);
            //3.1.令牌过期处理
            if (tokenExpired) {
                response.getWriter().write(objectMapper.writeValueAsString(RespResult.logoutOrUnauthorized(null)));
                return;
            }
            //3.2.判断是否redis中的登录缓存是否更新过
            JwtUserInfo userInfo = jwtUtil.getUserFromToken(token);
            if (null != userInfo) {
                Long loginTime = (Long) redisUtil.get(CacheKeys.STAFF_JWT_START_TIME + userInfo.getUserid());
                if (loginTime > userInfo.getLoginTime()) {
                    response.getWriter().write(objectMapper.writeValueAsString(RespResult.logoutOrUnauthorized("登录信息已过期, 请重新登录")));
                    return;
                }
                //3.3.判断是否有权限访问
                boolean hasPermission = false;
                List<RolePermDTO> rolePerms = (List<RolePermDTO>) redisUtil.get(CacheKeys.ROLE_PERM_KEY + userInfo.getRoleId());
                if (null != rolePerms && rolePerms.size() > 0) {
                    for (RolePermDTO rolePerm : rolePerms) {
                        if (pathMatcher.match(rolePerm.getPermUri(), uri) && method.equals(rolePerm.getReqMethod())) {
                            hasPermission = true;
                            break;
                        }
                    }
                }
                if (!hasPermission) {
                    response.getWriter().write(objectMapper.writeValueAsString(RespResult.accessForbidden(null)));
                    return;
                }

                Map<String, Object> extraParams = new HashMap<>();
                extraParams.put(BaseConstant.USER_ID, userInfo.getUserid());
                extraParams.put(BaseConstant.USER_NICKNAME, userInfo.getNickname());
                extraParams.put(BaseConstant.SUPER_ID, userInfo.getSuperId());
                extraParams.put(BaseConstant.USER_SCOPE, userInfo.getScopeKey());
                extraParams.put(BaseConstant.USER_ROLE_ID, userInfo.getRoleId());
                extraParams.put(BaseConstant.USER_ROLE_TYPE, userInfo.getRoleType());
                filterChain.doFilter(new ParamReqWrapper(request, extraParams), response);
                return;
            }
            response.getWriter().write(objectMapper.writeValueAsString(RespResult.accessForbidden(null)));
        }*/

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
