package com.wby.service;

import com.wby.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/

public interface UserService {

    /**
     * 根据userName查询用户
     * @param userName
     * @return
     */
    User findByUserName(String userName);

}
