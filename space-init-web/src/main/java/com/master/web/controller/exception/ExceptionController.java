package com.master.web.controller.exception;

import com.master.common.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author yiqunjie
 * @description
 * @date 2023-11-18 22:23
 */
@RestController
@RequestMapping("/exception")
@Slf4j
public class ExceptionController {

    @PostMapping("/getError")
    public BaseResult<Object> getError(@RequestBody String str) {
        return BaseResult.error(200, "测试异常" + str);
    }

    @PostMapping("/absenceRequestParam")
    public BaseResult<Object> absenceRequestParam(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        log.info("name：{}", name);
        log.info("pass：{}", pass);
        return BaseResult.success();
    }
}
