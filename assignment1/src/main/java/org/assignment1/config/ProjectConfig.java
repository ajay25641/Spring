package org.assignment1.config;


import org.assignment1.Interface.Speakers;
import org.assignment1.Interface.Tyres;
import org.assignment1.beans.Person;
import org.assignment1.beans.Vehicle;
import org.assignment1.beans.VehicleServices;
import org.assignment1.soundServices.BoseSpeakers;
import org.assignment1.soundServices.SonySpeakers;
import org.assignment1.tyreServices.BridgeStoneTyres;
import org.assignment1.tyreServices.MichelinTyres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages ={"org.assignment1.beans","org.assignment1.soundServices","org.assignment1.tyreServices"})
public class ProjectConfig {

   /* @Bean
    @Primary
    Speakers sonySpeakers(){
        Speakers speaker=new SonySpeakers();
        return speaker;
    }

    @Bean
    Speakers boseSpeakers(){
        Speakers speaker=new BoseSpeakers();
        return speaker;
    }
    @Bean
    Vehicle vehicle1(){
        Vehicle veh1=new Vehicle();
        veh1.setName("audi");
        return veh1;
    }

    @Bean
    Vehicle vehicle2(){
        Vehicle veh2=new Vehicle();
        veh2.setName("ferrari");
        return veh2;
    }

    @Bean
    Vehicle vehicle3(){
        Vehicle veh3=new Vehicle();
        veh3.setName("Honda");
        return veh3;
    }

    @Bean
    VehicleServices vehicleServices(){
        VehicleServices services=new VehicleServices();
        return services;
    }

    @Bean
    Tyres michelinTyres(){
        return new MichelinTyres();
    }

    @Bean
    @Primary
    Tyres bridgeStoneTyres(){
        return new BridgeStoneTyres();
    }

    @Bean
    Person person(){
        Person person=new Person();
        person.setName("lucy");
        return person;
    }*/

}

