package com.hanxun.blog;

import com.hanxun.blog.config.GeneratorConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class BlogApplicationTests {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Test
    public void codeGenerator(){
        String[] tableArray = {"article", "comment", "motto", "tourist", "invite_code", "star_record"};
        String packageName = "com.hanxun.blog";
        String superClass = "com.hanxun.blog.entity.base.BaseDO";
        String author = "han xun";
        GeneratorConfig.genDal(tableArray, packageName, superClass, author, url, username, password);
    }

    @Test
    public void uuidTest() {
        String code = UUID.randomUUID().toString();
        System.out.println(code);
    }
}
