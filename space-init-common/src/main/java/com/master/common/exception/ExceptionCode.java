package com.master.common.exception;

import lombok.Getter;

/**
 * 错误码枚举
 *
 * @author yiqunjie
 * @description 一般情况下，使用 HTTP 响应状态码 <a href="https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status">...</a>
 * @date 2023-11-18 22:05
 */
@Getter
public enum ExceptionCode {

    UNKNOWN(-1, "未知异常"),
    SUCCESS(200, "成功"),
    BAD_REQUEST(400, "错误的请求语法"),
    UNAUTHORIZED(401, "身份验证未通过"),
    INTERNAL_SERVER_ERROR(500, "服务器异常"),


    ;

    /**
     * 类型
     */
    private final Integer code;
    /**
     * 名字
     */
    private final String msg;

    ExceptionCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
