package com.company.project.userserviceimpl.service;

import com.company.project.base.common.entity.Result;
import com.company.project.base.mybatis.AbstractService;
import com.company.project.userservice.pojo.entity.Consumer;
import com.company.project.userservice.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/20 15:18
 **/
@RestController
@Slf4j
public class ConsumerServiceImpl extends AbstractService<Consumer> implements ConsumerService {

    @Override
    public Result<Consumer> selectConsumer() {
        return Result.ok(this.mapper.selectByPrimaryKey(410321));
    }
}
