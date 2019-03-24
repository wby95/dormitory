package com.wby.service.impl;

import com.wby.entity.Notice;
import com.wby.repository.NoticeRepository;
import com.wby.service.NoticeService;
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
import java.util.Optional;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/6 0006
 * Time:13:39
 **/
@Service(value = "noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Resource
    NoticeRepository noticeRepository;

    @Override
    public void saveNotice(Notice notice) {
        noticeRepository.save(notice);
    }


    @Override
    public List<Notice> noticeList(Notice notice, Integer page, Integer pageSize, Sort.Direction direction, String... property) {
        Pageable pageable = new PageRequest(page - 1, pageSize);
        Page<Notice> pageNotice = noticeRepository.findAll(new Specification<Notice>() {
            @Override
            public Predicate toPredicate(Root<Notice> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if (notice != null) {
                    if (StringUtil.isNotEmpty(notice.getTitle())) {
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("title"), "%" + notice.getTitle() + "%"));
                    }
                }
                return predicate;
            }
        }, pageable);

        return pageNotice.getContent();
    }


    /**
     * 查询总的记录数
     *
     * @param notice
     * @return
     */
    @Override
    public Long getTotalCount(Notice notice) {

        Long count = noticeRepository.count(new Specification<Notice>() {
            @Override
            public Predicate toPredicate(Root<Notice> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if (notice != null) {
                    if (StringUtil.isNotEmpty(notice.getTitle())) {
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("title"), "%" + notice.getTitle() + "%"));
                    }
                }
                return predicate;
            }
        });

        return count;
    }

    /**
     * 删除公告信息
     * @param id
     */
    @Override
    public void deleteNotice(Integer id) {
        noticeRepository.deleteById(id);
    }

    /**
     * 根据id查询公告信息
     * @param id
     * @return
     */
    @Override
    public Optional<Notice> findById(Integer id) {
        return noticeRepository.findById(id);
    }


}
