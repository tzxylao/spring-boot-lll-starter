package com.company.project.producerserviceimpl.controller;

import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;
import com.company.project.producerservice.pojo.add.OrderAddVo;
import com.company.project.producerservice.pojo.query.OrderQueryVo;
import com.company.project.producerservice.pojo.update.OrderUpdateVo;
import com.company.project.producerservice.pojo.query.OrderDetailVo;
import com.company.project.producerservice.pojo.delete.OrderDeleteVo;
import com.company.project.producerservice.pojo.result.OrderDetailResultVo;
import com.company.project.producerservice.pojo.result.OrderResultVo;
import com.company.project.producerservice.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-24 15:25:35
 **/
@RestController
@RequestMapping("/order")
@Api(tags = "订单表管理")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("查询订单表列表")
    @PostMapping("/list")
    public Result<ResultListVo<OrderResultVo>> getOrderList(@Validated @RequestBody Request<OrderQueryVo> request) {
        return orderService.getOrderList(request);
    }

    @ApiOperation("查询订单表单项")
    @PostMapping("/detail")
    public Result<OrderDetailResultVo> getOrder(@Validated @RequestBody Request<OrderDetailVo> request) {
        return orderService.getOrder(request);
    }

    @ApiOperation("添加订单表")
    @PostMapping("/add")
    public Result addOrder(@Validated @RequestBody Request<OrderAddVo> request) {
        return orderService.addOrder(request);
    }

    @ApiOperation("更新订单表")
    @PostMapping("/update")
    public Result updateOrder(@Validated @RequestBody Request<OrderUpdateVo> request) {
        return orderService.updateOrder(request);
    }

    @ApiOperation("删除订单表")
    @PostMapping("/delete")
    public Result deleteOrder(@Validated @RequestBody Request<OrderDeleteVo> request) {
        return orderService.deleteOrder(request);
    }
}
