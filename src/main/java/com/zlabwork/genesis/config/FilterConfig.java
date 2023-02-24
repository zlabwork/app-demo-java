package com.zlabwork.genesis.config;

import com.zlabwork.genesis.common.MySomeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

// @docs https://www.concretepage.com/spring-boot/spring-boot-filter
// @docs https://cloud.tencent.com/developer/article/1362809

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<MySomeFilter> myFilter() {
        FilterRegistrationBean<MySomeFilter> filterRegBean = new FilterRegistrationBean<>();
        filterRegBean.setFilter(new MySomeFilter());
        filterRegBean.addUrlPatterns("/app/*");
        filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE - 1);
        return filterRegBean;
    }

}
