package com.company.project.base.business;

import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;

/**
 * 业务接口实现类，执行前
 */
public interface IBusinessBefore {

    void run(Request request, Result result, Object extendObj);
}
