package com.company.project.producerserviceimpl.controller;

import com.company.project.base.common.Result;
import com.company.project.base.common.ResultListVo;
import com.company.project.producerservice.pojo.query.ExampleQueryVo;
import com.company.project.producerservice.pojo.result.ExampleResultVo;
import com.company.project.producerservice.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/20 14:54
 **/
@RestController
@RequestMapping("/crm")
@Api(tags = "example")
public class ExampleController {
    @Autowired
    private ExampleService exampleService;

    @ApiOperation("待加粉用户列表")
    @PostMapping("/common/list")
    @Deprecated
    public Result<ResultListVo<ExampleResultVo>> selectCommonUsers(@RequestBody ExampleQueryVo userQuery) {
        return exampleService.selectExampleList(userQuery);
    }

}
