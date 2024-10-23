package com.oci.virtualcommunity.util.configuration;

import com.oci.virtualcommunity.util.filter.globalFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class filterConfig {
    @Bean
    public FilterRegistrationBean<globalFilter> webVisitFilterConfigRegistration(){
        FilterRegistrationBean<globalFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new globalFilter());
        filterFilterRegistrationBean.addUrlPatterns("/**");
        return filterFilterRegistrationBean;
    }
}
