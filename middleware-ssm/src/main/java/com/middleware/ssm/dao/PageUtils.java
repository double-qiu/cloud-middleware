package com.middleware.ssm.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class PageUtils {

    /**
     * 仅查询list不查询count
     */
    public static <T> Page<T> startList(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize, false);
    }

    /**
     * 仅查询count不查询list
     */
    public static <T> Page<T> startCount() {
        return PageHelper.startPage(0, 1, true);
    }

    /**
     * 查询list和count
     */
    public static <T> Page<T> startListCount(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize, true);
    }

    /**
     * 查询list|count|list+count
     * @param pageNum 页码
     * @param pageSize 页数
     * @param count 如果为null，返回list；如果为true，返回count；如果为false，返回list+count。
     * @return page
     */
    public static <T> Page<T> start(Integer pageNum, Integer pageSize, Boolean count) {
        if (count == null) {
            return startList(pageNum, pageSize);
        } else if (count) {
            return startCount();
        } else {
            return startListCount(pageNum, pageSize);
        }
    }
}
