package com.wby.entity;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/21 0021
 * Time:18:36
 **/


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wby on 2018/4/6.
 */
/*
 * 通知信息
 * */
@Entity
@Table(name="t_notice")
public class Notice {

    @Id
    @GeneratedValue
    private Integer id; // 编号

    @Column(length=500)
    private String title; // 标题

    @Lob
    @Column(columnDefinition="TEXT")
    private String content; // 帖子内容


    private Date uploadDate;


    @JsonSerialize(using=CustomDateTimeSerializer.class)
    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}