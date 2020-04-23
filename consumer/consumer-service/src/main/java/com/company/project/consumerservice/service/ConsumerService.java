package com.company.project.consumerservice.service;

import com.company.project.base.common.entity.Result;
import com.company.project.base.exeception.ExceptionProcessor;
import com.company.project.consumerservice.pojo.entity.Consumer;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/20 15:17
 **/
@FeignClient(name = "consumer")
public interface ConsumerService {

    @PostMapping("/selectConsumer")
    Result<Consumer> selectConsumer();

    class ServiceFallbackFactory implements FallbackFactory<ConsumerService> {
        @Override
        public ConsumerService create(Throwable throwable) {
            return new ConsumerService() {
                @Override
                public Result<Consumer> selectConsumer() {
                    return ExceptionProcessor.getResult(throwable.getMessage());
                }
            };
        }
    }
}
