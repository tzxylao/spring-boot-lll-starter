package com.company.project.producerservice.service;

import com.company.project.producerservice.pojo.entity.Order;
import com.company.project.producerservice.pojo.query.OrderQueryVo;
import com.company.project.producerservice.pojo.add.OrderAddVo;
import com.company.project.producerservice.pojo.update.OrderUpdateVo;
import com.company.project.producerservice.pojo.query.OrderDetailVo;
import com.company.project.producerservice.pojo.delete.OrderDeleteVo;
import com.company.project.producerservice.pojo.result.OrderDetailResultVo;
import com.company.project.producerservice.pojo.result.OrderResultVo;
import com.company.project.base.mybatis.Service;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;


/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-24 15:25:35
 **/
public interface OrderService extends Service<Order> {

    /**
     * 查询订单表列表
     */
    Result<ResultListVo<OrderResultVo>> getOrderList(Request<OrderQueryVo> request);

    /**
     * 查询订单表单项
     */
    Result<OrderDetailResultVo> getOrder(Request<OrderDetailVo> request);

    /**
     * 添加订单表
     */
    Result addOrder(Request<OrderAddVo> request);

    /**
     * 更新订单表
     */
    Result updateOrder(Request<OrderUpdateVo> request);

    /**
     * 删除订单表
     */
    Result deleteOrder(Request<OrderDeleteVo> request);
}
