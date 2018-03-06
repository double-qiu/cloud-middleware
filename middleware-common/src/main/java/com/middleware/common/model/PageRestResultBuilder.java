package com.middleware.common.model;




/**
 * Created by DOUBLE on 2017/02/25.
 *
 * @author DOUBLE
 * @since 2017/02/25
 */
@SuppressWarnings("rawtypes")
public class PageRestResultBuilder extends RestResultBuilder {

    private int pageNum;

    private int pageSize;

    private long pages;

    @SuppressWarnings("unused")
	private int size;

    private long total;

    public static PageRestResultBuilder builder() {
        PageRestResultBuilder pageRestResultBuilder = new PageRestResultBuilder();
        return pageRestResultBuilder;
    }

    @SuppressWarnings("unchecked")
	public <T> RestResultBuilder success(PageInfo<T> pageInfo) {
        success(pageInfo.getList());
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.pages = pageInfo.getPages();
        this.size = pageInfo.getSize();
        this.total = pageInfo.getTotal();
        return this;
    }

    @Override
    public RestResult build() {
        PageRestResult pageRestResult = new PageRestResult(this.code, this.message, this.data);
        pageRestResult.setPageNum(this.pageNum);
        pageRestResult.setPageSize(this.pageSize);
        pageRestResult.setPages(this.pages);
        pageRestResult.setTotal(this.total);
        return pageRestResult;
    }
}
