package com.company.project.base.business;

import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;

/**
 * @author: laoliangliang
 * @description: 业务处理接口
 * @create: 2020/4/24 17:02
 **/
public interface IBusinessProcessor {

    /**
     * 执行前
     */
    void before(Request request);

    /**
     * 执行后
     */
    void after(Request request, Result result);
}
