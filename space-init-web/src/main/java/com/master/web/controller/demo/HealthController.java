package com.master.web.controller.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 健康检查
 *
 * @author yiqunjie
 * @description 用于健康检查的类
 * @date 2023-11-18 10:53
 */

@RestController
@RequestMapping("/")
public class HealthController {

    @RequestMapping(value = "/health")
    public String HealthCheck() {
        return "success";
    }
}
