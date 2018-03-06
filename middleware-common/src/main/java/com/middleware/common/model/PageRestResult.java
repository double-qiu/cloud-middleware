package com.middleware.common.model;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * Created by DOUBLE on 2017/02/25.
 *
 * @author DOUBLE
 * @since 2017/02/25
 */
@SuppressWarnings("rawtypes")
public class PageRestResult extends RestResult {

	private static final long serialVersionUID = -6634312434181729600L;

	@JSONField(ordinal = 4)
    private int pageNum;

    @JSONField(ordinal = 5)
    private int pageSize;

    @JSONField(ordinal = 6)
    private long pages;

    @JSONField(ordinal = 7)
    private long total;

    public PageRestResult() {
        super();
    }

    public PageRestResult(int code, String message) {
        super(code, message);
    }

    @SuppressWarnings("unchecked")
	public PageRestResult(int code, String message, Object data) {
        super(code, message, data);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
