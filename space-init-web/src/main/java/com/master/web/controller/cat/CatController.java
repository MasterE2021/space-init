package com.master.web.controller.cat;

import com.master.service.cat.CatService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yiqunjie
 * @description
 * @date 2023-12-16 16:12
 */
@RestController
@RequestMapping("/cat")
public class CatController {
    @Resource
    private CatService catService;

    @GetMapping("/hello")
    public String hello() {
        return catService.getHello();
    }
}
