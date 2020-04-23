package com.company.project.base.common.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author laoliangliang
 * @description 抽象分页
 * @Date 2019/11/26 15:29
 **/
public abstract class AbstractPage {

    @ApiModelProperty(value = "每页条数", name = "pageSize", example = "10")
    private int pageSize;

    @ApiModelProperty(value = "页码", name = "page", example = "1")
    private int page;

    @ApiModelProperty(hidden = true)
    private int pageStart;

    @ApiModelProperty(value = "排序字段", name = "orderField", hidden = true)
    private String orderField;

    @ApiModelProperty(value = "正序倒序", name = "asc", hidden = true)
    private String asc = "";


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageStart() {
        pageStart = (page - 1) * pageSize;
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getAsc() {
        return asc;
    }

    public void setAsc(String asc) {
        this.asc = asc;
    }
}
