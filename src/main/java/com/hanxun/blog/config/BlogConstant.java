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
    String REGEX = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";

    /**
     * 发送邮件间隔时间
     */
    Integer MAIL_INTERVAL_TIME = 60;

    /**
     * 发送邮件有效时间
     */
    Integer MAIL_VALID_TIME = 60 * 5;

    /**
     * 验证码发送主题
     */
    String MAIL_SUBJECT = "注册验证码";

    /**
     * 删除
     */
    Byte DELETE = 1;

    /**
     * 未删除
     */
    Byte EXIST = 0;

    /**
     * 首页缓存key
     */
    String INDEX_KEY = "index";

    /**
     * 首页缓存时间
     */
    Integer INDEX_CACHE_TIME = 60 * 20;

    /**
     * 登陆
     */
    Integer LOGIN_TYPE = 1;


}
