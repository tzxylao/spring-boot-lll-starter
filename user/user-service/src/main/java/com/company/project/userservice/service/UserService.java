package com.company.project.userservice.service;

import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;
import com.company.project.base.mybatis.Service;
import com.company.project.userservice.pojo.add.UserAddVo;
import com.company.project.userservice.pojo.delete.UserDeleteVo;
import com.company.project.userservice.pojo.entity.User;
import com.company.project.userservice.pojo.query.UserDetailVo;
import com.company.project.userservice.pojo.query.UserQueryVo;
import com.company.project.userservice.pojo.result.UserDetailResultVo;
import com.company.project.userservice.pojo.result.UserResultVo;
import com.company.project.userservice.pojo.update.UserUpdateVo;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-25 17:00:53
 **/
@FeignClient(name = "user",fallbackFactory = UserService.ServiceFallbackFactory.class)
public interface UserService extends Service<User> {

    /**
     * 查询C端用户信息表列表
     */
    @PostMapping(value = "/user/list")
    Result<ResultListVo<UserResultVo>> getUserList(@RequestBody Request<UserQueryVo> request);

    /**
     * 查询C端用户信息表单项
     */
    @PostMapping(value = "/user/detail")
    Result<UserDetailResultVo> getUser(Request<UserDetailVo> request);

    /**
     * 添加C端用户信息表
     */
    @PostMapping(value = "/user/add")
    Result addUser(Request<UserAddVo> request);

    /**
     * 更新C端用户信息表
     */
    @PostMapping(value = "/user/update")
    Result updateUser(Request<UserUpdateVo> request);

    /**
     * 删除C端用户信息表
     */
    @PostMapping(value = "/user/delete")
    Result deleteUser(Request<UserDeleteVo> request);

    class ServiceFallbackFactory implements FallbackFactory<UserService> {
        @Override
        public UserService create(Throwable throwable) {
            return new UserService() {
                @Override
                public Result<ResultListVo<UserResultVo>> getUserList(Request<UserQueryVo> request) {
                    return null;
                }

                @Override
                public Result<UserDetailResultVo> getUser(Request<UserDetailVo> request) {
                    return null;
                }

                @Override
                public Result addUser(Request<UserAddVo> request) {
                    return null;
                }

                @Override
                public Result updateUser(Request<UserUpdateVo> request) {
                    return null;
                }

                @Override
                public Result deleteUser(Request<UserDeleteVo> request) {
                    return null;
                }
            };
        }
    }
}
