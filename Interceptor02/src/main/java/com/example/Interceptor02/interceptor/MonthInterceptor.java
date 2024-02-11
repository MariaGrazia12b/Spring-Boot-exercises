package com.example.Interceptor02.interceptor;

import com.example.Interceptor02.Repository.MonthRepository;
import com.example.Interceptor02.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Component
public class MonthInterceptor implements HandlerInterceptor
{
    private List<Month> months;

    public MonthInterceptor() {
        this.months = new ArrayList<>();
        months.add(new Month(1, "January", "Gennaio", "Januar"));
        months.add(new Month(2, "February", "Febbraio", "Februar"));
        months.add(new Month(3, "March", "Marzo", "März"));
        months.add(new Month(4, "April", "Aprile", "April"));
        months.add(new Month(5, "May", "Maggio", "Mai"));
        months.add(new Month(6, "June", "Giugno", "Juni"));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        //prende l'intestazione monthNumber dalla richiesta
        String monthNumberHeader = request.getHeader("monthNumber");

        //se monthNumber è nullo/vuoto, restituisce un errore HTTP Bad Request
        if (monthNumberHeader == null || monthNumberHeader.isEmpty()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }

        /*int requestedMonthNumber = Integer.parseInt(monthNumberHeader);
        Month requestedMonth = monthRepository.findMonthByMonthNumber(requestedMonthNumber);*/


        Month month = months.stream()
                .filter(monthEntity -> monthEntity.getMonthNumber() == Integer.parseInt(monthNumberHeader))
                .findFirst()
                .orElse(new Month(Integer.parseInt(monthNumberHeader), "nope", "nope", "nope"));

        request.setAttribute("month", month);
        response.setStatus(HttpStatus.OK.value());
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }


}
