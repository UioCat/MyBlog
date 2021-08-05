package com.hanxun.blog.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Alfred
 * @Description: 管理员配置
 * @time 2021/8/5 17:01
 */

@Component
@Data
@PropertySource(value = {"classpath:admin-config.yml"})
public class AdminConfig {

    @Value("admin.id")
    private Long id;
}
