package com.wby.repository;

import com.wby.entity.Permission;
import com.wby.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:16:38
 **/
@Repository
public interface PermissionRepository extends JpaRepository<Permission,Integer> {


    /**
     * 根据父节点以及用户角色id查询子节点
     * @param pId
     * @param roleId
     * @return
     */
    @Query(value="SELECT * FROM t_permission WHERE p_id=?1 AND id IN (SELECT permission_id FROM t_role_permission WHERE role_id=?2)",nativeQuery=true)
    public List<Permission> findByPIdAndRoleId(int pId,int roleId);

  ;
}
