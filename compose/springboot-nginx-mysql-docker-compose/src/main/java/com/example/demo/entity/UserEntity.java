package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Copyright (C), 2015-2020
 * FileName: UserEntity
 * Author:   MRC
 * Date:     2020/2/9 17:59
 * Description: 测试用户访问
 * History:
 */
@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String ip;

    private Date createTime;

    private Integer status;

}