package com.company.project.producerserviceimpl.service;

import com.company.project.base.common.Result;
import com.company.project.base.common.ResultListVo;
import com.company.project.base.mybatis.AbstractService;
import com.company.project.producerservice.pojo.entity.Example;
import com.company.project.producerservice.pojo.query.ExampleQueryVo;
import com.company.project.producerservice.pojo.result.ExampleResultVo;
import com.company.project.producerservice.service.ExampleService;
import com.company.project.producerserviceimpl.mapper.ExampleMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/20 15:18
 **/
@Service
public class ExampleServiceImpl extends AbstractService<Example> implements ExampleService {
    @Override
    public Result<ResultListVo<ExampleResultVo>> selectExampleList(ExampleQueryVo userQuery) {
        Page<Object> page = PageHelper.startPage(userQuery.getPage(), userQuery.getPageSize());
        List<ExampleResultVo> resultVos = ((ExampleMapper) this.mapper).selectExampleList(userQuery);
        return Result.ok(new ResultListVo<ExampleResultVo>().setList(resultVos).setTotal(page.getTotal()));
    }
}
