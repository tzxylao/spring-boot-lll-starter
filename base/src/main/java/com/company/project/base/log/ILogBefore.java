package com.company.project.base.log;

import com.company.project.base.common.LogUtil;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/5/9 16:06
 **/
public interface ILogBefore {
    void writeLog(Request request, Result result, Object extendObj);

    default String readableValue(Request request, Result result) {
        return LogUtil.convertReadable(request.getBody(), result.getSource());
    }
}
