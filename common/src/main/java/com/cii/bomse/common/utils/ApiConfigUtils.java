package com.cii.bomse.common.utils;

import com.ciiframework.logging.Logger;
import com.ciiframework.logging.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/11/20 14:37
 */
public class ApiConfigUtils {
    private static Logger logger = LoggerFactory.getLogger(ApiConfigUtils.class);

    private static Properties properties;

    static {
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("api.properties");
        } catch (IOException e) {
            logger.error("ConfigUtils load cii.properties error", e);
        }
    }

    public static String getMessage(String code) {
        return properties.getProperty(code, code);
    }

    public static String getMessage(String code, String... args) {
        return MessageFormat.format(properties.getProperty(code, code), args);
    }
}