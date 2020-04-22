package com.company.project.producerserviceimpl.controller;

import com.company.project.base.common.Request;
import com.company.project.base.common.Result;
import com.company.project.base.common.ResultListVo;
import com.company.project.producerservice.pojo.add.ExampleAddVo;
import com.company.project.producerservice.pojo.delete.ExampleDeleteVo;
import com.company.project.producerservice.pojo.query.ExampleDetailVo;
import com.company.project.producerservice.pojo.query.ExampleQueryVo;
import com.company.project.producerservice.pojo.result.ExampleDetailResultVo;
import com.company.project.producerservice.pojo.result.ExampleResultVo;
import com.company.project.producerservice.pojo.update.ExampleUpdateVo;
import com.company.project.producerservice.service.ExampleService;
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
 * @create: 2020/4/20 14:54
 **/
@RestController
@RequestMapping("/example")
@Api(tags = "XXX管理")
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @ApiOperation("查询XXX列表")
    @PostMapping("/list")
    public Result<ResultListVo<ExampleResultVo>> getExampleList(@Validated @RequestBody Request<ExampleQueryVo> request) {
        return exampleService.getExampleList(request);
    }

    @ApiOperation("查询XXX单项")
    @PostMapping("/detail")
    public Result<ExampleDetailResultVo> getExample(@Validated @RequestBody Request<ExampleDetailVo> request) {
        return exampleService.getExample(request);
    }
    
    @ApiOperation("添加XXX")
    @PostMapping("/add")
    public Result addExample(@Validated @RequestBody Request<ExampleAddVo> unlockOrderAddVo) {
        return exampleService.addExample(unlockOrderAddVo);
    }

    @ApiOperation("更新XXX")
    @PostMapping("/update")
    public Result updateExample(@Validated @RequestBody Request<ExampleUpdateVo> unlockOrderUpdateVo) {
        return exampleService.updateExample(unlockOrderUpdateVo);
    }

    @ApiOperation("删除XXX")
    @PostMapping("/delete")
    public Result deleteExample(@Validated @RequestBody Request<ExampleDeleteVo> unlockOrderDeleteVo) {
        return exampleService.deleteExample(unlockOrderDeleteVo);
    }

}
