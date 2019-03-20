package com.wby.service.impl;

import com.wby.entity.Permission;
import com.wby.entity.Role;
import com.wby.repository.PermissionRepository;
import com.wby.repository.RoleRepository;
import com.wby.service.PermissionService;
import com.wby.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/
@Service(value = "permissionService")
public class PermissionServiceImpl implements PermissionService {


    @Resource
    PermissionRepository permissionRepository;
    /**
     * 根据父节点以及用户角色id查询子节点
     * @param pId
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findByPIdAndRoleId(int pId, int roleId) {
        return permissionRepository.findByPIdAndRoleId(pId,roleId);
    }
}
