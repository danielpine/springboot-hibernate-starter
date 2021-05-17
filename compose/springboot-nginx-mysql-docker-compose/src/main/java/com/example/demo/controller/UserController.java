package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Copyright (C), 2015-2020
 * FileName: UserController
 * Author:   MRC
 * Date:     2020/2/9 18:08
 * Description:
 * History:
 */
@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserRep userRep;

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("guest");
        userEntity.setCreateTime(new Date());
        userEntity.setIp(request.getRemoteAddr());
        userEntity.setStatus(1);
        userRep.save(userEntity);
        return "hello-docker-nginx "+userRep.findAll().size();
    }

}