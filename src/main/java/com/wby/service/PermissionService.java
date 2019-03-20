package com.wby.service;

import com.wby.entity.Permission;
import com.wby.entity.Role;

import java.util.List;


/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/
public interface PermissionService {


    /**
     * 根据父节点以及用户角色id查询子节点
     * @param pId
     * @param roleId
     * @return
     */
    public List<Permission> findByPIdAndRoleId(int pId,int roleId);



}
