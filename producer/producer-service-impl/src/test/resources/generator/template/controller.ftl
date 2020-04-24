package ${rootPackage}.${serviceImpl}.controller;

import ${rootPackage}.base.common.entity.Request;
import ${rootPackage}.base.common.entity.Result;
import ${rootPackage}.base.common.entity.ResultListVo;
import ${rootPackage}.${service}.pojo.add.${modelNameUpperCamel}AddVo;
import ${rootPackage}.${service}.pojo.query.${modelNameUpperCamel}QueryVo;
import ${rootPackage}.${service}.pojo.update.${modelNameUpperCamel}UpdateVo;
import ${rootPackage}.${service}.pojo.query.${modelNameUpperCamel}DetailVo;
<#if javaBean.hasDelete>
import ${rootPackage}.${service}.pojo.delete.${modelNameUpperCamel}DeleteVo;
</#if>
import ${rootPackage}.${service}.pojo.result.${modelNameUpperCamel}DetailResultVo;
import ${rootPackage}.${service}.pojo.result.${modelNameUpperCamel}ResultVo;
import ${rootPackage}.${service}.service.${modelNameUpperCamel}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ${author}
 * @description:
 * @create: ${date}
 **/
@RestController
@RequestMapping("${baseRequestMapping}")
@Api(tags = "${tableComment}管理")
public class ${modelNameUpperCamel}Controller {

    @Autowired
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @ApiOperation("查询${tableComment}列表")
    @PostMapping("/list")
    public Result<ResultListVo<${modelNameUpperCamel}ResultVo>> get${modelNameUpperCamel}List(@Validated @RequestBody Request<${modelNameUpperCamel}QueryVo> request) {
        return ${modelNameLowerCamel}Service.get${modelNameUpperCamel}List(request);
    }

    @ApiOperation("查询${tableComment}单项")
    @PostMapping("/detail")
    public Result<${modelNameUpperCamel}DetailResultVo> get${modelNameUpperCamel}(@Validated @RequestBody Request<${modelNameUpperCamel}DetailVo> request) {
        return ${modelNameLowerCamel}Service.get${modelNameUpperCamel}(request);
    }

    @ApiOperation("添加${tableComment}")
    @PostMapping("/add")
    public Result add${modelNameUpperCamel}(@Validated @RequestBody Request<${modelNameUpperCamel}AddVo> request) {
        return ${modelNameLowerCamel}Service.add${modelNameUpperCamel}(request);
    }

    @ApiOperation("更新${tableComment}")
    @PostMapping("/update")
    public Result update${modelNameUpperCamel}(@Validated @RequestBody Request<${modelNameUpperCamel}UpdateVo> request) {
        return ${modelNameLowerCamel}Service.update${modelNameUpperCamel}(request);
    }

    <#if javaBean.hasDelete>
    @ApiOperation("删除${tableComment}")
    @PostMapping("/delete")
    public Result delete${modelNameUpperCamel}(@Validated @RequestBody Request<${modelNameUpperCamel}DeleteVo> request) {
        return ${modelNameLowerCamel}Service.delete${modelNameUpperCamel}(request);
    }
    </#if>
}
