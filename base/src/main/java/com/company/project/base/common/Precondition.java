package com.company.project.base.common;


import com.company.project.base.exeception.ConditionException;
import com.company.project.base.exeception.DataNullException;
import com.company.project.base.exeception.NotExistException;

/**
 * @author: laoliangliang
 * @description: 常用抛异常工具
 * @create: 2020/3/26 15:40
 **/
public class Precondition {

    /**
     * 判断不存在 3212
     */
    public static void checkNotExist(Object obj, String msg) {
        if (obj == null) {
            throw new NotExistException(msg);
        }
    }

    /**
     * 判断为空 2100
     */
    public static void checkNotNull(Object obj, String msg) {
        if (obj == null) {
            throw new DataNullException(msg);
        }
    }

    /**
     * 条件不符合异常
     */
    public static void throwConditionException(String msg) {
        throw new ConditionException(msg);
    }
}
