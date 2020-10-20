package com.cii.bomse.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description
 * @auth david·cun
 * @date 2020-04-29 10:28
 * @since 1.0
 */
@ComponentScan(basePackages = {"com.cii.bomse","com.ciiframework"})
@Configuration
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.cii.bomse.**.dao.mapper"})
@EnableAspectJAutoProxy
public class MobileApplication {
    public static void main(String[] args) {
        SpringApplication.run(MobileApplication.class);
    }
}
