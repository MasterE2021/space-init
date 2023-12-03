package com.master.common.utils;

import org.junit.jupiter.api.Test;

/**
 * @author yiqunjie
 * @description
 * @date 2023-12-04 0:03
 */
class ToolsTest {

    @Test
    void isEmpty() {
    }

    @Test
    void isNotEmpty() {
        boolean notEmpty = Tools.isNotEmpty("");
        System.out.println(notEmpty);
    }
}