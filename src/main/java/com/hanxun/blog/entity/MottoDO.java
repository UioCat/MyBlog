package com.hanxun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author han xun
 * Date 2021/7/26 20:46
 * Description: 座右铭字典
 */
@Data
@TableName("motto")
public class MottoDO implements Serializable {
    private static final long serialVersionUID = 6683011486378968607L;
}
