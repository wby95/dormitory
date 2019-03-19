package com.wby.entity;

import javax.persistence.*;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:35
 **/
@Entity
@Table(name = "t_permission")
public class Permission {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 100)
    private String iCon;

    @Column(length = 20)
    private String name;

    private Integer pId;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getiCon() {
        return iCon;
    }

    public void setiCon(String iCon) {
        this.iCon = iCon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", iCon='" + iCon + '\'' +
                ", name='" + name + '\'' +
                ", pId=" + pId +
                ", state=" + state +
                '}';
    }
}
