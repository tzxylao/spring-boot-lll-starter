package com.company.project.base.business;

import com.company.project.base.common.entity.BusinessWrap;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/24 17:15
 **/
@Component
public class BusinessProcessor implements IBusinessProcessor {

    @Autowired
    private IBusinessWrapFactory businessWrapFactory;

    @Override
    public void before(Request request) {
        List<BusinessWrap> businessClass = request.getBusinessClass();
        if (businessClass == null) {
            return;
        }
        for (BusinessWrap businessWrap : businessClass) {
            // 处理前置业务
            businessWrapFactory.handleBeforeBusiness(businessWrap, request);
        }
    }

    @Override
    public void after(Request request, Result result) {
        List<BusinessWrap> businessClass = result.getBusinessClass();
        if (businessClass == null) {
            return;
        }
        for (BusinessWrap businessWrap : businessClass) {
            // 处理后置业务
            businessWrapFactory.handleAfterBusiness(businessWrap, request, result);
        }
    }
}
