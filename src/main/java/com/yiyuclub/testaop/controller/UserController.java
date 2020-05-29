package com.yiyuclub.testaop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("add")
    public void add(String username,String operate){
        System.out.println("add");
    }

    @PostMapping("delete")
    public void delete(Integer id){
        System.out.println("delete");
    }

    @PostMapping("update")
    public void update(String username){
        System.out.println("update");
    }

    @PostMapping("select")
    public void select(String username){
        System.out.println("select");
    }
}
