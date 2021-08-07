package com.hanxun.blog.controller.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author han xun
 * Date 2021/7/28 21:51
 * Description:
 */
@Getter
@Setter
@ToString
public class TouristLoginReq {

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

}
