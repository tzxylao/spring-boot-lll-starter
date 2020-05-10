package ${rootPackage}.${service}.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import ${rootPackage}.base.common.entity.AbstractPage;

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
@ApiModel(value = "${tableComment}请求参数")
public class ${modelNameUpperCamel}${suffixQuery} extends AbstractPage {

<#list fields as field>
    @ApiModelProperty(value = "${field.columnComment}", name = "${field.columnName}")
    private ${field.dataType} ${field.columnName};

</#list>

}
