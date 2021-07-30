package com.hanxun.blog.utils;

import com.hanxun.blog.entity.base.UserToken;

/**
 * @author Alfred
 * @Description: 存放用户信息
 * @time 2021/7/30 17:08
 */
public class ThreadLocalUtil {

    /**
     * 保存用户对象的ThreadLocal  在拦截器操作 添加、删除相关用户数据
     */
    private static final ThreadLocal<UserToken> userThreadLocal = new ThreadLocal<UserToken>();

    /**
     * 添加当前登录用户方法  在拦截器方法执行前调用设置获取用户
     * @param user
     */
    public static void addCurrentUser(UserToken user){
        userThreadLocal.set(user);
    }

    /**
     * 获取当前登录用户方法
     */
    public static UserToken getCurrentUser(){
        return userThreadLocal.get();
    }


    /**
     * 删除当前登录用户方法  在拦截器方法执行后 移除当前用户对象
     */
    public static void removeCurrentUser(){
        userThreadLocal.remove();
    }

}
