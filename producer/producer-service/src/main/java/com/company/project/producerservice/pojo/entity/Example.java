package com.company.project.producerservice.pojo.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/20 15:58
 **/
@Data
@Table(name = "user_background")
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
}
