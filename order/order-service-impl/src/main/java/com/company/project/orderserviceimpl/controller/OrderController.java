package com.company.project.orderserviceimpl.controller;

import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;
import com.company.project.userservice.pojo.query.UserQueryVo;
import com.company.project.userservice.pojo.result.UserResultVo;
import com.company.project.userservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-25 17:18:40
 **/
@RestController
@RequestMapping("/order")
@Api(tags = "订单表管理")
public class OrderController {

    @Autowired
    private UserService userService;

    @ApiOperation("查询订单表列表")
    @PostMapping("/list")
    public Result<ResultListVo<UserResultVo>> getOrderList(@Validated @RequestBody Request<UserQueryVo> request) {
        return userService.getUserList(request);
    }

}
