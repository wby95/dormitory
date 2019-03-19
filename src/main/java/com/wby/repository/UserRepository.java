package com.wby.repository;

import com.wby.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:16:38
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserName(String userName);
}
