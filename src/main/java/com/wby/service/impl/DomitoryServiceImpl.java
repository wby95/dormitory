package com.wby.service.impl;

import com.wby.entity.Domitory;
import com.wby.entity.Notice;
import com.wby.repository.DomitoryRepository;
import com.wby.service.DomitoryService;
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
@Service(value = "domitoryService")
public class DomitoryServiceImpl implements DomitoryService {

    @Resource
    DomitoryRepository domitoryRepository;

    @Override
    public void saveDomitory(Domitory domitory) {
        
    }

    @Override
    public List<Domitory> domitoryList(Domitory domitory, Integer page, Integer pageSize, Sort.Direction direction, String... property) {
        Pageable pageable = new PageRequest(page - 1, pageSize);
        Page<Domitory> pageDomitory = domitoryRepository.findAll(new Specification<Domitory>() {
            @Override
            public Predicate toPredicate(Root<Domitory> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if (domitory != null) {
                    if (StringUtil.isNotEmpty(domitory.getFloor())) {
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("floor"), "%" + domitory.getFloor() + "%"));
                    }
                }
                return predicate;
            }
        }, pageable);
        return pageDomitory.getContent();
    }

    @Override
    public Long getTotalCount(Domitory domitory) {
        Long count=domitoryRepository.count(new Specification<Domitory>() {

            @Override
            public Predicate toPredicate(Root<Domitory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate=criteriaBuilder.conjunction();
                if (domitory != null) {
                    if (StringUtil.isNotEmpty(domitory.getFloor())) {
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("floor"), "%" + domitory.getFloor() + "%"));
                    }
                }
                return predicate;
            }
        });
        return count;
    }

    @Override
    public void deleteDomitory(Integer id) {

    }
}
