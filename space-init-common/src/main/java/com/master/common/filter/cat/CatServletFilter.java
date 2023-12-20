package com.master.common.filter.cat;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Message;
import com.dianping.cat.message.Transaction;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author yiqunjie
 * @description
 * @date 2023-12-19 15:13
 */
public class CatServletFilter implements Filter {
    private String[] urlPatterns = new String[0];


    /**
     * 过滤初始化
     *
     * @param filterConfig 过滤器配置类
     */
    @Override
    public void init(FilterConfig filterConfig) {
        String parameter = filterConfig.getInitParameter("CatHttpModuleUrlPatterns");
        if (null != parameter) {
            parameter = parameter.trim();
            urlPatterns = parameter.split(",");
            for (int i = 0; i < urlPatterns.length; i++) {
                urlPatterns[i] = urlPatterns[i].trim();
            }
        }
    }

    /**
     * 请求过滤处理
     *
     * @param servletRequest  请求
     * @param servletResponse 响应
     * @param filterChain     过滤器链
     *
     * @exception IOException      异常
     * @exception ServletException 异常
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String url = request.getRequestURL().toString();
        for (String urlPattern : urlPatterns) {
            if (url.startsWith(urlPattern)) {
                url = urlPattern;
            }
        }
        // 存放消息的上下文对象
        CatContext catContext = new CatContext();
        catContext.addProperty(Cat.Context.CHILD, request.getHeader("X-CAT-CHILD-ID"));
        catContext.addProperty(Cat.Context.PARENT, request.getHeader("X-CAT-PARENT-ID"));
        catContext.addProperty(Cat.Context.ROOT, request.getHeader("X-CAT-ROOT-ID"));
        Cat.logRemoteCallServer(catContext);

        Transaction t = Cat.newTransaction(com.dianping.cat.CatConstants.TYPE_URL, url);
        try {
            // 日志记录
            Cat.logEvent("service.method", request.getMethod(), Message.SUCCESS, request.getRequestURL().toString());
            Cat.logEvent("Service.client", request.getRemoteHost());
            filterChain.doFilter(servletRequest, servletResponse);
            // 设置事务状态为 SUCCESS
            t.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            // 设置事务状态，打印日志
            t.setStatus(e);
            Cat.logError(e);
            throw e;
        } finally {
            // 事务完成
            t.complete();
        }
    }
}
