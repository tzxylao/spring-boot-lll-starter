package ${basePackage}.service;

import ${basePackage}.pojo.entity.${modelNameUpperCamel};
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}QueryVo;
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}AddVo;
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}UpdateVo;
import ${basePackage}.pojo.queryVo.${modelNameUpperCamel}DetailVo;
import ${basePackage}.pojo.resultVo.${modelNameUpperCamel}DetailResultVo;
import ${basePackage}.pojo.resultVo.${modelNameUpperCamel}ResultVo;
import ${coreExtend}.Service;
import com.onegene.base.vo.ResultListVo;
import com.onegene.base.vo.Result;


/**
 * @author: ${author}
 * @description:
 * @create: ${date}
 **/
public interface ${modelNameUpperCamel}Service extends Service<${modelNameUpperCamel}> {

    /**
     * 查询${tableComment}列表
     */
    Result<ResultListVo<${modelNameUpperCamel}ResultVo>> get${modelNameUpperCamel}List(${modelNameUpperCamel}QueryVo ${modelNameLowerCamel}QueryVo);

    /**
     * 查询${tableComment}单项
     */
    Result<${modelNameUpperCamel}DetailResultVo> get${modelNameUpperCamel}(${modelNameUpperCamel}DetailVo ${modelNameLowerCamel}DetailVo);
        
    /**
     * 添加${tableComment}
     */
    Result add${modelNameUpperCamel}(${modelNameUpperCamel}AddVo ${modelNameLowerCamel}AddVo);

    /**
     * 更新${tableComment}
     */
    Result update${modelNameUpperCamel}(${modelNameUpperCamel}UpdateVo ${modelNameLowerCamel}UpdateVo);
}
