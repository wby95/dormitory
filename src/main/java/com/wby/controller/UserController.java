package com.wby.controller;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/2 0002
 * Time:16:11
 **/


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.wby.entity.Permission;
import com.wby.entity.Role;
import com.wby.entity.User;
import com.wby.service.PermissionService;
import com.wby.service.RoleService;
import com.wby.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @Resource
    RoleService roleService;

    @Resource
    PermissionService permissionService;

    @RequestMapping("/login")
    public Map<String, Object> login(@Valid User user, BindingResult bindingResult, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            map.put("success", false);
            map.put("errorInfo", bindingResult.getFieldError().getDefaultMessage());
            return map;
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            subject.login(token);
            String userName = (String) SecurityUtils.getSubject().getPrincipal();
            User currentUser = userService.findByUserName(userName);
            session.setAttribute("currentUser", currentUser);
            Role role = roleService.findByUserId(currentUser.getId());//获取角色
            map.put("role", role);
            map.put("success", true);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errorInfo", "用户名或者密码错误!");
            return map;
        }
    }


    /**
     * 查询角色信息
     * @param roleId
     * @param session
     * @return
     */
    @RequestMapping("/selectRole")
    public Map<String, Object> selectRole(Integer roleId, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        Role currentRole = roleService.findById(roleId);
        System.out.println(currentRole.getName());
        session.setAttribute("currentRole", currentRole);
        map.put("success", true);
        return map;
    }


    /**
     * 加载用户信息
     * @param session
     * @return
     */
    @GetMapping("/loadUserInfo")
    public String loadUserInfo(HttpSession session){
        User user = (User) session.getAttribute("currentUser");
        Role role = (Role) session.getAttribute("currentRole");
        return "欢迎您："+user.getTrueName()+"&nbsp;[&nbsp;"+role.getName()+"&nbsp;]";
    }

    /**
     * 加载权限菜单
     * @param pId
     * @param session
     * @return
     */
    @RequestMapping("/loadMenuInfo")
    public String loadMenuInfo(Integer pId, HttpSession session){
        Role currentRole = (Role) session.getAttribute("currentRole");
        return getAllMenuByPId(pId,currentRole.getId()).toString();
    }

    /**
     * 查询所有菜单
     * @param pId
     * @param roleId
     * @return
     */
    public JsonArray getAllMenuByPId(Integer pId,Integer roleId){
        JsonArray jsonArray = this.getMenuByPId(pId,roleId);
        System.out.println(pId+"||"+roleId);
        for (int i=0;i<jsonArray.size();i++){
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            if("open".equals(jsonObject.get("state").getAsString())){
                continue;
            }else {
                jsonObject.add("children",getAllMenuByPId(jsonObject.get("id").getAsInt(),roleId));
            }
        }
        return jsonArray;
    }


    /**
     * 一层一层查询菜单
     * @param pId
     * @param roleId
     * @return
     */
    public JsonArray getMenuByPId(Integer pId,Integer roleId){
        List<Permission> permissionList = permissionService.findByPIdAndRoleId(pId,roleId);
        JsonArray jsonArray = new JsonArray();
        for (Permission permission :permissionList){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id",permission.getId());
            jsonObject.addProperty("text",permission.getName());
            if (permission.getState() == 1){
                jsonObject.addProperty("state","closed");//根
            }else {
                jsonObject.addProperty("state","open");
            }
            jsonObject.addProperty("iconCls",permission.getiCon());
            JsonObject attributeObject = new JsonObject();
            attributeObject.addProperty("url",permission.getUrl());
            jsonObject.add("attributes",attributeObject);
            jsonArray.add(jsonObject);

        }

        return jsonArray;
    }

}