package com.company.project.base.business;

import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSON;
import com.company.project.base.common.Precondition;
import com.company.project.base.common.entity.BusinessWrap;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import com.company.project.base.log.ILogAfter;
import com.company.project.base.log.ILogBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/5/9 15:51
 **/
@Component
public class BusinessWrapFactory implements IBusinessWrapFactory {

    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public void handleBeforeBusiness(BusinessWrap businessWrap, Request request) {
        Class bussinessClazz = businessWrap.getBussinessClazz();
        Object extendObj = businessWrap.getExtendObj();
        if (bussinessClazz != null) {
            String action = businessWrap.getAction();
            Object bean = applicationContext.getBean(bussinessClazz);
            Precondition.checkNotNull(bean, String.format("请确认%s是否注入", JSON.toJSONString(businessWrap)));
            if (bean instanceof IBusinessBefore) {
                if (action == null) {
                    ((IBusinessBefore) bean).run(request, null, extendObj);
                } else {
                    ReflectUtil.invoke(bean, action, request, null, extendObj);
                }
            }
            if (bean instanceof ILogBefore) {
                ((ILogBefore) bean).writeLog(request, null, extendObj);
            }
        }
    }

    @Override
    public void handleAfterBusiness(BusinessWrap businessWrap, Request request, Result result) {
        Class bussinessClazz = businessWrap.getBussinessClazz();
        String action = businessWrap.getAction();
        Object extendObj = businessWrap.getExtendObj();
        if (bussinessClazz != null) {
            Object bean = applicationContext.getBean(bussinessClazz);
            Precondition.checkNotNull(bean, String.format("请确认%s是否注入", JSON.toJSONString(businessWrap)));
            if (bean instanceof IBusinessAfter) {
                if (action == null) {
                    ((IBusinessAfter) bean).run(request, result, extendObj);
                } else {
                    ReflectUtil.invoke(bean, action, request, result, extendObj);
                }
            }
            if (bean instanceof ILogAfter) {
                ((ILogAfter) bean).writeLog(request, result, extendObj);
            }
        }
    }

}
