package com.hanxun.blog.dto;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Alfred
 * @Description: 邮件发送类
 * @time 2021/7/15 18:42
 */
public class ToEmail implements Serializable {

    /**
     * 邮件接收方，可多人
     */
    private String[] tos;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;

    public String[] getTos() {
        return tos;
    }

    public void setTos(String[] tos) {
        this.tos = tos;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ToEmail{" +
                "tos=" + Arrays.toString(tos) +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
