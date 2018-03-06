package com.middleware.ssm;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.middleware.ssm.dao.CommonDao;
import com.middleware.ssm.web.controller.ControllerHandler;

@Configuration
@Import({CommonDao.class, ControllerHandler.class})
public class SsmAutoConfiguration {

}
