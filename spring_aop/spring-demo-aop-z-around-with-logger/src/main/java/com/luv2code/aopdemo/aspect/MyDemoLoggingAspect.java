package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
    
    private static Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n======>>> Executing @Around on method: " + method);
        
        long begin = System.currentTimeMillis();
        
        Object result = theProceedingJoinPoint.proceed();
        
        long end = System.currentTimeMillis();
        
        long duration = end - begin;
        myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
        return result;
    
    }
    
    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(
            JoinPoint theJoinPoint) {
        
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n======>>> Executing @After (finally) on method: " + method);
    
    }
    
    @AfterThrowing(
            pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing="theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc) {
        
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n======>>> Executing @AfterThrowing on method: " + method);
    
        myLogger.info("\n======>>> The exception is: " + theExc);

    }
    
    
    @AfterReturning(
            pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning="result"
            )
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result) {
        
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n======>>> Executing @AfterReturning on method: " + method);
    
        myLogger.info("\n======>>> result is: " + result);
        
        result.stream().forEach(account -> {
            account.setName(account.getName().toUpperCase());
        });
    }

    // @Before advice
//    @Before("execution(public void add*())")
//    @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
//    @Before("execution(* add*(com.luv2code.aopdemo.Account, *))")
//    @Before("execution(* add*(..))")
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n=====>>> Executing @Before advice on method");

        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method: " + methodSig);

        Object[] args = theJoinPoint.getArgs();
        
        for (Object tempArg : args) {
            
            myLogger.info(tempArg.toString());
            
            if (tempArg instanceof Account) {
                
                Account theAccount = (Account) tempArg;
                myLogger.info("Account name: " + theAccount.getName());
                myLogger.info("Account level: " + theAccount.getLevel());

            }
        }

    }

}
