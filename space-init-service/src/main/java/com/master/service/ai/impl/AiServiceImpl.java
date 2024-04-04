package com.master.service.ai.impl;

import com.master.service.ai.AiService;
import jakarta.annotation.Resource;
import org.springframework.ai.client.AiClient;
import org.springframework.stereotype.Service;

/**
 * @author yiqunjie
 * @description
 * @date 2024-04-04 14:33
 */
@Service
public class AiServiceImpl implements AiService {

    @Resource
    private AiClient aiClient;

    @Override
    public String chat(String questions) {
        if (questions == null || questions.trim().length() == 0) {
            questions = "Hi";
        }
        return aiClient.generate(questions);
    }
}
