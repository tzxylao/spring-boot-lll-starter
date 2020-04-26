package com.company.project.orderserviceimpl.controller;

import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;
import com.company.project.userservice.pojo.add.UserRoleAddVo;
import com.company.project.userservice.pojo.query.UserQueryVo;
import com.company.project.userservice.pojo.query.UserRoleDetailVo;
import com.company.project.userservice.pojo.result.UserResultVo;
import com.company.project.userservice.pojo.result.UserRoleDetailResultVo;
import com.company.project.userservice.pojo.update.UserRoleUpdateVo;
import com.company.project.userservice.service.UserRoleService;
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
@RequestMapping("/user")
@Api(tags = "在订单模拟微服务调用用户信息")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @ApiOperation("查询用户列表")
    @PostMapping("/list")
    public Result<ResultListVo<UserResultVo>> getOrderList(@Validated @RequestBody Request<UserQueryVo> request) {
        return userService.getUserList(request);
    }

    @ApiOperation("查询角色表单项")
    @PostMapping("/detail")
    public Result<UserRoleDetailResultVo> getUserRole(@Validated @RequestBody Request<UserRoleDetailVo> request) {
        return userRoleService.getUserRole(request);
    }


}
