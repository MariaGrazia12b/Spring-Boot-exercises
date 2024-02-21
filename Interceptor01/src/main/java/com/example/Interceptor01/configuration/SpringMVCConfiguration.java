package com.example.Interceptor01.configuration;

import com.example.Interceptor01.interceptors.APILoggingInterceptor;
import com.example.Interceptor01.interceptors.LegacyIntercepotr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfiguration implements WebMvcConfigurer {
    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;
    @Autowired
    private LegacyIntercepotr legacyIntercepotr;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(legacyIntercepotr).addPathPatterns("/legacy");
    }
}
