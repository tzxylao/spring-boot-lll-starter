package com.company.project.backgroundservice.service;

import com.company.project.backgroundservice.pojo.entity.UserBackground;
import com.company.project.backgroundservice.pojo.query.UserBackgroundQueryVo;
import com.company.project.backgroundservice.pojo.add.UserBackgroundAddVo;
import com.company.project.backgroundservice.pojo.update.UserBackgroundUpdateVo;
import com.company.project.backgroundservice.pojo.query.UserBackgroundDetailVo;
import com.company.project.backgroundservice.pojo.delete.UserBackgroundDeleteVo;
import com.company.project.backgroundservice.pojo.result.UserBackgroundDetailResultVo;
import com.company.project.backgroundservice.pojo.result.UserBackgroundResultVo;
import com.company.project.base.mybatis.Service;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;


/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-26 15:38:30
 **/
public interface UserBackgroundService extends Service<UserBackground> {

    /**
     * 查询b端用户表列表
     */
    Result<ResultListVo<UserBackgroundResultVo>> getUserBackgroundList(Request<UserBackgroundQueryVo> request);

    /**
     * 查询b端用户表单项
     */
    Result<UserBackgroundDetailResultVo> getUserBackground(Request<UserBackgroundDetailVo> request);

    /**
     * 添加b端用户表
     */
    Result addUserBackground(Request<UserBackgroundAddVo> request);

    /**
     * 更新b端用户表
     */
    Result updateUserBackground(Request<UserBackgroundUpdateVo> request);

    /**
     * 删除b端用户表
     */
    Result deleteUserBackground(Request<UserBackgroundDeleteVo> request);
}
