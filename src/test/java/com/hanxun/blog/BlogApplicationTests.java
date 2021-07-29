package com.hanxun.blog;

import com.hanxun.blog.config.GeneratorConfig;
import com.hanxun.blog.dto.CodeGeneratorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void codeGenerator(){
        CodeGeneratorDTO codeGeneratorDTO = new CodeGeneratorDTO();
        codeGeneratorDTO.setMode("2");
        codeGeneratorDTO.setTables(new String[]{"article", "comment", "motto", "tourist"});
//        GeneratorConfig.genDal(codeGeneratorDTO.getMode(),codeGeneratorDTO.getTables());
//        GeneratorConfig.genService(codeGeneratorDTO.getTables());
    }
}
