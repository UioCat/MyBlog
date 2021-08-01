package com.hanxun.blog;

import com.hanxun.blog.config.GeneratorConfig;
import com.hanxun.blog.dto.GeneratorDataInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {
    }


    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Test
    public void codeGenerator(){
        String[] tableArray = {"article", "comment", "motto", "tourist"};

        GeneratorDataInfo generatorDataInfo = new GeneratorDataInfo();
        generatorDataInfo.setUrl(url);
        generatorDataInfo.setUsername(username);
        generatorDataInfo.setPassword(password);
        GeneratorConfig.genDal(tableArray,  generatorDataInfo);
    }
}
