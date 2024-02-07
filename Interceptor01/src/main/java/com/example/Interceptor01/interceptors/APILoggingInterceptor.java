package com.example.Interceptor01.interceptors;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//APILoggingInterceptor che stampa nella console l'header delle richieste User-Agent prima di gestirle
@Component
public class APILoggingInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*long startTime = System.currentTimeMillis();
        System.out.println("Request URL::" + request.getRequestURL().toString() + "::Start Time=" + System.currentTimeMillis());
        request.setAttribute("startTime", startTime);
        return true;*/
        System.out.println("User-Agent: " + request.getHeader("User-Agent"));
        return true;
    }

}
