package com.cii.bomse.application.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-11 17:08
 * @since 1.0
 */
@ComponentScan(basePackages = {"com.cii.bomse","com.ciiframework"})
@Configuration
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.cii.bomse.**.dao.mapper"})
@EnableAspectJAutoProxy
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class,args);
    }
}
