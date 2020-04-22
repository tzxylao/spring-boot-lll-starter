package com.company.project.consumerserviceimpl.controller;

import com.company.project.base.common.Result;
import com.company.project.consumerservice.pojo.entity.Consumer;
import com.company.project.consumerservice.service.ConsumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/21 16:29
 **/
@RestController
@RequestMapping("/")
@Api(tags = "consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @ApiOperation("例子")
    @PostMapping("/one")
    public Result<Consumer> selectCommonUsers() {
        return consumerService.selectConsumer();
    }
}
