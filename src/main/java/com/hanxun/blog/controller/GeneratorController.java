package com.hanxun.blog.controller;

import com.hanxun.blog.config.GeneratorConfig;
import com.hanxun.blog.dto.CodeGeneratorDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generator")
public class GeneratorController {

    @PostMapping("/codeGenerator")
    public void codeGenerator(@RequestBody CodeGeneratorDTO codeGeneratorDTO){

        GeneratorConfig.genDal(codeGeneratorDTO.getMode(),codeGeneratorDTO.getTables());
        GeneratorConfig.genService(codeGeneratorDTO.getTables());
    }

}
