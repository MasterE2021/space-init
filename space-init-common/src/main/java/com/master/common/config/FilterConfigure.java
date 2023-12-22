package com.master.common.config;

import com.dianping.cat.servlet.CatFilter;
import com.master.common.filter.repeatable.RepeatableFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yiqunjie
 * @description
 * @date 2023-12-19 15:23
 */

@Configuration
@SuppressWarnings({"rawtypes", "unchecked"})
public class FilterConfigure {

    @Bean
    public FilterRegistrationBean catFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CatFilter());
        registration.addUrlPatterns("/*");
        registration.setName("catFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean repeatableFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RepeatableFilter());
        registration.addUrlPatterns("/*");
        registration.setName("repeatableFilter");
        registration.setOrder(2);
        return registration;
    }
}
