package com.wby.service;

import com.wby.entity.Role;
import com.wby.entity.UserRole;


/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/
public interface UserRoleService {

    public void deleteByUserId(Integer userId);

    /**
     * 保存用户角色
     * @param userRole
     */
    public void saveRole(UserRole userRole);
}
