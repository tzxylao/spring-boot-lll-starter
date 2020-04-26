package com.company.project.backgroundserviceimpl.controller;

import com.company.project.backgroundserviceimpl.business.clazz.Business001;
import com.company.project.base.common.entity.BusinessWrap;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;
import com.company.project.backgroundservice.pojo.add.UserBackgroundAddVo;
import com.company.project.backgroundservice.pojo.query.UserBackgroundQueryVo;
import com.company.project.backgroundservice.pojo.update.UserBackgroundUpdateVo;
import com.company.project.backgroundservice.pojo.query.UserBackgroundDetailVo;
import com.company.project.backgroundservice.pojo.delete.UserBackgroundDeleteVo;
import com.company.project.backgroundservice.pojo.result.UserBackgroundDetailResultVo;
import com.company.project.backgroundservice.pojo.result.UserBackgroundResultVo;
import com.company.project.backgroundservice.service.UserBackgroundService;
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
 * @create: 2020-04-26 15:38:30
 **/
@RestController
@RequestMapping("/user/background")
@Api(tags = "b端用户表管理")
public class UserBackgroundController {

    @Autowired
    private UserBackgroundService userBackgroundService;

    @ApiOperation("查询b端用户表列表")
    @PostMapping("/list")
    public Result<ResultListVo<UserBackgroundResultVo>> getUserBackgroundList(@Validated @RequestBody Request<UserBackgroundQueryVo> request) {
        return userBackgroundService.getUserBackgroundList(request).addBusinessClass(Result.wrap(Business001.class));
    }

    @ApiOperation("查询b端用户表单项")
    @PostMapping("/detail")
    public Result<UserBackgroundDetailResultVo> getUserBackground(@Validated @RequestBody Request<UserBackgroundDetailVo> request) {
        return userBackgroundService.getUserBackground(request);
    }

    @ApiOperation("添加b端用户表")
    @PostMapping("/add")
    public Result addUserBackground(@Validated @RequestBody Request<UserBackgroundAddVo> request) {
        return userBackgroundService.addUserBackground(request);
    }

    @ApiOperation("更新b端用户表")
    @PostMapping("/update")
    public Result updateUserBackground(@Validated @RequestBody Request<UserBackgroundUpdateVo> request) {
        return userBackgroundService.updateUserBackground(request);
    }

    @ApiOperation("删除b端用户表")
    @PostMapping("/delete")
    public Result deleteUserBackground(@Validated @RequestBody Request<UserBackgroundDeleteVo> request) {
        return userBackgroundService.deleteUserBackground(request);
    }
}
