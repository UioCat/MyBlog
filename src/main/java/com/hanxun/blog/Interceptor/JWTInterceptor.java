package com.hanxun.blog.Interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.hanxun.blog.exception.CustomException;
import com.hanxun.blog.utils.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor implements HandlerInterceptor {

    private final static Logger log= LoggerFactory.getLogger(JWTInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            throw new CustomException("token不能为空");
        }
        try {
            JWTUtil.verify(token);
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

}
