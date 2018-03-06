package com.middleware.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class SystemProperties {
    private static final String PATH = "/system.properties";
    private static final Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(SystemProperties.class);

    static {
        init();
    }

    private SystemProperties() {
    }

    public static void init() {
        try {
            Resource resource = new ClassPathResource(PATH);
            properties.load(resource.getInputStream());
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static Boolean setProperty(String key, String value) {
        FileOutputStream fos = null;
        properties.setProperty(key, value);
        try {
            fos = new FileOutputStream(new ClassPathResource(PATH).getFile());
            properties.store(fos, "Copyright (c) Jason");
            return Boolean.TRUE;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Boolean.FALSE;
    }

    public static String getProperties(String key) {
        return properties.getProperty(key, StringUtils.EMPTY);
    }

    public static String getIgnoreUrl() {
        return getProperties("ignore_url") + getProperties("ignore_url_v2");
    }

    public static String getFilePath() {
        return getProperties("FILE_PATH");
    }

    public static String getAPPPath() {
        return getFilePath() + File.separatorChar + getProperties("APP_UPDATE_client");
    }
}
