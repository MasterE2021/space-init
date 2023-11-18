package com.master.web.controller.demo;


import com.alibaba.fastjson.JSON;
import com.master.api.dto.user.UserDTO;
import com.master.service.user.UserService;
import jakarta.annotation.Resource;
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
public class HealthController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/health")
    public String HealthCheck() {
        return "success";
    }

    @RequestMapping(value = "/getUser")
    public String getUser() {
        UserDTO user = userService.getUser();
        return JSON.toJSONString(user);
    }
}
