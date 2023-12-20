package com.master.common.filter.repeatable;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 构建可重复读取inputStream的request
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    /**
     * 请求体
     */
    private byte[] requestBody;

    /**
     * Http请求对象
     */
    private HttpServletRequest request;


    public byte[] getRequestBody() {
        return requestBody;
    }

    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        this.request = request;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        /**
         * 每次调用此方法时将数据流中的数据读取出来，然后再回填到InputStream之中
         * 解决通过@RequestBody和@RequestParam（POST方式）读取一次后控制器拿不到参数问题
         */
        if (null == this.requestBody) {
            ByteArrayOutputStream boStream = new ByteArrayOutputStream();
            IOUtils.copy(request.getInputStream(), boStream);
            this.requestBody = boStream.toByteArray();
        }
        final ByteArrayInputStream biStream = new ByteArrayInputStream(requestBody);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {
            }

            @Override
            public int read() {
                return biStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }
}
