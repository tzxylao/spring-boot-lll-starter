package com.company.project.producerserviceimpl.business;

import com.company.project.base.business.IBusinessProcessor;
import com.company.project.base.common.entity.Request;
import com.company.project.base.common.entity.Result;
import org.springframework.stereotype.Component;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/24 17:15
 **/
@Component("bussiness")
public class BusinessProcessor implements IBusinessProcessor {
    @Override
    public void before(Request request) {
        System.out.println("before2");
    }

    @Override
    public void after(Request request, Result result) {
        System.out.println("after2");
    }
}
