package com.middleware.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by DOUBLE on 2017/02/17.
 */
public abstract class LoggerService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
}
