package com.company.project.orderserviceimpl.service;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.company.project.orderserviceimpl.mapper.OrderMapper;
import com.company.project.orderservice.pojo.entity.Order;
import com.company.project.orderservice.service.OrderService;
import com.company.project.orderservice.pojo.query.OrderQueryVo;
import com.company.project.orderservice.pojo.add.OrderAddVo;
import com.company.project.orderservice.pojo.update.OrderUpdateVo;
import com.company.project.orderservice.pojo.query.OrderDetailVo;
import com.company.project.orderservice.pojo.delete.OrderDeleteVo;
import com.company.project.orderservice.pojo.result.OrderDetailResultVo;
import com.company.project.orderservice.pojo.result.OrderResultVo;
import com.company.project.base.mybatis.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;


/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-25 17:18:40
 **/
@Service
@Transactional
public class OrderServiceImpl extends AbstractService<Order> implements OrderService {

    @Override
    public Result<ResultListVo<OrderResultVo>> getOrderList(Request<OrderQueryVo> request) {
        OrderQueryVo orderOrderQueryVo = request.getBody();
        Page<Object> page = PageHelper.startPage(orderOrderQueryVo.getPage(), orderOrderQueryVo.getPageSize());
        //       List<OrderResultVo> resultVos = ((OrderMapper)this.mapper).selectOrderList(orderOrderQueryVo);
        //       return Result.ok(new ResultListVo<OrderResultVo>().setList(resultVos).setTotal(page.getTotal()));
        return Result.ok();
    }

    @Override
    public Result<OrderDetailResultVo> getOrder(Request<OrderDetailVo> request) {
        OrderDetailVo orderOrderDetailVo = request.getBody();
        // OrderDetailResultVo orderOrderDetailResultVo = ((OrderMapper) this.mapper).selectOrder(orderOrderDetailVo);
        // Precondition.checkNotNull(orderOrderDetailResultVo, "订单表不存在");
        // return Result.ok(orderOrderDetailResultVo);
        return Result.ok();
    }

    @Override
    public Result addOrder(Request<OrderAddVo> request) {
        OrderAddVo orderOrderAddVo = request.getBody();
        Order orderOrder = new Order();
        BeanUtil.copyProperties(orderOrderAddVo, orderOrder);
        this.mapper.insertSelective(orderOrder);
        return Result.ok();
    }

    @Override
    public Result updateOrder(Request<OrderUpdateVo> request) {
        OrderUpdateVo orderOrderUpdateVo = request.getBody();
        Order orderOrder = new Order();
        BeanUtil.copyProperties(orderOrderUpdateVo, orderOrder);
        this.mapper.updateByPrimaryKeySelective(orderOrder);
        return Result.ok();
    }

    @Override
    public Result deleteOrder(Request<OrderDeleteVo> request) {
        OrderDeleteVo orderOrderDeleteVo = request.getBody();
        Order example = new Order();
        BeanUtil.copyProperties(orderOrderDeleteVo, example);
        this.mapper.updateByPrimaryKeySelective(example);
        return Result.ok();
    }
}
