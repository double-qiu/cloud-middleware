package com.middleware.data.hbase.core;

import org.apache.hadoop.hbase.client.Result;

/**
 * Created by DOUBLE on 2017/04/10.
 *
 * @author DOUBLE
 * @since 2017/04/10
 */
public interface RowMapper<T> {

    T mapRow(Result result, int rowNum) throws Exception;
}
