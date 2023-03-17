package org.example.services;

import org.example.Interface.LogAspect;
import org.example.Interface.Speakers;
import org.example.Interface.Tyres;
import org.example.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class VehicleServices {

    @Autowired
    private Speakers speakers;
    @Autowired
    private Tyres tyres;

    //private Logger logger= Logger.getLogger(VehicleServices.class.getName());
    @LogAspect
    public String makeSound(boolean vehicleStarted, Song song){
        /*Instant start=Instant.now();
        logger.info("method execution start");

        String music=null;
        if(vehicleStarted){
            music=speakers.makeSound(song);
        }
        else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the operation");
        }

        logger.info("method execution end");

        Instant end=Instant.now();
        long duration = Duration.between(start,end).toMillis();

        logger.info("time took to execute the method "+duration);*/

        return speakers.makeSound(song);
    }
    public String rotate(boolean vehicleStarted){
        /*Instant start=Instant.now();
        logger.info("method execution start");
        String status=null;
        if(vehicleStarted){
            status=tyres.rotate();
        }
        else{
            logger.log(Level.SEVERE,"vehicle not started to perform the operation");
        }

        logger.info("method execution end");

        Instant end=Instant.now();

        long duration=Duration.between(start,end).toMillis();
        logger.info("time taken to execute the method "+duration);
        return status;*/

        /*throw new NullPointerException("Dam ! Null pointer exception occured !!");*/

        return tyres.rotate();
    }
    public String applyBreaks(boolean vehicleStarted){
        return tyres.stop();
    }
}
