package com.company.project.producerserviceimpl.service;

import com.alibaba.fastjson.JSON;
import com.company.project.base.common.Request;
import com.company.project.base.common.Result;
import com.company.project.base.common.ResultListVo;
import com.company.project.base.mybatis.AbstractService;
import com.company.project.consumerservice.pojo.entity.Consumer;
import com.company.project.producerservice.pojo.entity.Example;
import com.company.project.producerservice.pojo.query.ExampleQueryVo;
import com.company.project.producerservice.pojo.result.ExampleResultVo;
import com.company.project.producerservice.service.ExampleService;
import com.company.project.producerserviceimpl.mapper.ExampleMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/20 15:18
 **/
@RestController
@Slf4j
public class ExampleServiceImpl extends AbstractService<Example> implements ExampleService {


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Result<ResultListVo<ExampleResultVo>> selectExampleList(Request<ExampleQueryVo> request) {
        ExampleQueryVo exampleQueryVo = request.getBody();
        Page<Object> page = PageHelper.startPage(exampleQueryVo.getPage(), exampleQueryVo.getPageSize());
        List<ExampleResultVo> resultVos = ((ExampleMapper) this.mapper).selectExampleList(exampleQueryVo);
        return Result.ok(new ResultListVo<ExampleResultVo>().setList(resultVos).setTotal(page.getTotal()));
    }

    @Override
    @PostMapping("/callRemote")
    public Result<Consumer> callRemote() {
        Result<Consumer> provider = restTemplate.getForObject("http://consumer/selectConsumer", Result.class);
        log.info(JSON.toJSONString(provider.getData()));
        return null;
    }
}
