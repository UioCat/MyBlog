package com.hanxun.blog.utils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hanxun.blog.entity.ArticleDO;
import com.hanxun.blog.entity.TouristDO;
import com.hanxun.blog.entity.base.UserToken;
import com.hanxun.blog.exception.CustomException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


public class JWTUtil {


    /**
     * 获取token
     */
    public static String getToken(TouristDO user, UserToken userToken, String jwtKey, LocalDateTime issuedAt) {
        Map<String, Object> jwtHeader = new HashMap<>();
        jwtHeader.put("alg", "alg");
        jwtHeader.put("JWT", "JWT");
        String token = JWT.create()
                .withHeader(jwtHeader)
                // 把用户的id写入到token
                .withClaim("id", user.getId())
                .withIssuedAt(new Date(issuedAt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
                /**
                 * 这里不在Token上设置过期时间，过期时间由Redis维护
                 */
                // .withExpiresAt(new Date(expiresAt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
                // 使用生成的tokenId作为jwt的id
                .withJWTId(userToken.getId())
                .sign(Algorithm.HMAC256(jwtKey));
        return token;
    }


}
