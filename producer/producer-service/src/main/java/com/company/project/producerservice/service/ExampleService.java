package com.company.project.producerservice.service;

import com.company.project.base.common.Request;
import com.company.project.base.common.Result;
import com.company.project.base.common.ResultListVo;
import com.company.project.base.exeception.ExceptionProcessor;
import com.company.project.consumerservice.pojo.entity.Consumer;
import com.company.project.producerservice.pojo.query.ExampleQueryVo;
import com.company.project.producerservice.pojo.result.ExampleResultVo;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/20 15:17
 **/
@FeignClient(name = "producer", fallbackFactory = ExampleService.ExampleServiceFallbackFactory.class)
public interface ExampleService {

    @PostMapping("/selectExampleList")
    Result<ResultListVo<ExampleResultVo>> selectExampleList(Request<ExampleQueryVo> request);

    @PostMapping("/callRemote")
    Result<Consumer> callRemote();

    class ExampleServiceFallbackFactory implements FallbackFactory<ExampleService> {
        @Override
        public ExampleService create(Throwable throwable) {
            return new ExampleService() {
                @Override
                public Result<ResultListVo<ExampleResultVo>> selectExampleList(Request<ExampleQueryVo> userQuery) {
                    return ExceptionProcessor.getResult(throwable.getMessage());
                }

                @Override
                public Result<Consumer> callRemote() {
                    return ExceptionProcessor.getResult(throwable.getMessage());
                }
            };
        }
    }
}
