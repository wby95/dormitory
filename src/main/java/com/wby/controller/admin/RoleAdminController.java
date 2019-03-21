package com.wby.controller.admin;

import com.wby.entity.Role;
import com.wby.entity.User;
import com.wby.service.RoleService;
import com.wby.service.UserRoleService;
import com.wby.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/20 0020
 * Time:21:23
 **/

@RequestMapping("/admin/role")
@RestController
public class RoleAdminController {
    @Resource
    UserService userService;

    @Resource
    RoleService roleService;

    @Resource
    UserRoleService userRoleService;
    @RequestMapping("/listAllRole")
    public Map<String,Object>findAllRole(){
        Map<String, Object> map = new HashMap<>();
        map.put("rows",roleService.selectAllRole());
        map.put("success",true);
        return map;
    }

}
