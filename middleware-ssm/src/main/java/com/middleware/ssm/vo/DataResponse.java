package com.middleware.ssm.vo;

public class DataResponse<T> extends BaseResponse {
    private T data;
    private Long total;

    public DataResponse(T data) {
        this(data, null);
    }

    public DataResponse(T data, Long total) {
        super(0, "success");
        this.data = data;
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
