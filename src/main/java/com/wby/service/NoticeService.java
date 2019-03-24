package com.wby.service;

import com.wby.entity.Notice;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;


/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/
public interface NoticeService {


    public void saveNotice(Notice notice);


    /**
     * 根据条件分页查询角色信息
     * @param notice
     * @param page
     * @param pageSize
     * @param direction
     * @param property
     * @return
     */
    public List<Notice> noticeList(Notice notice, Integer page, Integer pageSize, Sort.Direction direction, String ...property);


    /**
     * 查询总的记录数
     * @param notice
     * @return
     */
    public Long getTotalCount(Notice notice);


    /**
     * 删除公告信息
     * @param id
     */
    public void deleteNotice(Integer id);


    /**
     * 根据id 查询公告信息
     * @param id
     * @return
     */
    public Optional<Notice> findById(Integer id);

}
