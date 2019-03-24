package com.wby.controller.admin;

import com.wby.entity.Domitory;
import com.wby.entity.Notice;
import com.wby.entity.Role;
import com.wby.entity.User;
import com.wby.service.DomitoryService;
import com.wby.service.NoticeService;
import com.wby.util.DateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/20 0020
 * Time:21:23
 **/

@RequestMapping("/admin/domitory")
@RestController
public class DomitoryController {

    @Resource
    DomitoryService domitoryService;
    /**
     * 获取用户列表
     * @param user
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping("/listStu")
    public Map<String, Object> listStudent(Domitory domitory , @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<Domitory> domitoryList = domitoryService.domitoryList(domitory,page,rows, Sort.Direction.DESC, "id");
        Long total = domitoryService.getTotalCount(domitory);
        map.put("rows", domitoryList);
        map.put("total", total);
        return map;
    }



}
