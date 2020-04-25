package com.company.project.userserviceimpl.mapper;

import com.company.project.base.mybatis.Mapper;
import com.company.project.userservice.pojo.entity.User;
import com.company.project.userservice.pojo.query.UserQueryVo;
import com.company.project.userservice.pojo.result.UserResultVo;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    List<UserResultVo> selectUserList(UserQueryVo userUserQueryVo);
}