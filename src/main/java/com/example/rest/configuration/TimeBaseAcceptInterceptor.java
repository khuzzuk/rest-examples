package com.example.rest.configuration;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class TimeBaseAcceptInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Date date = new Date();
        if (date.getHours() > 18) {
            return false;
        } else if (date.getHours() < 8) {
            return false;
        }
        return true;
    }
}
