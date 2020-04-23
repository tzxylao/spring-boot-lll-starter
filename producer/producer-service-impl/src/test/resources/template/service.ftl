package ${rootPackage}.${serivce}.service;

import ${rootPackage}.${serivce}.pojo.entity.${modelNameUpperCamel};
import ${rootPackage}.${serivce}.pojo.query.${modelNameUpperCamel}QueryVo;
import ${rootPackage}.${serivce}.pojo.add.${modelNameUpperCamel}AddVo;
import ${rootPackage}.${serivce}.pojo.update.${modelNameUpperCamel}UpdateVo;
import ${rootPackage}.${serivce}.pojo.query.${modelNameUpperCamel}DetailVo;
import ${rootPackage}.${serivce}.pojo.delete.${modelNameUpperCamel}DeleteVo;
import ${rootPackage}.${serivce}.pojo.result.${modelNameUpperCamel}DetailResultVo;
import ${rootPackage}.${serivce}.pojo.result.${modelNameUpperCamel}ResultVo;
import ${rootPackage}.base.mybatis.Service;
import ${rootPackage}.common.entity.Request;
import ${rootPackage}.common.entity.Result;
import ${rootPackage}.common.entity.ResultListVo;


/**
 * @author: ${author}
 * @description:
 * @create: ${date}
 **/
public interface ${modelNameUpperCamel}Service extends Service<${modelNameUpperCamel}> {

    /**
     * 查询${tableComment}列表
     */
    Result<ResultListVo<${modelNameUpperCamel}ResultVo>> get${modelNameUpperCamel}List(Request<${modelNameUpperCamel}QueryVo> request);

    /**
     * 查询${tableComment}单项
     */
    Result<${modelNameUpperCamel}DetailResultVo> get${modelNameUpperCamel}(Request<${modelNameUpperCamel}DetailVo> request);
        
    /**
     * 添加${tableComment}
     */
    Result add${modelNameUpperCamel}(Request<${modelNameUpperCamel}AddVo> request);

    /**
     * 更新${tableComment}
     */
    Result update${modelNameUpperCamel}(Request<${modelNameUpperCamel}UpdateVo> request);

    /**
     * 删除${tableComment}
     */
    Result deleteExample(Request<${modelNameUpperCamel}DeleteVo> request);

}
