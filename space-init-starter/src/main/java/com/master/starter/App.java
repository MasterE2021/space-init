package com.master.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author yiqunjie
 * @description
 * @date 2023-11-18 10:43
 */
@SpringBootApplication(scanBasePackages = {"com.master.web.controller", "com.master.service", "com.master.common.handler"})
@MapperScan(basePackages = {"com.master.repository.mapper"})
public class App {

    static {
        System.setProperty("proxyType", "4");
        System.setProperty("proxyPort", "7890");
        System.setProperty("proxyHost", "127.0.0.1");
        System.setProperty("proxySet", "true");
    }


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
