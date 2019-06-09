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
 * 宿舍信息
 * */
@Entity
@Table(name="t_domitory")
public class Domitory {

    @Id
    @GeneratedValue
    private Integer id; // 编号

    @Column
    private String floor; // 楼层


    @Column
    private String domitoryNo; // 宿舍号

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

    public Domitory(String floor, String domitoryNo) {
        this.floor = floor;
        this.domitoryNo = domitoryNo;
    }

    public Domitory() {
    }

    @Override
    public String toString() {
        return "Domitory{" +
                "id=" + id +
                ", floor='" + floor + '\'' +
                ", domitoryNo='" + domitoryNo + '\'' +
                '}';
    }
}