package com.company.project.base.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/30 16:28
 **/
@Data
public class AbstractBusiness {
    /**
     * 执行业务类名
     */
    @JsonIgnore
    private List<BusinessWrap> businessClass;

    public static BusinessWrap wrap(Class clazz) {
        return new BusinessWrap(clazz);
    }

    public static List<BusinessWrap> wrapArray(Class... clazz) {
        List<BusinessWrap> wraps = new ArrayList<>();
        for (Class aClass : clazz) {
            BusinessWrap businessWrap = new BusinessWrap(aClass);
            wraps.add(businessWrap);
        }
        return wraps;
    }

    public static BusinessWrap wrap(Class clazz, Object extendObj, String action) {
        return new BusinessWrap(clazz, extendObj, action);
    }


    public static BusinessWrap wrap(Class clazz, Object extendObj) {
        return new BusinessWrap(clazz, extendObj);
    }

}
