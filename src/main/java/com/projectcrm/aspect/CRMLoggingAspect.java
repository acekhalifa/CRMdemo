package com.projectcrm.aspect;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());
    
    @Pointcut("execution(* com.projectcrm.controller.*.*(..))")
    private void forControllerPackage(){}
    
    @Pointcut("execution(* com.projectcrm.dao.*.*(..))")
    private void forDaoPackage(){}
    
    @Pointcut("execution(* com.projectcrm.service.*.*(..))")
    private void forServicePackage(){}
    
    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void appFlow(){}
    
    @Before("appFlow()")
    public void CRMBeforeAdvice(JoinPoint joinPoint){
        myLogger.log(Level.INFO, "====> In @Before. Executing method: {0}", joinPoint.toShortString());
        var args = joinPoint.getArgs();
        for (var arg : args) {
            myLogger.log(Level.INFO, "====> argument: {0}", arg);
        }  
    }
    
    @AfterReturning(pointcut = "appFlow()", returning = "result")
    public void CRMAfterReturningAdvice(JoinPoint joinPoint, Object result){
        myLogger.log(Level.INFO, "====> In @AfterReturning. Executing method: {0}", joinPoint.toShortString());
        myLogger.log(Level.INFO, "====> result: {0}", result);
    }
    
}
