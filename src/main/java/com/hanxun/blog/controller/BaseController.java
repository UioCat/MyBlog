package com.hanxun.blog.controller;

import com.hanxun.blog.entity.base.UserToken;
import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.exception.CustomException;
import com.hanxun.blog.utils.ThreadLocalUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author han xun
 * Date 2021/8/1 18:50
 * Description:
 */
@RestController
public class BaseController {

//    @GetMapping("/index")
//    public String index() {
//        return "success";
//    }

    public Long getUserId() {
        UserToken currentUser = ThreadLocalUtil.getCurrentUser();
        if (null == currentUser || null == currentUser.getUserId()) {
            throw new CustomException(BackEnum.UNAUTHORIZED);
        }
        return currentUser.getUserId();
    }
}
