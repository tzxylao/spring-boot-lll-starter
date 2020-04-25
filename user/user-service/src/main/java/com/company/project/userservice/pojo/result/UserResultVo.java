package com.company.project.userservice.pojo.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.util.Date;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020-04-25 17:00:53
 **/
@Data
@ApiModel(value = "C端用户信息表结果参数")
public class UserResultVo {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "0-访客 1-新交付 2-新沉积 3-沉积", name = "state")
    private Integer state;

    @ApiModelProperty(value = "手机号", name = "phone")
    private String phone;

    @ApiModelProperty(value = "昵称", name = "nick")
    private String nick;

    @ApiModelProperty(value = "姓名", name = "name")
    private String name;

    @ApiModelProperty(value = "头像", name = "avatar")
    private String avatar;

    @ApiModelProperty(value = "性别", name = "gender")
    private Integer gender;

    @ApiModelProperty(value = "所在区域", name = "region")
    private String region;

    @ApiModelProperty(value = "客服id", name = "csId")
    private Long csId;

    @ApiModelProperty(value = "用户意向等级 0-无意向 1-1级 2-2级 3-3级 4-号错误 5-已联系  6-拒加粉 10-未沟通", name = "intention")
    private Integer intention;

    @ApiModelProperty(value = "创建人", name = "creator")
    private String creator;

    @ApiModelProperty(value = "创建时间", name = "created")
    private Date created;

    @ApiModelProperty(value = "修改人", name = "modifier")
    private String modifier;

    @ApiModelProperty(value = "修改时间", name = "modified")
    private Date modified;

    @ApiModelProperty(value = "最近登录时间", name = "logined")
    private Date logined;

    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    @ApiModelProperty(value = "密码修改次数", name = "passwordChanged")
    private Integer passwordChanged;

    @ApiModelProperty(value = "来源", name = "sourcePlatform")
    private String sourcePlatform;

    @ApiModelProperty(value = "登陆错误次数", name = "loginErrors")
    private Integer loginErrors;

    @ApiModelProperty(value = "出生日期", name = "birthDate")
    private Date birthDate;

    @ApiModelProperty(value = "微信号", name = "wxCode")
    private String wxCode;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @ApiModelProperty(value = "用户归属 0-未加粉用户 1-已加粉用户", name = "belong")
    private Integer belong;

    @ApiModelProperty(value = "新交付时间", name = "deliverTime")
    private Date deliverTime;

    @ApiModelProperty(value = "是否是老用户 0-否 1-是", name = "olded")
    private Integer olded;

    @ApiModelProperty(value = "微信昵称", name = "wxNick")
    private String wxNick;

    @ApiModelProperty(value = "新沉积时间", name = "newDepositionTime")
    private Date newDepositionTime;

    @ApiModelProperty(value = "沉积时间", name = "depositionTime")
    private Date depositionTime;

    @ApiModelProperty(value = "加粉时间", name = "addFansTime")
    private Date addFansTime;

    @ApiModelProperty(value = "渠道id", name = "channelId")
    private Long channelId;

    @ApiModelProperty(value = "用户等级 1-普通用户 2-超级用户", name = "level")
    private Integer level;

}
