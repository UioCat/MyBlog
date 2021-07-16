package com.hanxun.blog.utils;


import java.util.Random;

/**
 * @author Alfred
 * @Description: 发送邮箱验证码工具类
 * @time 2021/7/16 16:01
 */
public class SendUtil {



    /**
     * 随机生成6位验证码
     */
    public static String getRandomCode (Integer code){
        Random random = new Random();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < code; i++) {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }
}
