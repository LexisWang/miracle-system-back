package com.miracle.worm_cat.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.domain.JwtUserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    /**
     * 从令牌中获取用户信息
     */
    public JwtUserInfo getUserFromToken(String token) {
        JwtUserInfo userInfo;
        try {
            Claims claims = getClaimsFromToken(token);
            ObjectMapper objectMapper = new ObjectMapper();
            userInfo = objectMapper.readValue(objectMapper.writeValueAsString(claims), JwtUserInfo.class);
        } catch (Exception e) {
            userInfo = null;
        }
        return userInfo;
    }

    /**
     * 判断 token 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新 token 令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generatorToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     */
    public Boolean validateToken(String token, JwtUserInfo userInfo) {
        JwtUserInfo userFromToken = getUserFromToken(token);
        return (userInfo.getUserid().equals(userFromToken.getUserid())
                && !isTokenExpired(token));
    }

    /**
     * 从 claims 生成 令牌
     */
    public String generatorToken(Map<String, Object> claims) {
        Date expirationDate = new Date((System.currentTimeMillis() + BaseConstant.TOKEN_EXPIRATION));
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, BaseConstant.TOKEN_SIGNATURE_SECRET)
                .compact();
    }

    /**
     * 从令牌中获取数据
     */
    public Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(BaseConstant.TOKEN_SIGNATURE_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw e;
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

}
