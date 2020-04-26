package com.company.project.userservice.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.util.Date;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-26 14:49:30
 **/
@Data
@ApiModel(value = "角色表单项查询参数")
public class UserRoleDetailVo {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "角色名", name = "roleName")
    private String roleName;

    @ApiModelProperty(value = "创建人", name = "creator")
    private String creator;

    @ApiModelProperty(value = "创建时间", name = "created")
    private Date created;

    @ApiModelProperty(value = "修改人", name = "modifier")
    private String modifier;

    @ApiModelProperty(value = "修改时间", name = "modified")
    private Date modified;

}
