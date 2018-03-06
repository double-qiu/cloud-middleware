package com.middleware.common.web.dto;


import java.io.Serializable;

/**
 * Created by DOUBLE on 2017/02/25.
 *
 * @author DOUBLE
 * @since 2017/02/25
 */
public class PageInfoDto implements Serializable {

	private static final long serialVersionUID = -4617978647646287180L;

	private Integer pageNum = 1;

    private Integer pageSize = 10;

    private String orderColumn;

    private String dir; //asc ,desc

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "PageInfoDto{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", orderColumn='" + orderColumn + '\'' +
                ", dir='" + dir + '\'' +
                '}';
    }
}
