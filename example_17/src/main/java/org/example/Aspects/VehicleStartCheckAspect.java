package org.example.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.services.VehicleServices;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class VehicleStartCheckAspect {
    private Logger logger=Logger.getLogger(VehicleServices.class.getName());

    @Before("execution(* org.example.services.*.*(..)) && args(vehicleStarted,..)")
    public void log(JoinPoint joinPoint,boolean vehicleStarted) throws Throwable {
        if(!vehicleStarted){
            throw new RuntimeException("Vehicle not started yet");
        }
    }
}
