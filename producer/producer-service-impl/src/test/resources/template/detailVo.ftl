package ${basePackage};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
<#if javaBean.hasBigDecimal??>
    <#if javaBean.hasBigDecimal == 1>
import java.math.BigDecimal;
    </#if>
</#if>
<#if hasDate??>
    <#if hasDate == 1>

import java.util.Date;
    </#if>
</#if>

/**
 * @author: ${author}
 * @description:
 * @create: ${date}
 **/
@Data
@ApiModel(value = "${tableComment}单项查询参数")
public class ${modelNameUpperCamel}${suffixDetail} {

<#list fields as field>
    @ApiModelProperty(value = "${field.columnComment}", name = "${field.columnName}")
    private ${field.dataType} ${field.columnName};

</#list>
}
