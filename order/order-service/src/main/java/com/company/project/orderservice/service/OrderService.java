package com.company.project.orderservice.service;

import com.company.project.base.exeception.DataException;
import com.company.project.orderservice.pojo.entity.Order;
import com.company.project.orderservice.pojo.query.OrderQueryVo;
import com.company.project.orderservice.pojo.add.OrderAddVo;
import com.company.project.orderservice.pojo.update.OrderUpdateVo;
import com.company.project.orderservice.pojo.query.OrderDetailVo;
import com.company.project.orderservice.pojo.delete.OrderDeleteVo;
import com.company.project.orderservice.pojo.result.OrderDetailResultVo;
import com.company.project.orderservice.pojo.result.OrderResultVo;
import com.company.project.base.mybatis.Service;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-26 15:35:21
 **/
@FeignClient(name = "orderOrder", fallbackFactory = OrderService.ServiceFallbackFactory.class)
public interface OrderService extends Service<Order> {

    /**
     * 查询订单表列表
     */
    @PostMapping(value = "/order/list")
    Result<ResultListVo<OrderResultVo>> getOrderList(@RequestBody Request<OrderQueryVo> request);

    /**
     * 查询订单表单项
     */
    @PostMapping(value = "/order/detail")
    Result<OrderDetailResultVo> getOrder(@RequestBody Request<OrderDetailVo> request);

    /**
     * 添加订单表
     */
    @PostMapping(value = "/order/add")
    Result addOrder(@RequestBody Request<OrderAddVo> request);

    /**
     * 更新订单表
     */
    @PostMapping(value = "/order/update")
    Result updateOrder(@RequestBody Request<OrderUpdateVo> request);

    /**
     * 删除订单表
     */
    @PostMapping(value = "/order/delete")
    Result deleteOrder(@RequestBody Request<OrderDeleteVo> request);

    class ServiceFallbackFactory implements FallbackFactory<OrderService> {
        @Override
        public OrderService create(Throwable throwable) {
            return new OrderService() {
                @Override
                public Result<ResultListVo<OrderResultVo>> getOrderList(Request<OrderQueryVo> request) {
                    throw new DataException("getOrderList异常");
                }

                @Override
                public Result<OrderDetailResultVo> getOrder(Request<OrderDetailVo> request) {
                    throw new DataException("getOrder异常");
                }

                @Override
                public Result addOrder(Request<OrderAddVo> request) {
                    throw new DataException("addOrder异常");
                }

                @Override
                public Result updateOrder(Request<OrderUpdateVo> request) {
                    throw new DataException("updateOrder异常");
                }

                @Override
                public Result deleteOrder(Request<OrderDeleteVo> request) {
                    throw new DataException("deleteOrder异常");
                }
            };
        }
    }
}
