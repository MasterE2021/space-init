package com.master.common.result;

import com.master.common.exception.BusinessException;
import org.junit.jupiter.api.Test;

/**
 * @author yiqunjie
 * @description
 * @date 2023-12-04 0:05
 */
class BaseResultTest {

    @Test
    void error() {
        BaseResult<Object> success = BaseResult.success();
        try {
            BaseResult<Object> error = BaseResult.error(success);
            System.out.println(error);
        } catch (Exception ignored) {
        }
    }

    @Test
    void testError() {
        BusinessException businessException = new BusinessException();
        try {
            BaseResult<Object> error = BaseResult.error(businessException);
            System.out.println(error);
        } catch (Exception ignored) {
        }
    }
}