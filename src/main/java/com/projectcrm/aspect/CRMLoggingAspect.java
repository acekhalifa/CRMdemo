package com.projectcrm.aspect;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
    @Pointcut("execution(* com.projectcrm.controller.*.*(..))")
    private void forControllerPackage(){}
    
    @Pointcut("execution(* com.projectcrm.dao.*.*(..))")
    private void forDaoPackage(){}
    
    @Pointcut("execution(* com.projectcrm.service.*.*(..))")
    private void forServicePackage(){}
    
    @Pointcut("forControllerPackage || forDaoPackage || forServicePackage")
    private void appFlow(){}
    
    @Before("appflow()")
    public void CRMBeforeAdvice(JoinPoint joinPoint){
        System.out.println("");
    }
    
}
