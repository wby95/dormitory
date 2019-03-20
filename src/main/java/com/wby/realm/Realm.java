package com.wby.realm;

import com.wby.entity.User;
import com.wby.repository.RoleRepository;
import com.wby.repository.UserRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;


/**
 * 自定义Realm
 *
 * @author Administrator
 */
public class Realm extends AuthorizingRealm {

    @Resource
    UserRepository userRepository;

    @Resource
    RoleRepository roleRepository;


    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"xxx");
            return authenticationInfo;
        } else {        //用户名&密码错误
            return null;
        }
    }
}
