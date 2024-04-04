package com.master.web.controller.ai;

import com.master.common.result.BaseResult;
import com.master.service.ai.AiService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yiqunjie
 * @description
 * @date 2024-04-04 14:39
 */
@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private AiService aiService;


    @PostMapping("/chat")
    public BaseResult<String> chat(@RequestBody String questions) {
        String answers = aiService.chat(questions);
        return BaseResult.success(answers);
    }

}
