package com.company.project.producerservice.service;

import com.company.project.base.common.Result;
import com.company.project.base.common.ResultListVo;
import com.company.project.producerservice.pojo.query.ExampleQueryVo;
import com.company.project.producerservice.pojo.result.ExampleResultVo;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/20 15:17
 **/
public interface ExampleService {
    Result<ResultListVo<ExampleResultVo>> selectExampleList(ExampleQueryVo userQuery);
}
