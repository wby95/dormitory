package com.wby.repository;

import com.wby.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:16:38
 **/

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer>, JpaSpecificationExecutor<UserRole> {

/**
 * 根据用户id删除所有关联信息
 * @param userId
 */
@Query(value="delete from t_user_role where user_id=?1",nativeQuery=true)
@Modifying
public void deleteByUserId(Integer userId);


}
