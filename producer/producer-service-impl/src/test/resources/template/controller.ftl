package ${rootPackage}.${serivce}.controller;

import ${rootPackage}.common.entity.Request;
import ${rootPackage}.common.entity.Result;
import ${rootPackage}.common.entity.ResultListVo;
import ${rootPackage}.${serivce}.pojo.add.${modelNameUpperCamel}AddVo;
import ${rootPackage}.${serivce}.pojo.query.${modelNameUpperCamel}QueryVo;
import ${rootPackage}.${serivce}.pojo.update.${modelNameUpperCamel}UpdateVo;
import ${rootPackage}.${serivce}.pojo.query.${modelNameUpperCamel}DetailVo;
import ${rootPackage}.${serivce}.pojo.delete.${modelNameUpperCamel}DeleteVo;
import ${rootPackage}.${serivce}.pojo.result.${modelNameUpperCamel}DetailResultVo;
import ${rootPackage}.${serivce}.pojo.result.${modelNameUpperCamel}ResultVo;
import ${rootPackage}.${serivce}.service.${modelNameUpperCamel}Service;
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
    public Result<ResultListVo<${modelNameUpperCamel}ResultVo>> get${modelNameUpperCamel}List(@Validated @RequestBody Request<ExampleQueryVo> request) {
        return ${modelNameLowerCamel}Service.get${modelNameUpperCamel}List(request);
    }

    @ApiOperation("查询${tableComment}单项")
    @PostMapping("/detail")
    public Result<${modelNameUpperCamel}DetailResultVo> get${modelNameUpperCamel}(@Validated @RequestBody Request<ExampleDetailVo> request) {
        return ${modelNameLowerCamel}Service.get${modelNameUpperCamel}(request);
    }

    @ApiOperation("添加${tableComment}")
    @PostMapping("/add")
    public Result add${modelNameUpperCamel}(@Validated @RequestBody Request<ExampleAddVo> unlockOrderAddVo) {
        return ${modelNameLowerCamel}Service.add${modelNameUpperCamel}(request);
    }

    @ApiOperation("更新${tableComment}")
    @PostMapping("/update")
    public Result update${modelNameUpperCamel}(@Validated @RequestBody Request<ExampleUpdateVo> unlockOrderUpdateVo) {
        return ${modelNameLowerCamel}Service.update${modelNameUpperCamel}(request);
    }

    @ApiOperation("删除${tableComment}")
    @PostMapping("/delete")
    public Result deleteExample(@Validated @RequestBody Request<ExampleDeleteVo> unlockOrderDeleteVo) {
        return exampleService.deleteExample(request);
    }
}
