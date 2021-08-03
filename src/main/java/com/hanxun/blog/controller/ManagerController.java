package com.hanxun.blog.controller;

import com.hanxun.blog.service.ManagerService;
import com.hanxun.blog.utils.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author han xun
 * Date 2021/7/25 23:12
 * Description: 管理员控制界面
 */
@RestController
@RequestMapping("admin")
public class ManagerController extends BaseController{

    @Autowired
    private ManagerService managerService;

    /**
     * 管理员登陆接口
     * @return
     */
    public BackMessage login() {
        return null;
    }

    /**
     * 设置邀请码接口
     * @return
     */
    public BackMessage getInviteCode() {
        return null;
    }

    /**
     * 新增motto接口
     * @return
     */
    public BackMessage setMotto() {
        return null;
    }

    /**
     * 查看motto列表接口
     * @return
     */
    public BackMessage getMottoList() {
        return null;
    }

    /**
     * 删除motto接口
     * @return
     */
    public BackMessage deleteMotto() {
        return null;
    }
}