package org.example.Aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.services.VehicleServices;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {
    private Logger logger=Logger.getLogger(VehicleServices.class.getName());
    @Around("execution(* org.example.servicesjh.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info(joinPoint.getSignature().toString()+" method execution start");
        Instant start=Instant.now();

        joinPoint.proceed();
        Instant end=Instant.now();
        long duration = Duration.between(start,end).toMillis();
        logger.info("time taken to execute the method "+duration);
        logger.info(joinPoint.getSignature().toString()+" method execution end");
    }

    @Around("@annotation(org.example.Interface.LogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info(joinPoint.getSignature().toString()+" method execution start");
        Instant start=Instant.now();

        joinPoint.proceed();
        Instant end=Instant.now();
        long duration = Duration.between(start,end).toMillis();
        logger.info("time taken to execute the method "+duration);
        logger.info(joinPoint.getSignature().toString()+" method execution end");
    }
    @AfterThrowing(value="execution(* org.example.services.*.*(..))",throwing = "ex")
    public void logException(JoinPoint joinPoint,Exception ex){
        logger.log(Level.SEVERE,joinPoint.getSignature()+" an exception thrown with the help of @afterthrowing which happened due to : "+ex.getMessage());
    }

    @AfterReturning(value="execution(* org.example.services.*.*(..))",returning = "retVal")
    public void logStatus(JoinPoint joinPoint,Object retVal){
        logger.log(Level.INFO,joinPoint.getSignature()+" method successfully processed with the status "+retVal.toString());
    }
}
