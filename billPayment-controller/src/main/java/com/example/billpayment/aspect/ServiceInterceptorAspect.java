package com.example.billpayment.aspect;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class ServiceInterceptorAspect {

    private static final Logger  LOGGER= LoggerFactory.getLogger(ServiceInterceptorAspect.class);
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void allServiceMethod(){
    }

//    @Before("allServiceMethod()")
//    public void beforeServiceMethod(JoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//        String methodName = joinPoint.getSignature().getName();
//        LOGGER.info("before service method name : {}",methodName);
//        LOGGER.info("service data start : {}",args[0]);
//    }

//    @AfterReturning(value = "allServiceMethod()" , returning = "result")
//    public void afterServiceMethod(JoinPoint joinPoint, Object result){
//        String methodName = joinPoint.getSignature().getName();
//        LOGGER.info("after service method name : {}",methodName);
//        LOGGER.info("service data end : {}",result);
//    }
}
