package com.wby.service.impl;


import com.wby.entity.UserRole;
import com.wby.repository.UserRoleRepository;
import com.wby.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/
@Service(value = "userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {


    @Resource
    UserRoleRepository userRoleRepository;

    @Override
    public void deleteByUserId(Integer userId) {
        userRoleRepository.deleteByUserId(userId);
    }


    /**
     * 保存用户角色
     * @param userRole
     */
    @Override
    public void saveRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}
