package com.master.common.handler;

import com.master.common.exception.BusinessException;
import com.master.common.result.BaseResult;
import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
     * @param e
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {BusinessException.class})
    public BaseResult<Object> handleBusinessException(Exception e) {
        if (e instanceof BusinessException businessException) {
            return BaseResult.error(businessException.getCode(), businessException.getMessage());
        } else {
            log.error("Business Exception:" + e.getMessage(), e);
        }
        return BaseResult.error(-1, "未知业务异常", e.getMessage());
    }

    /**
     * Servlet异常
     *
     * @param e
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {ServletException.class})
    public BaseResult<Object> handleServletException(ServletException e) {

        if (e instanceof HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
            return BaseResult.error(500, "请求方法有误", httpRequestMethodNotSupportedException.getMessage());
        } else if (e instanceof MissingServletRequestParameterException missingServletRequestParameterException) {
            return BaseResult.error(400, "缺少必要的请求参数", missingServletRequestParameterException.getMessage());
        } else {
            log.error("Servlet Exception:" + e.getMessage(), e);
        }
        return BaseResult.error(500, "未知Servlet异常", e.getMessage());
    }

    /**
     * 运行时异常
     *
     * @param e
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {RuntimeException.class})
    public BaseResult<Object> handleRuntimeException(RuntimeException e) {
        if (e instanceof NullPointerException nullPointerException) {
            return BaseResult.error(500, "空指针异常", nullPointerException.getMessage());
        } else if (e instanceof IllegalArgumentException illegalArgumentException) {
            return BaseResult.error(500, "非法参数异常", illegalArgumentException.getMessage());
        } else {
            log.error("System Exception:" + e.getMessage(), e);
        }
        return BaseResult.error(-1, "未知运行时异常");
    }

    /**
     * 位置其他异常
     *
     * @param e
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public BaseResult<Object> handleException(Exception e) {
        return BaseResult.error(-1, "未知异常", e.getMessage());
    }
}
