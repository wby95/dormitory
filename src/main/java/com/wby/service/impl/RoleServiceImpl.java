package com.wby.service.impl;

import com.wby.entity.Role;
import com.wby.entity.User;
import com.wby.repository.RoleRepository;
import com.wby.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleRepository roleRepository;

    /**
     * 根据用户id查角色
     * @param userId
     * @return
     */
    @Override
    public Role findByUserId(Integer userId) {
        return roleRepository.findByUserId(userId);
    }


    /**
     * 根据id查角色
     * @param id
     * @return
     */
    @Override
    public Role findById(Integer id) {
       return roleRepository.findOne(id);
    }
}
