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

    private String date;

    @Column
    private String visitorName;

    private Integer state;

    public Integer getState() {
        return state;
    }
    //https://blog.csdn.net/cr4blm123/article/details/49998563
    //https://ask.csdn.net/questions/695195

    public void setState(Integer state) {
        this.state = state;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}