package com.master.service.cat.impl;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import com.master.service.cat.CatService;
import org.springframework.stereotype.Service;

/**
 * @author yiqunjie
 * @description
 * @date 2023-12-16 16:13
 */
@Service
public class CatServiceImpl implements CatService {

    @Override
    public String getHello() {
        Transaction t = Cat.newTransaction("space-init", "hello");

        try {
            Cat.logEvent("URL.Server", "serverIo", Event.SUCCESS, "ip=127.0.0.1");
            Cat.logMetricForCount("metric.key");
            Cat.logMetricForDuration("metric.key", 5);
            int i = 1 / 0;
            t.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            // 捕获异常，打印异常信息
            t.setStatus(e);
            Cat.logError(e);
        } finally {
            t.complete();
        }
        return "success";
    }
}
