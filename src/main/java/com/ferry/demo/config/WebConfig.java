package com.ferry.demo.config;

import com.ferry.demo.filter.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Filter;

@Configuration
public class WebConfig {
    @Autowired
    private MyFilter myFilter;

    @Bean
    public FilterRegistrationBean initFilter(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        registrationBean.setFilter(myFilter);
        registrationBean.setName("myFilter");
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
