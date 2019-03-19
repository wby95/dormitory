package com.wby.controller;

/**
 * Created with IDEA
 * Author:wangboyue
 * Date:2019/3/2 0002
 * Time:16:11
 **/


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class RoleController {
    @GetMapping("/hello")
    public String home() {
        return "Hello World!";
    }
}