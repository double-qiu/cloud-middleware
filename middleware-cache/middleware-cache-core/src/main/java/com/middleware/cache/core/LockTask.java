package com.middleware.cache.core;

/**
 * 加锁执行的任务
 *
 * @author DOUBLE 2016年7月19日
 */
public interface LockTask<T> {

    /**
     * 工作
     */
    public T work();
}
