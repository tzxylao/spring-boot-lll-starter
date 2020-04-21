package ${basePackage}.controller;

import com.onegene.base.vo.Result;
import com.onegene.base.vo.ResultListVo;
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}AddVo;
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}QueryVo;
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}UpdateVo;
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}DetailVo;
import ${basePackage}.pojo.resultVo.${modelNameUpperCamel}DetailResultVo;
import ${basePackage}.pojo.resultVo.${modelNameUpperCamel}ResultVo;
import ${basePackage}.service.${modelNameUpperCamel}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    public Result<ResultListVo<${modelNameUpperCamel}ResultVo>> get${modelNameUpperCamel}List(@RequestBody ${modelNameUpperCamel}QueryVo ${modelNameLowerCamel}QueryVo) {
        return ${modelNameLowerCamel}Service.get${modelNameUpperCamel}List(${modelNameLowerCamel}QueryVo);
    }

    @ApiOperation("查询${tableComment}单项")
    @PostMapping("/detail")
    public Result<${modelNameUpperCamel}DetailResultVo> get${modelNameUpperCamel}(@RequestBody ${modelNameUpperCamel}DetailVo ${modelNameLowerCamel}DetailVo) {
        return ${modelNameLowerCamel}Service.get${modelNameUpperCamel}(${modelNameLowerCamel}DetailVo);
    }

    @ApiOperation("添加${tableComment}")
    @PostMapping("/add")
    public Result add${modelNameUpperCamel}(@RequestBody ${modelNameUpperCamel}AddVo ${modelNameLowerCamel}AddVo) {
        return ${modelNameLowerCamel}Service.add${modelNameUpperCamel}(${modelNameLowerCamel}AddVo);
    }

    @ApiOperation("更新${tableComment}")
    @PostMapping("/update")
    public Result update${modelNameUpperCamel}(@RequestBody ${modelNameUpperCamel}UpdateVo ${modelNameLowerCamel}UpdateVo) {
        return ${modelNameLowerCamel}Service.update${modelNameUpperCamel}(${modelNameLowerCamel}UpdateVo);
    }

}
