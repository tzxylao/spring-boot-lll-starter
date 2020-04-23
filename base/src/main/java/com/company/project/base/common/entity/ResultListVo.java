package com.company.project.base.common.entity;

import java.util.List;

/**
 * 用以返回分页数据
 * @param <T>
 */
public class ResultListVo<T> {
    private List<T> list;
    private long total;

    public ResultListVo() {
    }

    public ResultListVo<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

    public ResultListVo<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    public List<T> getList() {
        return this.list;
    }

    public long getTotal() {
        return this.total;
    }
}