package com.hanxun.blog.controller.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author han xun
 * Date 2021/8/7 12:58
 * Description:
 */
@Getter
@Setter
@ToString
public class SetMottoReq {
    /**
     * motto内容
     */
    private String content;
}
