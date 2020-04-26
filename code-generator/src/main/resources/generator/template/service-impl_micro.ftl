package ${rootPackage}.${serviceImpl}.service;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ${rootPackage}.${service}.pojo.entity.${modelNameUpperCamel};
import ${rootPackage}.${service}.service.${modelNameUpperCamel}Service;
import ${rootPackage}.${service}.pojo.query.${modelNameUpperCamel}QueryVo;
import ${rootPackage}.${service}.pojo.add.${modelNameUpperCamel}AddVo;
import ${rootPackage}.${service}.pojo.update.${modelNameUpperCamel}UpdateVo;
import ${rootPackage}.${service}.pojo.query.${modelNameUpperCamel}DetailVo;
<#if javaBean.hasDelete>
import ${rootPackage}.${service}.pojo.delete.${modelNameUpperCamel}DeleteVo;
</#if>
import ${rootPackage}.${service}.pojo.result.${modelNameUpperCamel}DetailResultVo;
import ${rootPackage}.${service}.pojo.result.${modelNameUpperCamel}ResultVo;
import ${rootPackage}.base.mybatis.AbstractService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import ${rootPackage}.base.common.entity.Request;
import ${rootPackage}.base.common.entity.Result;
import ${rootPackage}.base.common.entity.ResultListVo;


/**
 * @author: ${author}
 * @description:
 * @create: ${date}
 **/
@Transactional
@RestController
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    @Override
    public Result<ResultListVo<${modelNameUpperCamel}ResultVo>> get${modelNameUpperCamel}List(Request<${modelNameUpperCamel}QueryVo> request) {
        ${modelNameUpperCamel}QueryVo ${modelNameLowerCamel}QueryVo = request.getBody();
        Page<Object> page = PageHelper.startPage(${modelNameLowerCamel}QueryVo.getPage(), ${modelNameLowerCamel}QueryVo.getPageSize());
        //       List<${modelNameUpperCamel}ResultVo> resultVos = ((${modelNameUpperCamel}Mapper)this.mapper).select${modelNameUpperCamel}List(${modelNameLowerCamel}QueryVo);
        //       return Result.ok(new ResultListVo<${modelNameUpperCamel}ResultVo>().setList(resultVos).setTotal(page.getTotal()));
        return Result.ok();
    }

    @Override
    public Result<${modelNameUpperCamel}DetailResultVo> get${modelNameUpperCamel}(Request<${modelNameUpperCamel}DetailVo> request) {
        ${modelNameUpperCamel}DetailVo ${modelNameLowerCamel}DetailVo = request.getBody();
        // ${modelNameUpperCamel}DetailResultVo ${modelNameLowerCamel}DetailResultVo = ((${modelNameUpperCamel}Mapper) this.mapper).select${modelNameUpperCamel}(${modelNameLowerCamel}DetailVo);
        // Precondition.checkNotNull(${modelNameLowerCamel}DetailResultVo, "${tableComment}不存在");
        // return Result.ok(${modelNameLowerCamel}DetailResultVo);
        return Result.ok();
    }

    @Override
    public Result add${modelNameUpperCamel}(Request<${modelNameUpperCamel}AddVo> request) {
        ${modelNameUpperCamel}AddVo ${modelNameLowerCamel}AddVo = request.getBody();
        ${modelNameUpperCamel} ${modelNameLowerCamel} = new ${modelNameUpperCamel}();
        BeanUtil.copyProperties(${modelNameLowerCamel}AddVo, ${modelNameLowerCamel});
        this.mapper.insertSelective(${modelNameLowerCamel});
        return Result.ok();
    }

    @Override
    public Result update${modelNameUpperCamel}(Request<${modelNameUpperCamel}UpdateVo> request) {
        ${modelNameUpperCamel}UpdateVo ${modelNameLowerCamel}UpdateVo = request.getBody();
        ${modelNameUpperCamel} ${modelNameLowerCamel} = new ${modelNameUpperCamel}();
        BeanUtil.copyProperties(${modelNameLowerCamel}UpdateVo, ${modelNameLowerCamel});
        this.mapper.updateByPrimaryKeySelective(${modelNameLowerCamel});
        return Result.ok();
    }

    <#if javaBean.hasDelete>
    @Override
    public Result delete${modelNameUpperCamel}(Request<${modelNameUpperCamel}DeleteVo> request) {
        ${modelNameUpperCamel}DeleteVo ${modelNameLowerCamel}DeleteVo = request.getBody();
        ${modelNameUpperCamel} example = new ${modelNameUpperCamel}();
        BeanUtil.copyProperties(${modelNameLowerCamel}DeleteVo, example);
        this.mapper.updateByPrimaryKeySelective(example);
        return Result.ok();
    }
    </#if>
}
