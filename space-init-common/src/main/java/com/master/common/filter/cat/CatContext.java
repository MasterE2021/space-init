package com.master.common.filter.cat;

import com.dianping.cat.Cat;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yiqunjie
 * @description
 * @date 2023-12-19 15:12
 */
public class CatContext implements Cat.Context {
    private final Map<String, String> properties = new HashMap<>();

    @Override
    public void addProperty(String s, String s1) {
        properties.put(s, s1);
    }

    @Override
    public String getProperty(String s) {
        return properties.get(s);
    }
}
