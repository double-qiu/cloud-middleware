package com.middleware.common.util;

import com.middleware.common.exception.GlobalErrorCode;

/**
 * Created by DOUBLE on 2017/04/27.
 *
 * @author DOUBLE
 * @since 2017/04/27
 */
public class IdUtils {

    public static String getId(Long tenantId, String bizId) {
        AssertUtils.notNull(tenantId, GlobalErrorCode.TENANTID_ID_NOT_EMPTY);
        return String.format("%s:%s", tenantId, bizId);
    }
}
