package ${rootPackage}.${service}.service;

import ${rootPackage}.${service}.pojo.entity.${modelNameUpperCamel};
import ${rootPackage}.${service}.pojo.query.${modelNameUpperCamel}QueryVo;
import ${rootPackage}.${service}.pojo.add.${modelNameUpperCamel}AddVo;
import ${rootPackage}.${service}.pojo.update.${modelNameUpperCamel}UpdateVo;
import ${rootPackage}.${service}.pojo.query.${modelNameUpperCamel}DetailVo;
import ${rootPackage}.${service}.pojo.delete.${modelNameUpperCamel}DeleteVo;
import ${rootPackage}.${service}.pojo.result.${modelNameUpperCamel}DetailResultVo;
import ${rootPackage}.${service}.pojo.result.${modelNameUpperCamel}ResultVo;
import ${rootPackage}.base.mybatis.Service;
import ${rootPackage}.base.common.entity.Request;
import ${rootPackage}.base.common.entity.Result;
import ${rootPackage}.base.common.entity.ResultListVo;


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
    Result delete${modelNameUpperCamel}(Request<${modelNameUpperCamel}DeleteVo> request);

}
