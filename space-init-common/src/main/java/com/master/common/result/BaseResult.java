package com.master.common.result;

import com.master.common.exception.ExceptionCode;
import com.master.common.exception.BusinessException;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 通用结果
 *
 * @author yiqunjie
 * @description
 * @date 2023-11-18 19:47
 */
@Data
public class BaseResult<T> implements Serializable {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 错误提示，用户可阅读
     */
    private String message;

    /**
     * 请求成功
     *
     * @param data 数据对象
     * @param <T>  数据对象
     *
     * @return 通用结果
     */
    public static <T> BaseResult<T> success(T data) {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.code = 200;
        baseResult.data = data;
        baseResult.message = "OK";
        return baseResult;
    }

    /**
     * 请求成功
     *
     * @param <T> 数据对象
     *
     * @return 通用结果
     */
    public static <T> BaseResult<T> success() {
        BaseResult<T> baseResult = new BaseResult<>();
        baseResult.code = 200;
        baseResult.data = null;
        baseResult.message = "OK";
        return baseResult;
    }


    /**
     * 将传入的 result 对象，转换成另外一个泛型结果的对象
     * 因为 A 方法返回的 CommonResult 对象，不满足调用其的 B 方法的返回，所以需要进行转换。
     *
     * @param result 传入的 result 对象
     * @param <T>    返回的泛型
     *
     * @return 新的 CommonResult 对象
     */
    public static <T> BaseResult<T> error(BaseResult<?> result) {
        return error(result.getCode(), result.getMessage());
    }

    public static <T> BaseResult<T> error(BusinessException businessException) {
        return error(businessException.getCode(), businessException.getMessage());
    }

    public static <T> BaseResult<T> error(Integer code, String message) {
        Assert.isTrue(!ExceptionCode.SUCCESS.getCode().equals(code), "code 必须是错误的！");
        BaseResult<T> result = new BaseResult<>();
        result.code = code;
        result.message = message;
        return result;
    }

    public static <T> BaseResult<T> error(Integer code, String message, T data) {
        Assert.isTrue(!ExceptionCode.SUCCESS.getCode().equals(code), "code 必须是错误的！");
        BaseResult<T> result = new BaseResult<>();
        result.code = code;
        result.data = data;
        result.message = message;
        return result;
    }
}
