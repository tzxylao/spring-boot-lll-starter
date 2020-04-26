package com.company.project.backgroundservice.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_background")
public class UserBackground {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 部门
     */
    private String department;

    /**
     * 1正常  2关闭
     */
    private Integer state;

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
     * 人员级别 0-普通员工 1-上级领导
     */
    private Integer level;

    /**
     * 邮件
     */
    private String mail;

    /**
     * 月度金额
     */
    private Integer amount;

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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
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
     * 获取部门
     *
     * @return department - 部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置部门
     *
     * @param department 部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取1正常  2关闭
     *
     * @return state - 1正常  2关闭
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1正常  2关闭
     *
     * @param state 1正常  2关闭
     */
    public void setState(Integer state) {
        this.state = state;
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
     * 获取人员级别 0-普通员工 1-上级领导
     *
     * @return level - 人员级别 0-普通员工 1-上级领导
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置人员级别 0-普通员工 1-上级领导
     *
     * @param level 人员级别 0-普通员工 1-上级领导
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取邮件
     *
     * @return mail - 邮件
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮件
     *
     * @param mail 邮件
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 获取月度金额
     *
     * @return amount - 月度金额
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置月度金额
     *
     * @param amount 月度金额
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}