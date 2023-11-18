package com.master.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author yiqunjie
 * @description
 * @date 2023-11-18 10:43
 */
// @SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com.master.web.controller"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
