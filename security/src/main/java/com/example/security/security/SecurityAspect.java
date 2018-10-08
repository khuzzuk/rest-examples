package com.example.security.security;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {
    @Before("execution(* com.example.security.user.UserRemoteServiceImpl.getUser(..))")
    public void logSecurityAccess() {
        System.out.println("I can see you");
    }

    @After("execution(* *(..)) && @annotation(com.example.security.security.Catch)")
    public void logCatchAccess() {
        System.out.println("Catch!");
    }
}
