package com.company.project.producerservice.pojo.delete;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/22 15:34
 **/
@Data
@ApiModel(value = "XXX删除参数")
public class ExampleDeleteVo {

    @NotNull
    @ApiModelProperty(value = "主键id", name = "id")
    private Long id;
}
