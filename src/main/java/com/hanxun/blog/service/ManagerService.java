package com.hanxun.blog.service;

/**
 * @author han xun
 * Date 2021/8/3 22:13
 * Description:
 */
public interface ManagerService {


    /**
     * 生成一个新的邀请码
     * @return 生成的邀请码
     */
    String generateInviteCode();

    /**
     * 新增一个motto
     * @return
     */
    Boolean addMotto();
}
