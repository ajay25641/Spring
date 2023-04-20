package org.example.eazyschool.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Around("execution(* org.example.eazyschool..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info(joinPoint.getSignature().toString()+" method execution start");
        Instant start= Instant.now();
        Object returnObj=joinPoint.proceed();
        Instant finish=Instant.now();
        long timeElapsed= Duration.between(start,finish).toMillis();
        log.info("time took to execute "+joinPoint.getSignature().toString()+" method is : "+timeElapsed);
        log.info(joinPoint.getSignature().toString()+" method execution end");
        return returnObj;
    }

    /*@AfterThrowing(value="execution(* org.example.eazyschool..*.*(..))",throwing = "ex")
    public void logException(JoinPoint joinPoint,Exception ex){
        log.error(joinPoint.getSignature()+" An exception happend due to :"+ex.getMessage());
    }*/
}
