package com.company.project.producerservice.service;

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

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/20 15:17
 **/
public interface ExampleService {

    /**
     * 查询XXX订单列表
     */
    Result<ResultListVo<ExampleResultVo>> getExampleList(Request<ExampleQueryVo> request);

    /**
     * 查询XXX订单单项
     */
    Result<ExampleDetailResultVo> getExample(Request<ExampleDetailVo> request);

    /**
     * 添加XXX订单
     */
    Result addExample(Request<ExampleAddVo> request);

    /**
     * 更新XXX订单
     */
    Result updateExample(Request<ExampleUpdateVo> request);

    /**
     * 删除XXX订单
     */
    Result deleteExample(Request<ExampleDeleteVo> unlockOrderDeleteVo);
}
