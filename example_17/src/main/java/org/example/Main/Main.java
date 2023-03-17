package org.example.Main;

import org.example.config.ProjectConfig;
import org.example.model.Song;
import org.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
       var context=new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleServices = context.getBean(VehicleServices.class);
        System.out.println(vehicleServices.getClass());

        Song song=new Song();
        song.setTitle("Blank spaces");
        song.setSingerName("Taylor swift");

        boolean vehicleStarted=true;

        String moveVehicleStatus =  vehicleServices.rotate(vehicleStarted);
        String playVehicleStatus =  vehicleServices.makeSound(vehicleStarted,song);
       /* String applyBreakStatus = vehicleServices.applyBreaks(vehicleStarted);

        System.out.println(playVehicleStatus);
        System.out.println(moveVehicleStatus);
        System.out.println(applyBreakStatus);*/
    }
}
