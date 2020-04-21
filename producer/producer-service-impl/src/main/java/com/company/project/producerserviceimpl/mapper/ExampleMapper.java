package com.company.project.producerserviceimpl.mapper;

import com.company.project.base.mybatis.Mapper;
import com.company.project.producerservice.pojo.entity.Example;
import com.company.project.producerservice.pojo.query.ExampleQueryVo;
import com.company.project.producerservice.pojo.result.ExampleResultVo;

import java.util.List;

public interface ExampleMapper extends Mapper<Example> {

    List<ExampleResultVo> selectExampleList(ExampleQueryVo userQuery);
}