package com.wby.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_demerit")
public class Demerit {

    @Id
    @GeneratedValue
    private Integer id; // 编号



    @Column
    private String floor; // 楼层


    @Column
    private String domitoryNo; // 宿舍号


    @Column
    private String sex;

    @Column
    private String name;
    @Column
    private String password;

    private Integer state;

    @Column
    private String date;

    @Column
    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDomitoryNo() {
        return domitoryNo;
    }

    public void setDomitoryNo(String domitoryNo) {
        this.domitoryNo = domitoryNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }




    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
