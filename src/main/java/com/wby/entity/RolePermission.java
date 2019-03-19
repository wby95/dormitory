package com.wby.entity;

import javax.persistence.*;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:15:46
 **/

@Entity
@Table(name = "t_role_permission")
public class RolePermission {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "permissionId")
    private Permission permission;
}
