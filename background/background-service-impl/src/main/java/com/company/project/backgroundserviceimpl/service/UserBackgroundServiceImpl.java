package com.company.project.backgroundserviceimpl.service;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.company.project.backgroundserviceimpl.mapper.UserBackgroundMapper;
import com.company.project.backgroundservice.pojo.entity.UserBackground;
import com.company.project.backgroundservice.service.UserBackgroundService;
import com.company.project.backgroundservice.pojo.query.UserBackgroundQueryVo;
import com.company.project.backgroundservice.pojo.add.UserBackgroundAddVo;
import com.company.project.backgroundservice.pojo.update.UserBackgroundUpdateVo;
import com.company.project.backgroundservice.pojo.query.UserBackgroundDetailVo;
import com.company.project.backgroundservice.pojo.delete.UserBackgroundDeleteVo;
import com.company.project.backgroundservice.pojo.result.UserBackgroundDetailResultVo;
import com.company.project.backgroundservice.pojo.result.UserBackgroundResultVo;
import com.company.project.base.mybatis.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;

import java.util.List;


/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-26 15:38:30
 **/
@Service
@Transactional
public class UserBackgroundServiceImpl extends AbstractService<UserBackground> implements UserBackgroundService {

    @Override
    public Result<ResultListVo<UserBackgroundResultVo>> getUserBackgroundList(Request<UserBackgroundQueryVo> request) {
        UserBackgroundQueryVo userBackgroundQueryVo = request.getBody();
        Page<Object> page = PageHelper.startPage(userBackgroundQueryVo.getPage(), userBackgroundQueryVo.getPageSize());
        List<UserBackgroundResultVo> resultVos = ((UserBackgroundMapper) this.mapper).selectUserBackgroundList(userBackgroundQueryVo);
        return Result.ok(new ResultListVo<UserBackgroundResultVo>().setList(resultVos).setTotal(page.getTotal()));
    }

    @Override
    public Result<UserBackgroundDetailResultVo> getUserBackground(Request<UserBackgroundDetailVo> request) {
        UserBackgroundDetailVo userBackgroundDetailVo = request.getBody();
        // UserBackgroundDetailResultVo userBackgroundDetailResultVo = ((UserBackgroundMapper) this.mapper).selectUserBackground(userBackgroundDetailVo);
        // Precondition.checkNotNull(userBackgroundDetailResultVo, "b端用户表不存在");
        // return Result.ok(userBackgroundDetailResultVo);
        return Result.ok();
    }

    @Override
    public Result addUserBackground(Request<UserBackgroundAddVo> request) {
        UserBackgroundAddVo userBackgroundAddVo = request.getBody();
        UserBackground userBackground = new UserBackground();
        BeanUtil.copyProperties(userBackgroundAddVo, userBackground);
        this.mapper.insertSelective(userBackground);
        return Result.ok();
    }

    @Override
    public Result updateUserBackground(Request<UserBackgroundUpdateVo> request) {
        UserBackgroundUpdateVo userBackgroundUpdateVo = request.getBody();
        UserBackground userBackground = new UserBackground();
        BeanUtil.copyProperties(userBackgroundUpdateVo, userBackground);
        this.mapper.updateByPrimaryKeySelective(userBackground);
        return Result.ok();
    }

    @Override
    public Result deleteUserBackground(Request<UserBackgroundDeleteVo> request) {
        UserBackgroundDeleteVo userBackgroundDeleteVo = request.getBody();
        UserBackground example = new UserBackground();
        BeanUtil.copyProperties(userBackgroundDeleteVo, example);
        this.mapper.updateByPrimaryKeySelective(example);
        return Result.ok();
    }
}
