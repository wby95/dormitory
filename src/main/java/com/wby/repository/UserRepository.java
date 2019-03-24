package com.wby.repository;

import com.wby.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:16:38
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    @Query(value="SELECT u.* FROM t_user u WHERE u.`id`=?1",nativeQuery=true)
    User findByUserId(Integer id);


    @Query(value="select u.id from t_user u where id in( select tur.user_id from t_user_role tur where role_id=3)",nativeQuery=true)
    List<String> findAllStu();


}
