package com.hanxun.blog.entity;

import java.util.Date;

/**
 * 博客文章实体类
 */
public class Article {

    /**
     * id 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 是否删除
     */
    private Byte isDelete;

    /**
     * 文章名
     */
    private String articleName;

    /**
     * label数组 使用,分割，最多两个
     */
    private String labelArrays;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 作者
     */
    private String author;

    /**
     * 浏览次数
     */
    private Long browseTimes;

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getLabelArrays() {
        return labelArrays;
    }

    public void setLabelArrays(String labelArrays) {
        this.labelArrays = labelArrays;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getBrowseTimes() {
        return browseTimes;
    }

    public void setBrowseTimes(Long browseTimes) {
        this.browseTimes = browseTimes;
    }
}
