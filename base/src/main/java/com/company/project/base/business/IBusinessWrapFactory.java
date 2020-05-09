package com.company.project.base.business;

import com.company.project.base.common.entity.BusinessWrap;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;

public interface IBusinessWrapFactory {
    void handleBeforeBusiness(BusinessWrap businessWrap, Request request);

    void handleAfterBusiness(BusinessWrap businessWrap, Request request, Result result);
}
