package com.company.project.dataway.bean;

public class User {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}