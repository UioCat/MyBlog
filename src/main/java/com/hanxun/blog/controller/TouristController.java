package com.hanxun.blog.controller;

import com.hanxun.blog.utils.BackMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author han xun
 * Date 2021/7/18 22:54
 * Description: 游客控制页
 */
@RestController
@RequestMapping("tourist")
public class TouristController {

    /**
     * 游客登陆
     * @return
     */
    @PostMapping("/login")
    public BackMessage login() {
        return null;
    }


    /**
     * 游客注册
     * @return
     */
    public BackMessage register() {
        return null;
    }

    /**
     * 评论
     * @return
     */
    public BackMessage comment() {
        return null;
    }

    /**
     * 游客点赞接口
     * @return
     */
    public BackMessage star() {
        return null;
    }
}
