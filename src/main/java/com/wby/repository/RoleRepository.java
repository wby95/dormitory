package com.wby.repository;

import com.wby.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:16:38
 **/
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    /**
     * 根据用户id查角色
     * @param userId
     * @return
     */
    @Query(value="SELECT r.* FROM t_user u,t_role r,t_user_role ur WHERE ur.`user_id`=u.`id` AND ur.`role_id`=r.`id` AND u.`id`=?1",nativeQuery=true)
    Role findByUserId(Integer userId);

    @Query(value="SELECT r.* FROM t_role r WHERE r.`id`=?1",nativeQuery=true)
    Role findOne(Integer id);
}
