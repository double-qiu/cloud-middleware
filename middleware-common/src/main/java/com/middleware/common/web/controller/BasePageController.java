package com.middleware.common.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.middleware.common.model.PageInfo;
import com.middleware.common.model.PageRestResultBuilder;
import com.middleware.common.model.RestResult;
import com.middleware.common.web.dto.PageInfoDto;

/**
 * Created by DOUBLE on 2017/02/25.
 *
 * @author DOUBLE
 * @since 2017/02/25
 */
public abstract class BasePageController<T> extends BaseController {

    @SuppressWarnings("rawtypes")
	@RequestMapping("/list")
    public RestResult listPage(PageInfoDto pageInfoDto) {
        logger.debug("listPage pageInfoDto: {}", pageInfoDto);
        PageInfo<T> pageInfo = this.listPageInfo(PageInfo.<T>build(pageInfoDto));
        logger.debug("listPage {}", JSON.toJSONString(pageInfo));
        return PageRestResultBuilder.builder().success(pageInfo).build();
    }

    public abstract PageInfo<T> listPageInfo(PageInfo<T> pageInfo);
}
