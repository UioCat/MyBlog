package com.hanxun.blog.dto;

import lombok.Data;

@Data
public class CodeGeneratorDTO {


    /**
     * 主键设定：1：id主键-snowflake, 2: id主键-自增, 3: 不使用id作为主键
     */
    private String mode;

    /**
     * 表名，多个英文逗号分割
     */
    private String[] tables;
}
