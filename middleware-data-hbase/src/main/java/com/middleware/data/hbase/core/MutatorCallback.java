package com.middleware.data.hbase.core;

import org.apache.hadoop.hbase.client.BufferedMutator;

/**
 * Created by DOUBLE on 2017/04/10.
 *
 * @author DOUBLE
 * @since 2017/04/10
 */
public interface MutatorCallback {

    void doInMutator(BufferedMutator mutator) throws Throwable;
}
