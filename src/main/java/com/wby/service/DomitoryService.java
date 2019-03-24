package com.wby.service;

import com.wby.entity.Domitory;
import com.wby.entity.Notice;
import org.springframework.data.domain.Sort;

import java.util.List;


/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/
public interface DomitoryService {


    public void saveDomitory(Domitory domitory);


    /**
     * 根据条件分页查询学生宿舍信息
     * @param domitory
     * @param page
     * @param pageSize
     * @param direction
     * @param property
     * @return
     */
    public List<Domitory> domitoryList(Domitory domitory, Integer page, Integer pageSize, Sort.Direction direction, String... property);



    /**
     * 查询总的记录数
     * @param domitory
     * @return
     */
    public Long getTotalCount(Domitory domitory);


    /**
     * 删除学生宿舍信息
     * @param id
     */
    public void deleteDomitory(Integer id);




}
