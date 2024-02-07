package com.example.Interceptor01.Configuration;

import com.example.Interceptor01.Interceptors.APILoggingInterceptor;
import com.example.Interceptor01.Interceptors.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component //in modo tale che Spring la prenda in carico
public class SpringMVCConfiguration implements WebMvcConfigurer {
    //con questa classe abbiamo aggiunto l'interceptor
    //adesso iniettiamo l'interceptor
    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;
    @Autowired
    private TestInterceptor testInterceptor;

    @Override //override del metodo addInterceptors. Se avessi più interceptor basterebbe ripetere la riga nel metodo registry.addInterceptor ecc
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(testInterceptor);
    }
}
