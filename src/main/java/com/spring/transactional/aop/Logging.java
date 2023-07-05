//package com.spring.transactional.aop;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class Logging {
//
//    @Pointcut("execution(* com..service.*.*(..)) || within(com..controller.*)")
//    public void logMethodPointCut(){
//
//    }
//
//    @Before("logMethodPointCut()")
//    public void LogBeforeMethodCall(){
//        System.out.println("Method is starting...");
//    }
//
//    @Around("logMethodPointCut()")
//    public void LogMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        // Before
//        try{
//        proceedingJoinPoint.proceed();
//        }
//        catch (Exception e){
//            //After Throwing
//        }
//        // After
//    }
//}
