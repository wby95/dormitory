package com.wby.entity;


import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id; // 编号

    @NotEmpty(message = "请输入用户名!")
    @Column(length=50)
    private String userName; // 用户名

    @NotEmpty(message = "请输入密码!")
    @Column(length=50)
    private String password; // 密码

    @Column(length=50)
    private String trueName; // 真实姓名

    @Transient
    private String roles; // 所拥有的角色

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "domitoryId" ,nullable = true)
    private Domitory domitory;

    public Domitory getDomitory() {
        return domitory;
    }

    public void setDomitory(Domitory domitory) {
        this.domitory = domitory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", trueName='" + trueName + '\'' +
                ", roles='" + roles + '\'' +
                ", domitory=" + domitory+
                '}';
    }
}
