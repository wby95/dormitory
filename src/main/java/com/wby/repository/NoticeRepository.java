package com.wby.repository;

import com.wby.entity.Notice;
import com.wby.entity.Role;
import com.wby.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:16:38
 **/
@Repository
public interface NoticeRepository extends JpaRepository<Notice,Integer> , JpaSpecificationExecutor<Notice> {


}
