package com.company.project.producerservice.pojo.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/22 15:22
 **/
@Data
@ApiModel(value = "XXX更新参数")
public class ExampleUpdateVo {
    @ApiModelProperty(value = "主键id", name = "id")
    private Long id;

    @ApiModelProperty(value = "名字", name = "name")
    private String name;
}
