package com.company.project.base.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/22 16:29
 **/
public class ToolUtil {

    public static String getNotNullValueStr(String target, String defaultValue) {
        if (StringUtils.isEmpty(target)) {
            return defaultValue;
        }
        return target;
    }
}
