package com.example.Interceptor01.Interceptors;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//con questa classe abbiamo definito l'interceptor
@Component //in modo tale che spring la prenda in incarico e gestisca il lifecicle della classe
//L'interceptor per essere tale deve estendere una classe specifica che è handlerinterceptor che è un'interfaccia
public class APILoggingInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("Request URL::" + request.getRequestURL().toString() + "::Start Time=" + System.currentTimeMillis());
        request.setAttribute("startTime", startTime);
        return true; //se faccio return false non mi ritorna niente xkè sto bloccando il prechiamata
    } //metodo che viene chiamato prima che il controller inizi a lavorare
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    } //viene chiamata dopo che gestisco una chiamata API
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    } //viene chiamata dopo che ho chiamato la mia richiesta API, quindi non posso modificare più niente mentre prima si
}

