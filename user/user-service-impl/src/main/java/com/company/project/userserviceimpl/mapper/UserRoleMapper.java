package com.company.project.userserviceimpl.mapper;

import com.company.project.base.mybatis.Mapper;
import com.company.project.userservice.pojo.entity.UserRole;
import com.company.project.userservice.pojo.query.UserRoleDetailVo;
import com.company.project.userservice.pojo.query.UserRoleQueryVo;
import com.company.project.userservice.pojo.result.UserRoleDetailResultVo;
import com.company.project.userservice.pojo.result.UserRoleResultVo;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {
    List<UserRoleResultVo> selectUserRoleList(UserRoleQueryVo userRoleQueryVo);

    UserRoleDetailResultVo selectUserRole(UserRoleDetailVo userRoleDetailVo);
}