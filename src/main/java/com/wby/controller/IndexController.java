package com.wby.controller;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/2 0002
 * Time:16:11
 **/


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {
    @RequestMapping("/")
    public String home() {
        return "redirect:/login.html";
    }
}