package com.hanxun.blog.Interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hanxun.blog.entity.base.UserToken;
import com.hanxun.blog.utils.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Slf4j
public class JWTInterceptor implements HandlerInterceptor {


    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${jwt.key}")
    private String jwtKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            log.warn("用户为游客用户");
            return true;
        }
        try {
            DecodedJWT decodedJWT = null;
            Long userId = null;

            try {
                decodedJWT = JWT.require(Algorithm.HMAC256(jwtKey)).build().verify(token);
                userId = decodedJWT.getClaim("id").asLong();
            } catch (JWTVerificationException e) {
                log.warn("解析Token异常：{}，token={}", e.getMessage(), token);
            }

            if (null == userId) {
                return false;
            }

            String tokenKey = "token:" + userId;

            UserToken userToken = (UserToken) redisTemplate.opsForValue().get(tokenKey);

            if (userToken != null && userToken.getId().equals(decodedJWT.getId()) && userId.equals(userToken.getUserId())) {

                /**
                 * 此时Token是合法的Token，需要进行续约操作
                 */
                this.redisTemplate.expire(tokenKey, TimeUnit.MINUTES.toSeconds(30),
                        TimeUnit.SECONDS);

                //TODO 把当前用户的身份信息，存储到当前请求的上下文，以便在Controller中获取 （例如存储到：ThreadLocal）
                ThreadLocalUtil.addCurrentUser(userToken);
                return true;
            }

        } catch (SignatureVerificationException e) {
            log.error("无效签名！ 错误 ->", e);
            return false;
        } catch (TokenExpiredException e) {
            log.error("token过期！ 错误 ->", e);
            return false;
        } catch (AlgorithmMismatchException e) {
            log.error("token算法不一致！ 错误 ->", e);
            return false;
        } catch (Exception e) {
            log.error("token无效！ 错误 ->", e);
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.removeCurrentUser();
    }
}
