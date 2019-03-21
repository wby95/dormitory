package com.wby.service.impl;

import com.wby.entity.User;
import com.wby.repository.UserRepository;
import com.wby.service.UserService;
import com.wby.util.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    /**
     * 根据userName查询用户
     *
     * @param userName
     * @return
     */
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> userList(User user, Integer page, Integer pageSize, Sort.Direction direction, String... properties) {
        Pageable pageable = new PageRequest(page - 1, pageSize);
        Page<User> pageUser = userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if (user != null) {
                    if (StringUtil.isNotEmpty(user.getUserName())) {
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("userName"), "%" + user.getUserName() + "%"));
                    }
                    predicate.getExpressions().add(criteriaBuilder.notEqual(root.get("id"), 1));
                }
                return predicate;
            }
        }, pageable);

        return pageUser.getContent();
    }


    /**
     * 查询总的记录数
     * @param user
     * @return
     */
    @Override
    public Long getTotalCount(User user) {

        Long count = userRepository.count(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if (user != null) {
                    if (StringUtil.isNotEmpty(user.getUserName())) {
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("userName"), "%" + user.getUserName() + "%"));
                    }
                    predicate.getExpressions().add(criteriaBuilder.notEqual(root.get("id"), 1));
                }
                return predicate;
            }
        });

        return count;
    }


    /**
     * 保存用户
     * @param user
     */
    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }


    /**
     * 根据id删除用户
     * @param id
     */
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }

    /**
     * 根据id查询用户
     * @param id
     */
    @Override
    public User findById(Integer id) {
       return userRepository.findByUserId(id);
    }

}
