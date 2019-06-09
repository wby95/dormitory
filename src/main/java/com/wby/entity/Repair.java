package com.wby.entity;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/21 0021
 * Time:18:36
 **/


import javax.persistence.*;

/**
 * Created by wby on 2018/4/6.
 */
/*
 * 来访人
 * */
@Entity
@Table(name = "t_repair")
public class Repair {

    @Id
    @GeneratedValue
    private Integer id; // 编号

    @Column
    private String domitoryNum;

    @Column
    private String repairContent;

    @Column
    private String date;

    @Column
    private String userName;

    @Column
    private String password;

    private Integer state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDomitoryNum() {
        return domitoryNum;
    }

    public void setDomitoryNum(String domitoryNum) {
        this.domitoryNum = domitoryNum;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}