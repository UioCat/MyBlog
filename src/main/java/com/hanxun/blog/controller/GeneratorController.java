package com.hanxun.blog.controller;

import com.hanxun.blog.config.GeneratorConfig;
import com.hanxun.blog.dto.CodeGeneratorDTO;
import com.hanxun.blog.dto.GeneratorDataInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generator")
public class GeneratorController {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    @PostMapping("/codeGenerator")
    public void codeGenerator(@RequestBody CodeGeneratorDTO codeGeneratorDTO){
        GeneratorDataInfo generatorDataInfo = new GeneratorDataInfo();
        generatorDataInfo.setUrl(url);
        generatorDataInfo.setUsername(username);
        generatorDataInfo.setPassword(password);
        GeneratorConfig.genDal(codeGeneratorDTO.getMode(),codeGeneratorDTO.getTables(), generatorDataInfo);
        GeneratorConfig.genService(codeGeneratorDTO.getTables(), generatorDataInfo);
    }

}
