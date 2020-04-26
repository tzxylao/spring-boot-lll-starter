package com.company.project.userserviceimpl.service;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.company.project.userservice.pojo.entity.UserRole;
import com.company.project.userservice.service.UserRoleService;
import com.company.project.userservice.pojo.query.UserRoleQueryVo;
import com.company.project.userservice.pojo.add.UserRoleAddVo;
import com.company.project.userservice.pojo.update.UserRoleUpdateVo;
import com.company.project.userservice.pojo.query.UserRoleDetailVo;
import com.company.project.userservice.pojo.delete.UserRoleDeleteVo;
import com.company.project.userservice.pojo.result.UserRoleDetailResultVo;
import com.company.project.userservice.pojo.result.UserRoleResultVo;
import com.company.project.base.mybatis.AbstractService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;


/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-26 14:49:30
 **/
@Transactional
@RestController
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {

    @Override
    public Result<ResultListVo<UserRoleResultVo>> getUserRoleList(@Validated  Request<UserRoleQueryVo> request) {
        UserRoleQueryVo userRoleQueryVo = request.getBody();
        Page<Object> page = PageHelper.startPage(userRoleQueryVo.getPage(), userRoleQueryVo.getPageSize());
        //       List<UserRoleResultVo> resultVos = ((UserRoleMapper)this.mapper).selectUserRoleList(userRoleQueryVo);
        //       return Result.ok(new ResultListVo<UserRoleResultVo>().setList(resultVos).setTotal(page.getTotal()));
        return Result.ok();
    }

    @Override
    public Result<UserRoleDetailResultVo> getUserRole(Request<UserRoleDetailVo> request) {
        UserRoleDetailVo userRoleDetailVo = request.getBody();
        // UserRoleDetailResultVo userRoleDetailResultVo = ((UserRoleMapper) this.mapper).selectUserRole(userRoleDetailVo);
        // Precondition.checkNotNull(userRoleDetailResultVo, "角色表不存在");
        // return Result.ok(userRoleDetailResultVo);
        return Result.ok();
    }

    @Override
    public Result addUserRole(Request<UserRoleAddVo> request) {
        UserRoleAddVo userRoleAddVo = request.getBody();
        UserRole userRole = new UserRole();
        BeanUtil.copyProperties(userRoleAddVo, userRole);
        this.mapper.insertSelective(userRole);
        return Result.ok();
    }

    @Override
    public Result updateUserRole(Request<UserRoleUpdateVo> request) {
        UserRoleUpdateVo userRoleUpdateVo = request.getBody();
        UserRole userRole = new UserRole();
        BeanUtil.copyProperties(userRoleUpdateVo, userRole);
        this.mapper.updateByPrimaryKeySelective(userRole);
        return Result.ok();
    }

    @Override
    public Result deleteUserRole(Request<UserRoleDeleteVo> request) {
        UserRoleDeleteVo userRoleDeleteVo = request.getBody();
        UserRole example = new UserRole();
        BeanUtil.copyProperties(userRoleDeleteVo, example);
        this.mapper.updateByPrimaryKeySelective(example);
        return Result.ok();
    }
}
