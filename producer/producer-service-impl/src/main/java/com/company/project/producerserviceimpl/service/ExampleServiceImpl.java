package com.company.project.producerserviceimpl.service;

import cn.hutool.core.bean.BeanUtil;
import com.company.project.base.common.Request;
import com.company.project.base.common.Result;
import com.company.project.base.common.ResultListVo;
import com.company.project.base.mybatis.AbstractService;
import com.company.project.producerservice.pojo.add.ExampleAddVo;
import com.company.project.producerservice.pojo.delete.ExampleDeleteVo;
import com.company.project.producerservice.pojo.entity.Example;
import com.company.project.producerservice.pojo.query.ExampleDetailVo;
import com.company.project.producerservice.pojo.query.ExampleQueryVo;
import com.company.project.producerservice.pojo.result.ExampleDetailResultVo;
import com.company.project.producerservice.pojo.result.ExampleResultVo;
import com.company.project.producerservice.pojo.update.ExampleUpdateVo;
import com.company.project.producerservice.service.ExampleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/20 15:18
 **/
@Transactional
@RestController
@Slf4j
public class ExampleServiceImpl extends AbstractService<Example> implements ExampleService {


    @Override
    public Result<ResultListVo<ExampleResultVo>> getExampleList(Request<ExampleQueryVo> request) {
        ExampleQueryVo exampleQueryVo = request.getBody();
        Page<Object> page = PageHelper.startPage(exampleQueryVo.getPage(), exampleQueryVo.getPageSize());
//        List<ExampleResultVo> resultVos = ((ExampleMapper) this.mapper).selectExampleList(exampleQueryVo);
//        return Result.ok(new ResultListVo<ExampleResultVo>().setList(resultVos).setTotal(page.getTotal()));
        return Result.ok();
    }

    @Override
    public Result<ExampleDetailResultVo> getExample(Request<ExampleDetailVo> request) {
        ExampleDetailVo exampleDetailVo = request.getBody();
//        ExampleDetailResultVo unlockOrderDetailResultVo = ((ExampleMapper) this.mapper).selectExample(exampleDetailVo);
//        Precondition.checkNotNull(unlockOrderDetailResultVo, "XXX不存在");
        return Result.ok();
    }

    @Override
    public Result addExample(Request<ExampleAddVo> request) {
        ExampleAddVo exampleAddVo = request.getBody();
        Example example = new Example();
        BeanUtil.copyProperties(exampleAddVo, example);
        this.mapper.insertSelective(example);
        return Result.ok();
    }

    @Override
    public Result updateExample(Request<ExampleUpdateVo> request) {
        ExampleUpdateVo exampleUpdateVo = request.getBody();
        Example example = new Example();
        BeanUtil.copyProperties(exampleUpdateVo, example);
        this.mapper.updateByPrimaryKeySelective(example);
        return Result.ok();
    }

    @Override
    public Result deleteExample(Request<ExampleDeleteVo> unlockOrderDeleteVo) {
        ExampleDeleteVo exampleDeleteVo = unlockOrderDeleteVo.getBody();
        Example example = new Example();
        BeanUtil.copyProperties(exampleDeleteVo, example);

        return Result.ok();
    }
}
