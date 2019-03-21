package com.wby.controller.admin;

import com.wby.entity.Role;
import com.wby.entity.User;
import com.wby.entity.UserRole;
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

@RequestMapping("/admin/user")
@RestController
public class UserAdminController {
    @Resource
    UserService userService;

    @Resource
    RoleService roleService;

    @Resource
    UserRoleService userRoleService;


    /**
     * 获取用户列表
     * @param user
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public Map<String, Object> list(User user, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        List<User> userList = userService.userList(user, page, rows, Sort.Direction.ASC, "id");
        for (User u : userList) {
            Role roleList = roleService.findByUserId(u.getId());
            StringBuffer sb = new StringBuffer();
            if(roleList !=null) {
                sb.append("," + roleList.getName());
                u.setRoles(sb.toString().replaceFirst(",", ""));
            }
        }
        Long total = userService.getTotalCount(user);
        resultMap.put("rows", userList);
        resultMap.put("total", total);
        return resultMap;
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public Map<String,Object> saveUser(User user){
        Map<String, Object> map = new HashMap<>();
        userService.saveUser(user);
        map.put("success",true);
        return map;
    }

    /**
     * 删除用户的id
     * @param id
     * @return
     */
    @RequestMapping("/deleteUser")
    public Map<String,Object>deleteUser(Integer id){
        userRoleService.deleteByUserId(id);
        userService.deleteUser(id);
        Map<String, Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }


    @RequestMapping("/saveRole")
    public Map<String,Object>saveRole(Integer roleId,Integer userId){
        userRoleService.deleteByUserId(userId);
        UserRole userRole = new UserRole();
        userRole.setUser(userService.findById(userId));
        userRole.setRole(roleService.findById(roleId));
        userRoleService.saveRole(userRole);
        Map<String, Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }

}
