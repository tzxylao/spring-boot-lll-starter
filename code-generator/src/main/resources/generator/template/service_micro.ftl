package ${rootPackage}.${service}.service;

import ${rootPackage}.${service}.pojo.entity.${modelNameUpperCamel};
import ${rootPackage}.${service}.pojo.query.${modelNameUpperCamel}QueryVo;
import ${rootPackage}.${service}.pojo.add.${modelNameUpperCamel}AddVo;
import ${rootPackage}.${service}.pojo.update.${modelNameUpperCamel}UpdateVo;
import ${rootPackage}.${service}.pojo.query.${modelNameUpperCamel}DetailVo;
<#if javaBean.hasDelete>
import ${rootPackage}.${service}.pojo.delete.${modelNameUpperCamel}DeleteVo;
</#if>
import ${rootPackage}.${service}.pojo.result.${modelNameUpperCamel}DetailResultVo;
import ${rootPackage}.${service}.pojo.result.${modelNameUpperCamel}ResultVo;
import ${rootPackage}.base.mybatis.Service;
import ${rootPackage}.base.common.entity.Request;
import ${rootPackage}.base.common.entity.Result;
import ${rootPackage}.base.common.entity.ResultListVo;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: ${author}
 * @description:
 * @create: ${date}
 **/
@FeignClient(name = "${modelNameLowerCamel}",fallbackFactory = ${modelNameLowerCamel}Service.ServiceFallbackFactory.class)
public interface ${modelNameUpperCamel}Service extends Service<${modelNameUpperCamel}> {

    /**
     * 查询${tableComment}列表
     */
    @PostMapping(value = "/${modelNameLowerCamel}/list")
    Result<ResultListVo<${modelNameUpperCamel}ResultVo>> get${modelNameUpperCamel}List(Request<${modelNameUpperCamel}QueryVo> request);

    /**
     * 查询${tableComment}单项
     */
    @PostMapping(value = "/${modelNameLowerCamel}/list")
    Result<${modelNameUpperCamel}DetailResultVo> get${modelNameUpperCamel}(Request<${modelNameUpperCamel}DetailVo> request);

    /**
     * 添加${tableComment}
     */
    @PostMapping(value = "/${modelNameLowerCamel}/list")
    Result add${modelNameUpperCamel}(Request<${modelNameUpperCamel}AddVo> request);

    /**
     * 更新${tableComment}
     */
    @PostMapping(value = "/${modelNameLowerCamel}/list")
    Result update${modelNameUpperCamel}(Request<${modelNameUpperCamel}UpdateVo> request);

    <#if javaBean.hasDelete>
    /**
     * 删除${tableComment}
     */
    @PostMapping(value = "/${modelNameLowerCamel}/list")                    
    Result delete${modelNameUpperCamel}(Request<${modelNameUpperCamel}DeleteVo> request);
    </#if>
    class ServiceFallbackFactory implements FallbackFactory<${modelNameUpperCamel}Service> {
        @Override
        public ${modelNameUpperCamel}Service create(Throwable throwable) {
            return new ${modelNameUpperCamel}Service() {
                @Override
                public Result<ResultListVo<${modelNameUpperCamel}ResultVo>> get${modelNameUpperCamel}List(Request<${modelNameUpperCamel}QueryVo> request) {
                    throw new DataException("get${modelNameUpperCamel}List异常");
                }

                @Override
                public Result<${modelNameUpperCamel}DetailResultVo> get${modelNameUpperCamel}(Request<${modelNameUpperCamel}DetailVo> request) {
                    throw new DataException("get${modelNameUpperCamel}异常");
                }

                @Override
                public Result add${modelNameUpperCamel}(Request<${modelNameUpperCamel}AddVo> request) {
                    throw new DataException("add${modelNameUpperCamel}异常");
                }

                @Override
                public Result update${modelNameUpperCamel}(Request<${modelNameUpperCamel}UpdateVo> request) {
                    throw new DataException("update${modelNameUpperCamel}异常");
                }

                <#if javaBean.hasDelete>
                @Override
                public Result delete${modelNameUpperCamel}(Request<${modelNameUpperCamel}DeleteVo> request) {
                    throw new DataException("delete${modelNameUpperCamel}异常");
                }
                </#if>
            };
        }
    }
}
