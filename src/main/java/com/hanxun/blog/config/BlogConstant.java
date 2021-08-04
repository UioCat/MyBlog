package com.hanxun.blog.config;

/**
 * @author han xun
 * Date 2021/7/25 23:34
 * Description:
 */
public interface BlogConstant {

    /**
     * 邮箱过滤正则
     */
    String regex = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";

    /**
     * 发送邮件间隔时间
     */
    Integer mailIntervalTime = 60;

    /**
     * 发送邮件有效时间
     */
    Integer mailValidTime = 60 * 20;

    /**
     * 验证码发送主题
     */
    String mailSubject = "注册验证码";

    /**
     * 删除
     */
    Byte DELETE = 1;
}
