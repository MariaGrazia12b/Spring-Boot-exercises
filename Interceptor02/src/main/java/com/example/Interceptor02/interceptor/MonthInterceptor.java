package com.example.Interceptor02.interceptor;

import com.example.Interceptor02.Repository.MonthRepository;
import com.example.Interceptor02.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class MonthInterceptor implements HandlerInterceptor
{
    @Autowired
    MonthRepository monthRepository;

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

        int requestedMonthNumber = Integer.parseInt(monthNumberHeader);
        Month requestedMonth = monthRepository.findMonthByMonthNumber(requestedMonthNumber);


        if (requestedMonth == null) {
            request.setAttribute("selectedMonth", new Month(0L, 0, "nope", "nope", "nope"));
        } else {
            request.setAttribute("selectedMonth", requestedMonth);
        }



        return true;
    }


}
