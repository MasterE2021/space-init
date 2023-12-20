package com.master.common.filter.repeatable;

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
 * @date 2023-12-19 23:40
 */
public class RepeatableFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 过滤器初始化逻辑
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            if (!(servletRequest instanceof HttpServletRequest)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            // 将改为我们定义的包装类
            ServletRequest requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
            filterChain.doFilter(requestWrapper, servletResponse);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        // 过滤器销毁逻辑
        Filter.super.destroy();
    }
}
