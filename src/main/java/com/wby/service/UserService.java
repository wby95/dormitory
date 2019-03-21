package com.wby.service;

import com.wby.entity.User;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    /**
     * 根据条件分页查询角色信息
     * @param user
     * @param page
     * @param pageSize
     * @param direction
     * @param property
     * @return
     */
    public List<User> userList(User user, Integer page, Integer pageSize, Sort.Direction direction,String ...property);


    /**
     * 查询总的记录数
     * @param user
     * @return
     */
    public Long getTotalCount(User user);


    /**
     * 保存用户
     * @param user
     */
    public void saveUser(User user);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUser(Integer id);

    /**
     * 根据id查询用户
     * @param id
     */
    public User findById(Integer id);
}
