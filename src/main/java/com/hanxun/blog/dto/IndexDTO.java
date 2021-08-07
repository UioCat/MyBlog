package com.hanxun.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author han xun
 * Date 2021/8/7 12:25
 * Description:
 */
@Getter
@Setter
@ToString
public class IndexDTO {

    /**
     * 博客标题
     */
    private String title;

    /**
     * motto
     */
    private String motto;
}
