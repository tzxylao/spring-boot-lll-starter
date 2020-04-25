package com.company.project.userserviceimpl.service;

import cn.hutool.core.bean.BeanUtil;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;
import com.company.project.base.mybatis.AbstractService;
import com.company.project.userservice.pojo.add.UserAddVo;
import com.company.project.userservice.pojo.delete.UserDeleteVo;
import com.company.project.userservice.pojo.entity.User;
import com.company.project.userservice.pojo.query.UserDetailVo;
import com.company.project.userservice.pojo.query.UserQueryVo;
import com.company.project.userservice.pojo.result.UserDetailResultVo;
import com.company.project.userservice.pojo.result.UserResultVo;
import com.company.project.userservice.pojo.update.UserUpdateVo;
import com.company.project.userservice.service.UserService;
import com.company.project.userserviceimpl.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-25 17:00:53
 **/
@RestController
@Slf4j
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Override
    public Result<ResultListVo<UserResultVo>> getUserList(Request<UserQueryVo> request) {
        UserQueryVo userUserQueryVo = request.getBody();
        Page<Object> page = PageHelper.startPage(userUserQueryVo.getPage(), userUserQueryVo.getPageSize());
        List<UserResultVo> resultVos = ((UserMapper) this.mapper).selectUserList(userUserQueryVo);
        return Result.ok(new ResultListVo<UserResultVo>().setList(resultVos).setTotal(page.getTotal()));
    }

    @Override
    public Result<UserDetailResultVo> getUser(Request<UserDetailVo> request) {
        UserDetailVo userUserDetailVo = request.getBody();
        // UserDetailResultVo userUserDetailResultVo = ((UserMapper) this.mapper).selectUser(userUserDetailVo);
        // Precondition.checkNotNull(userUserDetailResultVo, "C端用户信息表不存在");
        // return Result.ok(userUserDetailResultVo);
        return Result.ok();
    }

    @Override
    public Result addUser(Request<UserAddVo> request) {
        UserAddVo userUserAddVo = request.getBody();
        User userUser = new User();
        BeanUtil.copyProperties(userUserAddVo, userUser);
        this.mapper.insertSelective(userUser);
        return Result.ok();
    }

    @Override
    public Result updateUser(Request<UserUpdateVo> request) {
        UserUpdateVo userUserUpdateVo = request.getBody();
        User userUser = new User();
        BeanUtil.copyProperties(userUserUpdateVo, userUser);
        this.mapper.updateByPrimaryKeySelective(userUser);
        return Result.ok();
    }

    @Override
    public Result deleteUser(Request<UserDeleteVo> request) {
        UserDeleteVo userUserDeleteVo = request.getBody();
        User example = new User();
        BeanUtil.copyProperties(userUserDeleteVo, example);
        this.mapper.updateByPrimaryKeySelective(example);
        return Result.ok();
    }
}
