package com.company.project.userserviceimpl.controller;

import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;
import com.company.project.userservice.pojo.add.UserAddVo;
import com.company.project.userservice.pojo.query.UserQueryVo;
import com.company.project.userservice.pojo.update.UserUpdateVo;
import com.company.project.userservice.pojo.query.UserDetailVo;
import com.company.project.userservice.pojo.delete.UserDeleteVo;
import com.company.project.userservice.pojo.result.UserDetailResultVo;
import com.company.project.userservice.pojo.result.UserResultVo;
import com.company.project.userservice.service.UserService;
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
 * @create: 2020-04-25 17:00:53
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "C端用户信息表管理")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("查询C端用户信息表列表")
    @PostMapping("/list")
    public Result<ResultListVo<UserResultVo>> getUserList(@Validated @RequestBody Request<UserQueryVo> request) {
        return userService.getUserList(request);
    }

    @ApiOperation("查询C端用户信息表单项")
    @PostMapping("/detail")
    public Result<UserDetailResultVo> getUser(@Validated @RequestBody Request<UserDetailVo> request) {
        return userService.getUser(request);
    }

    @ApiOperation("添加C端用户信息表")
    @PostMapping("/add")
    public Result addUser(@Validated @RequestBody Request<UserAddVo> request) {
        return userService.addUser(request);
    }

    @ApiOperation("更新C端用户信息表")
    @PostMapping("/update")
    public Result updateUser(@Validated @RequestBody Request<UserUpdateVo> request) {
        return userService.updateUser(request);
    }

    @ApiOperation("删除C端用户信息表")
    @PostMapping("/delete")
    public Result deleteUser(@Validated @RequestBody Request<UserDeleteVo> request) {
        return userService.deleteUser(request);
    }
}
