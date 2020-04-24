package com.company.project.base.business;

import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;

/**
 * 业务接口实现类，执行后
 */
public interface IBusinessAfter {

    void run(Request request, Result result);
}
