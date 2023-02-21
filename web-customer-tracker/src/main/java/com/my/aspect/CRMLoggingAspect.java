package com.my.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.my.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.my.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.my.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("forDaoPackage() || forServicePackage() || forControllerPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        logger.info("=====> in @Before: calling method: " + joinPoint.getSignature().toShortString());

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            logger.info("=====> argument: " + arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "res")
    public void afterReturning(JoinPoint joinPoint, Object res){
        logger.info("=====> in @AfterReturning: calling method: " + joinPoint.getSignature().toShortString());
        logger.info("=====> result: " + res);
    }
}
