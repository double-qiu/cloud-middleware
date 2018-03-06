package com.middleware.common.service;

import com.middleware.common.model.PageInfo;

/**
 * Created by DOUBLE on 2017/02/25.
 *
 * @author DOUBLE
 * @since 2017/02/25
 */
public interface BasePageService<T> extends BaseService<T> {

    PageInfo<T> listPage(PageInfo<T> pageInfo, T entity);
}
