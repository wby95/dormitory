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
 * 来访人
 * */
@Entity
@Table(name = "t_visitor")
public class Visitor {

    @Id
    @GeneratedValue
    private Integer id; // 编号

    @Column
    private String name;

    @Column
    private String sex;

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    @Column
    private String phoneNum;

    private Date date;

    @Column
    private String visitorName;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    @JsonSerialize(using=CustomDateTimeSerializer.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}