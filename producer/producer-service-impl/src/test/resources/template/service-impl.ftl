package ${basePackage}.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ${basePackage}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.pojo.entity.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}QueryVo;
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}AddVo;
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}UpdateVo;
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}DetailVo;
import ${basePackage}.pojo.resultVo.${modelNameUpperCamel}DetailResultVo;
import ${basePackage}.pojo.resultVo.${modelNameUpperCamel}ResultVo;
import ${coreExtend}.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.onegene.base.vo.ResultListVo;
import javax.annotation.Resource;
import com.onegene.base.vo.Result;


/**
 * @author: ${author}
 * @description:
 * @create: ${date}
 **/
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    @Override
    public Result<ResultListVo<${modelNameUpperCamel}ResultVo>> get${modelNameUpperCamel}List(${modelNameUpperCamel}QueryVo ${modelNameLowerCamel}QueryVo) {
        Page<Object> page = PageHelper.startPage(${modelNameLowerCamel}QueryVo.getPage(), ${modelNameLowerCamel}QueryVo.getPageSize());
        //       List<${modelNameUpperCamel}ResultVo> resultVos = ((${modelNameUpperCamel}Mapper)this.mapper).select${modelNameUpperCamel}List(${modelNameLowerCamel}QueryVo);
        //       return Result.ok(new ResultListVo<${modelNameUpperCamel}ResultVo>().setList(resultVos).setTotal(page.getTotal()));
        return Result.ok();
    }

    @Override
    public Result<${modelNameUpperCamel}DetailResultVo> get${modelNameUpperCamel}(${modelNameUpperCamel}DetailVo ${modelNameLowerCamel}DetailVo) {
        // ${modelNameUpperCamel}DetailResultVo ${modelNameLowerCamel}DetailResultVo = ((${modelNameUpperCamel}Mapper) this.mapper).select${modelNameUpperCamel}(${modelNameLowerCamel}DetailVo);
        // return Result.ok(${modelNameLowerCamel}DetailResultVo);
        return Result.ok();
    }

    @Override
    public Result add${modelNameUpperCamel}(${modelNameUpperCamel}AddVo ${modelNameLowerCamel}AddVo) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = new ${modelNameUpperCamel}();
        BeanUtil.copyProperties(${modelNameLowerCamel}AddVo, ${modelNameLowerCamel});
        this.mapper.insertSelective(${modelNameLowerCamel});
        return Result.ok();
    }

    @Override
    public Result update${modelNameUpperCamel}(${modelNameUpperCamel}UpdateVo ${modelNameLowerCamel}UpdateVo) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = new ${modelNameUpperCamel}();
        BeanUtil.copyProperties(${modelNameLowerCamel}UpdateVo, ${modelNameLowerCamel});
        this.mapper.updateByPrimaryKeySelective(${modelNameLowerCamel});
        return Result.ok();
    }

}
