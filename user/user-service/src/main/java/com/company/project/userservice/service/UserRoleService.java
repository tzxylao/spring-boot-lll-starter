package com.company.project.userservice.service;

import com.company.project.base.exeception.DataException;
import com.company.project.userservice.pojo.entity.UserRole;
import com.company.project.userservice.pojo.query.UserRoleQueryVo;
import com.company.project.userservice.pojo.add.UserRoleAddVo;
import com.company.project.userservice.pojo.update.UserRoleUpdateVo;
import com.company.project.userservice.pojo.query.UserRoleDetailVo;
import com.company.project.userservice.pojo.delete.UserRoleDeleteVo;
import com.company.project.userservice.pojo.result.UserRoleDetailResultVo;
import com.company.project.userservice.pojo.result.UserRoleResultVo;
import com.company.project.base.mybatis.Service;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.common.entity.ResultListVo;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-26 14:49:30
 **/
@FeignClient(name = "user", fallbackFactory = UserRoleService.ServiceFallbackFactory.class)
public interface UserRoleService extends Service<UserRole> {

    /**
     * 查询角色表列表
     */
    @PostMapping(value = "/user/role/list")
    Result<ResultListVo<UserRoleResultVo>> getUserRoleList(@Validated @RequestBody Request<UserRoleQueryVo> request);

    /**
     * 查询角色表单项
     */
    @PostMapping(value = "/user/role/detail")
    Result<UserRoleDetailResultVo> getUserRole(@RequestBody Request<UserRoleDetailVo> request);

    /**
     * 添加角色表
     */
    @PostMapping(value = "/user/role/add")
    Result addUserRole(@RequestBody Request<UserRoleAddVo> request);

    /**
     * 更新角色表
     */
    @PostMapping(value = "/user/role/update")
    Result updateUserRole(@RequestBody Request<UserRoleUpdateVo> request);

    /**
     * 删除角色表
     */
    @PostMapping(value = "/user/role/delete")
    Result deleteUserRole(@RequestBody Request<UserRoleDeleteVo> request);

    class ServiceFallbackFactory implements FallbackFactory<UserRoleService> {
        @Override
        public UserRoleService create(Throwable throwable) {
            return new UserRoleService() {
                @Override
                public Result<ResultListVo<UserRoleResultVo>> getUserRoleList(Request<UserRoleQueryVo> request) {
                    throw new DataException("getUserRoleList异常");
                }

                @Override
                public Result<UserRoleDetailResultVo> getUserRole(Request<UserRoleDetailVo> request) {
                    throw new DataException("getUserRole异常");
                }

                @Override
                public Result addUserRole(Request<UserRoleAddVo> request) {
                    throw new DataException("addUserRole异常");
                }

                @Override
                public Result updateUserRole(Request<UserRoleUpdateVo> request) {
                    throw new DataException("updateUserRole异常");
                }

                @Override
                public Result deleteUserRole(Request<UserRoleDeleteVo> request) {
                    throw new DataException("deleteUserRole异常");
                }
            };
        }
    }
}
