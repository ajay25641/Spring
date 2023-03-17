package com.eazybytes.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class Person {
    private String name="lucy";

   //@Autowired
    private final Vehicle vehicle;
    @Autowired
    public Person(@Qualifier("vehicle2") Vehicle vehicle){
        System.out.println("Person bean created by spring");
        this.vehicle=vehicle;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    /*@Autowired
    public void setVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
    }*/

    public Vehicle getVehicle(){
        return vehicle;
    }


}
