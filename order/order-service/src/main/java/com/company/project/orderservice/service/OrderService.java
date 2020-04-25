package com.company.project.orderservice.service;

import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;
import com.company.project.base.mybatis.Service;
import com.company.project.orderservice.pojo.add.OrderAddVo;
import com.company.project.orderservice.pojo.delete.OrderDeleteVo;
import com.company.project.orderservice.pojo.entity.Order;
import com.company.project.orderservice.pojo.query.OrderDetailVo;
import com.company.project.orderservice.pojo.query.OrderQueryVo;
import com.company.project.orderservice.pojo.result.OrderDetailResultVo;
import com.company.project.orderservice.pojo.result.OrderResultVo;
import com.company.project.orderservice.pojo.update.OrderUpdateVo;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-25 17:18:40
 **/
@FeignClient(name = "order",fallbackFactory = OrderService.ServiceFallbackFactory.class)
public interface OrderService extends Service<Order> {

    /**
     * 查询订单表列表
     */
    @PostMapping("/remote/order/list")
    Result<ResultListVo<OrderResultVo>> getOrderList(Request<OrderQueryVo> request);

    /**
     * 查询订单表单项
     */
    Result<OrderDetailResultVo> getOrder(Request<OrderDetailVo> request);

    /**
     * 添加订单表
     */
    Result addOrder(Request<OrderAddVo> request);

    /**
     * 更新订单表
     */
    Result updateOrder(Request<OrderUpdateVo> request);

    /**
     * 删除订单表
     */
    Result deleteOrder(Request<OrderDeleteVo> request);


    class ServiceFallbackFactory implements FallbackFactory<OrderService> {
        @Override
        public OrderService create(Throwable throwable) {
            return new OrderService() {
                @Override
                public Result<ResultListVo<OrderResultVo>> getOrderList(Request<OrderQueryVo> request) {
                    return null;
                }

                @Override
                public Result<OrderDetailResultVo> getOrder(Request<OrderDetailVo> request) {
                    return null;
                }

                @Override
                public Result addOrder(Request<OrderAddVo> request) {
                    return null;
                }

                @Override
                public Result updateOrder(Request<OrderUpdateVo> request) {
                    return null;
                }

                @Override
                public Result deleteOrder(Request<OrderDeleteVo> request) {
                    return null;
                }
            };
        }
    }
}
