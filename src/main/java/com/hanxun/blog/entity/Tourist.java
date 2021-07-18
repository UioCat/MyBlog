package com.hanxun.blog.entity;

public class Tourist {

    /**
     * id
     */
    private Long id;

    /**
     * 账号，默认为email
     */
    private String account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像图片
     */
    private String headPortraits;

    public Tourist() {
    }

    public String getHeadPortraits() {
        return headPortraits;
    }

    public void setHeadPortraits(String headPortraits) {
        this.headPortraits = headPortraits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
