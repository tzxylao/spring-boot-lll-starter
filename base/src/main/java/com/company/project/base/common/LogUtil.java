package com.company.project.base.common;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.company.project.base.common.annonation.IgnoreLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Field;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/26 11:02
 **/
@Slf4j
public class LogUtil {
    /**
     * 转换成可读日志
     *
     * @param updateClass 更新类
     * @param sourceClass 原值类
     * @return
     */
    public static String convertReadable(Object updateClass, Object sourceClass) {
        if (updateClass == null || sourceClass == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        ApiModel apiModel = AnnotationUtils.getAnnotation(updateClass.getClass(), ApiModel.class);
        if (apiModel != null) {
            builder.append(apiModel.value());
        } else {
            builder.append(updateClass.getClass().getSimpleName()).append("修改");
        }
        builder.append("内容为：");
        Field[] fields = ReflectUtil.getFields(updateClass.getClass());
        for (Field field : fields) {
            IgnoreLog ignoreLog = AnnotationUtils.getAnnotation(field, IgnoreLog.class);
            if (ignoreLog != null) {
                continue;
            }
            // 目标值
            Object fieldValue = ReflectUtil.getFieldValue(updateClass, field);
            if (fieldValue == null) {
                continue;
            }
            ApiModelProperty apiModelProperty = AnnotationUtils.getAnnotation(field, ApiModelProperty.class);
            if (apiModelProperty == null) {
                log.warn("请给{}:{}添加ApiModelProperty注解", updateClass.getClass().getSimpleName(), field.getName());
                continue;
            }
            String key = apiModelProperty.value();
            // 原值
            Object sourceFieldValue = ObjectUtil.defaultIfNull(ReflectUtil.getFieldValue(sourceClass, field.getName()),
                    ReflectUtil.getFieldValue(sourceClass, apiModelProperty.name()));

            if (sourceFieldValue == null) {
                sourceFieldValue = "未填";
            }

            // 若值相同略过
            if (sourceFieldValue.equals(fieldValue)) {
                continue;
            }

            Transfer transfer = new Transfer(key, sourceFieldValue, fieldValue);
            // 转换状态参数
            wrapper(transfer);

            if (apiModel != null) {
                builder.append(transfer.getKey()).append(":").append(transfer.getSource()).append("->").append(transfer.getTarget()).append(";");
            }
        }
        return builder.toString();
    }

    @Data
    @AllArgsConstructor
    private static class Transfer {
        private String key;
        private Object source;
        private Object target;
    }

    private static void wrapper(Transfer transfer) {
        String key = transfer.getKey();
        boolean contains = key.contains("-") && key.contains(" ");
        if (!contains) {
            return;
        }

        String[] split = key.split(" ");
        if (split.length > 1) {
            transfer.setKey(split[0]);
            for (String param : split) {
                String[] split1 = param.trim().split("-");
                if (split1.length == 2) {
                    if (split1[0].equals(String.valueOf(transfer.getSource()))) {
                        transfer.setSource(split1[1]);
                    }
                    if (split1[0].equals(String.valueOf(transfer.getTarget()))) {
                        transfer.setTarget(split1[1]);
                    }
                }
            }
        }
    }
}
