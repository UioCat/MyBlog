package com.hanxun.blog.entity.base;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserToken implements Serializable {

    private static final long serialVersionUID = -4596822031364325529L;

    // token id
    private String id;

    // 用户id
    private Long userId;

    // ip
    private String ip;

    // 客户端
    private String userAgent;

    // 管理员
    private Boolean admin;

    // 授权时间
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime issuedAt;

    // 过期时间
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime expiresAt;

    // 是否记住我
    private boolean remember;
}
