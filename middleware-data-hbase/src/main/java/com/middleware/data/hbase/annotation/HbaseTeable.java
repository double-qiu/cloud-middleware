package com.middleware.data.hbase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by DOUBLE on 2017/04/11.
 *
 * @author DOUBLE
 * @since 2017/04/11
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface HbaseTeable {

    String tableName();

    String family();
}
