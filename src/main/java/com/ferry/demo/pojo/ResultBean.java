package com.ferry.demo.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//封装统一返回结果
@Data
@Slf4j
public class ResultBean<T> {
    private String status;
    private T data;

    public ResultBean(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
