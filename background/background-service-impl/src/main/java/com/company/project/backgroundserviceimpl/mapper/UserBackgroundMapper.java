package com.company.project.backgroundserviceimpl.mapper;

import com.company.project.backgroundservice.pojo.entity.UserBackground;
import com.company.project.backgroundservice.pojo.query.UserBackgroundQueryVo;
import com.company.project.backgroundservice.pojo.result.UserBackgroundResultVo;
import com.company.project.base.mybatis.Mapper;

import java.util.List;

public interface UserBackgroundMapper extends Mapper<UserBackground> {
    List<UserBackgroundResultVo> selectUserBackgroundList(UserBackgroundQueryVo userBackgroundQueryVo);
}