package com.master.common.handler;

import com.master.common.exception.BusinessException;
import com.master.common.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;

/**
 * 全局异常处理
 * <p>
 * 常见异常可分为3类：业务异常、Servlet异常、常见运行时异常。处理如下
 *
 * @author yiqunjie
 * @description
 * @date 2023-11-19 10:06
 * @see GlobalExceptionHandler#handleBusinessException
 * @see GlobalExceptionHandler#handleServletException
 * @see GlobalExceptionHandler#handleRuntimeException
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常
     *
     * @param e 业务异常
     *
     * @return 返回
     */
    @ResponseBody
    @ExceptionHandler(value = {BusinessException.class})
    public BaseResult<Object> handleBusinessException(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            return BaseResult.error(businessException.getCode(), businessException.getMessage());
        } else {
            log.error("Business Exception:" + e.getMessage(), e);
        }
        return BaseResult.error(-1, "未知业务异常", e.getMessage());
    }

    /**
     * Servlet异常
     *
     * @param e Servlet异常
     *
     * @return 返回
     */
    @ResponseBody
    @ExceptionHandler(value = {ServletException.class})
    public BaseResult<Object> handleServletException(ServletException e) {

        if (e instanceof HttpRequestMethodNotSupportedException) {
            HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException = (HttpRequestMethodNotSupportedException) e;
            return BaseResult.error(500, "请求方法有误", httpRequestMethodNotSupportedException.getMessage());
        } else if (e instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException missingServletRequestParameterException = (MissingServletRequestParameterException) e;
            return BaseResult.error(400, "缺少必要的请求参数", missingServletRequestParameterException.getMessage());
        } else {
            log.error("Servlet Exception:" + e.getMessage(), e);
        }
        return BaseResult.error(500, "未知Servlet异常", e.getMessage());
    }

    /**
     * 运行时异常
     *
     * @param e 运行时异常
     *
     * @return 返回
     */
    @ResponseBody
    @ExceptionHandler(value = {RuntimeException.class})
    public BaseResult<Object> handleRuntimeException(RuntimeException e) {
        if (e instanceof NullPointerException) {
            NullPointerException nullPointerException = (NullPointerException) e;
            return BaseResult.error(500, "空指针异常", nullPointerException.getMessage());
        } else if (e instanceof IllegalArgumentException) {
            IllegalArgumentException illegalArgumentException = (IllegalArgumentException) e;
            return BaseResult.error(500, "非法参数异常", illegalArgumentException.getMessage());
        } else {
            log.error("System Exception:" + e.getMessage(), e);
        }
        return BaseResult.error(-1, "未知运行时异常");
    }

    /**
     * 位置其他异常
     *
     * @param e 位置其他异常
     *
     * @return 返回
     */
    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public BaseResult<Object> handleException(Exception e) {
        return BaseResult.error(-1, "未知异常", e.getMessage());
    }
}
