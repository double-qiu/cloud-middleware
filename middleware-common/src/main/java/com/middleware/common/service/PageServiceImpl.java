package com.middleware.common.service;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.middleware.common.model.PageInfo;

/**
 * Created by DOUBLE on 2017/02/25.
 *
 * @author DOUBLE
 * @since 2017/02/25
 */
public abstract class PageServiceImpl<T> extends LoggerService implements BasePageService<T> {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public PageInfo<T> listPage(PageInfo<T> pageInfo, T entity) {
        logger.debug("listPage pageNum:{}, pageSize:{}, entity:{}", pageInfo.getPageNum(), pageInfo
                .getPageSize(), JSON.toJSONString(entity));
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<T> list = this.listAll(entity);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @Override
    public List<T> listAll() {
        logger.debug("pageService Impl listAll");
        return this.listAll(null);
    }
}
