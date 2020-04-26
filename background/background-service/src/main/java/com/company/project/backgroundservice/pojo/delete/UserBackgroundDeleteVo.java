package com.company.project.backgroundservice.pojo.delete;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

import java.util.Date;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-26 15:38:30
 **/
@Data
@ApiModel(value = "b端用户表添加参数")
public class UserBackgroundDeleteVo {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "用户名", name = "username")
    private String username;

    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    @ApiModelProperty(value = "手机号", name = "phone")
    private String phone;

    @ApiModelProperty(value = "姓名", name = "name")
    private String name;

    @ApiModelProperty(value = "部门", name = "department")
    private String department;

    @ApiModelProperty(value = "1正常  2关闭", name = "state")
    private Integer state;

    @ApiModelProperty(value = "创建人", name = "creator")
    private String creator;

    @ApiModelProperty(value = "创建时间", name = "created")
    private Date created;

    @ApiModelProperty(value = "修改人", name = "modifier")
    private String modifier;

    @ApiModelProperty(value = "修改时间", name = "modified")
    private Date modified;

    @ApiModelProperty(value = "人员级别 0-普通员工 1-上级领导", name = "level")
    private Integer level;

    @ApiModelProperty(value = "邮件", name = "mail")
    private String mail;

    @ApiModelProperty(value = "月度金额", name = "amount")
    private BigDecimal amount;

}
