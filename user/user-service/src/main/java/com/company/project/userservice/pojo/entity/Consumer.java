package com.company.project.userservice.pojo.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/21 16:24
 **/
@Data
@Table(name = "order_order")
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNo;

    private BigDecimal unitPrice;
}
