package com.hanxun.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author han xun
 * Date 2021/7/26 20:47
 * Description: 邀请码表
 */
@Data
@TableName("invitation_code")
public class InvitationCodeDO implements Serializable {
    private static final long serialVersionUID = 4169798286821698229L;
}
