package com.wby.service;

import com.wby.entity.Role;


/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/
public interface RoleService {
    /**
     * 根据用户id查角色
     * @param userId
     * @return
     */
    Role findByUserId(Integer userId);


    /**
     * 根据id查角色
     * @param id
     * @return
     */
    Role findById(Integer id);
}
