package com.wby.service.impl;

import com.wby.entity.User;
import com.wby.repository.UserRepository;
import com.wby.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    /**
     * 根据userName查询用户
     * @param userName
     * @return
     */
    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }



}
