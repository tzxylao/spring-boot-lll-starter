package com.company.project.userservice.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "user_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 0-访客 1-新交付 2-新沉积 3-沉积
     */
    private Integer state;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 所在区域
     */
    private String region;

    /**
     * 客服id
     */
    @Column(name = "cs_id")
    private Long csId;

    /**
     * 用户意向等级 0-无意向 1-1级 2-2级 3-3级 4-号错误 5-已联系  6-拒加粉 10-未沟通
     */
    private Integer intention;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改时间
     */
    private Date modified;

    /**
     * 最近登录时间
     */
    private Date logined;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码修改次数
     */
    @Column(name = "password_changed")
    private Integer passwordChanged;

    /**
     * 来源
     */
    @Column(name = "source_platform")
    private String sourcePlatform;

    /**
     * 登陆错误次数
     */
    @Column(name = "login_errors")
    private Integer loginErrors;

    /**
     * 出生日期
     */
    @Column(name = "birth_date")
    private Date birthDate;

    /**
     * 微信号
     */
    @Column(name = "wx_code")
    private String wxCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户归属 0-未加粉用户 1-已加粉用户
     */
    private Integer belong;

    /**
     * 新交付时间
     */
    @Column(name = "deliver_time")
    private Date deliverTime;

    /**
     * 是否是老用户 0-否 1-是
     */
    private Integer olded;

    /**
     * 微信昵称
     */
    @Column(name = "wx_nick")
    private String wxNick;

    /**
     * 新沉积时间
     */
    @Column(name = "new_deposition_time")
    private Date newDepositionTime;

    /**
     * 沉积时间
     */
    @Column(name = "deposition_time")
    private Date depositionTime;

    /**
     * 加粉时间
     */
    @Column(name = "add_fans_time")
    private Date addFansTime;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private Long channelId;

    /**
     * 用户等级 1-普通用户 2-超级用户
     */
    private Integer level;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取0-访客 1-新交付 2-新沉积 3-沉积
     *
     * @return state - 0-访客 1-新交付 2-新沉积 3-沉积
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0-访客 1-新交付 2-新沉积 3-沉积
     *
     * @param state 0-访客 1-新交付 2-新沉积 3-沉积
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取昵称
     *
     * @return nick - 昵称
     */
    public String getNick() {
        return nick;
    }

    /**
     * 设置昵称
     *
     * @param nick 昵称
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取所在区域
     *
     * @return region - 所在区域
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置所在区域
     *
     * @param region 所在区域
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 获取客服id
     *
     * @return cs_id - 客服id
     */
    public Long getCsId() {
        return csId;
    }

    /**
     * 设置客服id
     *
     * @param csId 客服id
     */
    public void setCsId(Long csId) {
        this.csId = csId;
    }

    /**
     * 获取用户意向等级 0-无意向 1-1级 2-2级 3-3级 4-号错误 5-已联系  6-拒加粉 10-未沟通
     *
     * @return intention - 用户意向等级 0-无意向 1-1级 2-2级 3-3级 4-号错误 5-已联系  6-拒加粉 10-未沟通
     */
    public Integer getIntention() {
        return intention;
    }

    /**
     * 设置用户意向等级 0-无意向 1-1级 2-2级 3-3级 4-号错误 5-已联系  6-拒加粉 10-未沟通
     *
     * @param intention 用户意向等级 0-无意向 1-1级 2-2级 3-3级 4-号错误 5-已联系  6-拒加粉 10-未沟通
     */
    public void setIntention(Integer intention) {
        this.intention = intention;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * 获取修改时间
     *
     * @return modified - 修改时间
     */
    public Date getModified() {
        return modified;
    }

    /**
     * 设置修改时间
     *
     * @param modified 修改时间
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * 获取最近登录时间
     *
     * @return logined - 最近登录时间
     */
    public Date getLogined() {
        return logined;
    }

    /**
     * 设置最近登录时间
     *
     * @param logined 最近登录时间
     */
    public void setLogined(Date logined) {
        this.logined = logined;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取密码修改次数
     *
     * @return password_changed - 密码修改次数
     */
    public Integer getPasswordChanged() {
        return passwordChanged;
    }

    /**
     * 设置密码修改次数
     *
     * @param passwordChanged 密码修改次数
     */
    public void setPasswordChanged(Integer passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    /**
     * 获取来源
     *
     * @return source_platform - 来源
     */
    public String getSourcePlatform() {
        return sourcePlatform;
    }

    /**
     * 设置来源
     *
     * @param sourcePlatform 来源
     */
    public void setSourcePlatform(String sourcePlatform) {
        this.sourcePlatform = sourcePlatform;
    }

    /**
     * 获取登陆错误次数
     *
     * @return login_errors - 登陆错误次数
     */
    public Integer getLoginErrors() {
        return loginErrors;
    }

    /**
     * 设置登陆错误次数
     *
     * @param loginErrors 登陆错误次数
     */
    public void setLoginErrors(Integer loginErrors) {
        this.loginErrors = loginErrors;
    }

    /**
     * 获取出生日期
     *
     * @return birth_date - 出生日期
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 设置出生日期
     *
     * @param birthDate 出生日期
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 获取微信号
     *
     * @return wx_code - 微信号
     */
    public String getWxCode() {
        return wxCode;
    }

    /**
     * 设置微信号
     *
     * @param wxCode 微信号
     */
    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取用户归属 0-未加粉用户 1-已加粉用户
     *
     * @return belong - 用户归属 0-未加粉用户 1-已加粉用户
     */
    public Integer getBelong() {
        return belong;
    }

    /**
     * 设置用户归属 0-未加粉用户 1-已加粉用户
     *
     * @param belong 用户归属 0-未加粉用户 1-已加粉用户
     */
    public void setBelong(Integer belong) {
        this.belong = belong;
    }

    /**
     * 获取新交付时间
     *
     * @return deliver_time - 新交付时间
     */
    public Date getDeliverTime() {
        return deliverTime;
    }

    /**
     * 设置新交付时间
     *
     * @param deliverTime 新交付时间
     */
    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    /**
     * 获取是否是老用户 0-否 1-是
     *
     * @return olded - 是否是老用户 0-否 1-是
     */
    public Integer getOlded() {
        return olded;
    }

    /**
     * 设置是否是老用户 0-否 1-是
     *
     * @param olded 是否是老用户 0-否 1-是
     */
    public void setOlded(Integer olded) {
        this.olded = olded;
    }

    /**
     * 获取微信昵称
     *
     * @return wx_nick - 微信昵称
     */
    public String getWxNick() {
        return wxNick;
    }

    /**
     * 设置微信昵称
     *
     * @param wxNick 微信昵称
     */
    public void setWxNick(String wxNick) {
        this.wxNick = wxNick;
    }

    /**
     * 获取新沉积时间
     *
     * @return new_deposition_time - 新沉积时间
     */
    public Date getNewDepositionTime() {
        return newDepositionTime;
    }

    /**
     * 设置新沉积时间
     *
     * @param newDepositionTime 新沉积时间
     */
    public void setNewDepositionTime(Date newDepositionTime) {
        this.newDepositionTime = newDepositionTime;
    }

    /**
     * 获取沉积时间
     *
     * @return deposition_time - 沉积时间
     */
    public Date getDepositionTime() {
        return depositionTime;
    }

    /**
     * 设置沉积时间
     *
     * @param depositionTime 沉积时间
     */
    public void setDepositionTime(Date depositionTime) {
        this.depositionTime = depositionTime;
    }

    /**
     * 获取加粉时间
     *
     * @return add_fans_time - 加粉时间
     */
    public Date getAddFansTime() {
        return addFansTime;
    }

    /**
     * 设置加粉时间
     *
     * @param addFansTime 加粉时间
     */
    public void setAddFansTime(Date addFansTime) {
        this.addFansTime = addFansTime;
    }

    /**
     * 获取渠道id
     *
     * @return channel_id - 渠道id
     */
    public Long getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道id
     *
     * @param channelId 渠道id
     */
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取用户等级 1-普通用户 2-超级用户
     *
     * @return level - 用户等级 1-普通用户 2-超级用户
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置用户等级 1-普通用户 2-超级用户
     *
     * @param level 用户等级 1-普通用户 2-超级用户
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}