package com.eazybytes.main;

import com.eazybytes.beans.Person;
import com.eazybytes.beans.Vehicle;
import com.eazybytes.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
       /* Vehicle veh=new Vehicle();
        veh.setName("Honda city");
        //System.out.println("vehicle name without spring context "+veh.getName());

        var context =new AnnotationConfigApplicationContext(ProjectConfig.class);

       *//* Vehicle veh1=context.getBean("vehicle1",Vehicle.class);
        System.out.println("vehicle name from spring context " +veh1.getName());

        Vehicle veh2=context.getBean("bmw",Vehicle.class);
        System.out.println("vehicle2 "+ veh2.getName());
       // Vehicle veh=context.getBean("vehicle3",Vehicle.class);

        Vehicle veh3 =context.getBean(Vehicle.class);
        //@Primary
        System.out.println("ferrari method "+veh3.getName());
        *//**//*String hello=context.getBean(String.class);
        System.out.println(hello);

        Integer num=context.getBean(Integer.class);

        System.out.println(num);*//*

        //var context=new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh1=context.getBean("vehicle1",Vehicle.class);
        System.out.println(veh1.getName());

        veh1.printHello();
*/
        /*var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Random random=new Random();
        int num = random.nextInt(10);
        System.out.println("random number is "+num);
        *//*Supplier<Vehicle> audiSupplier=()->{
            Vehicle veh=new Vehicle();
            veh.setName("audi");
            return veh;
        };*//*
        Supplier<Vehicle> volsSupplier=()->{
            Vehicle veh =new Vehicle();
            veh.setName("vols");
            return veh;
        };

        if(num%2==0){
            context.registerBean("vols",Vehicle.class,volsSupplier);
        }
        else{
            context.registerBean("audi",Vehicle.class,()->{
                Vehicle veh=new Vehicle();
                veh.setName("audi");
                return veh;
            });
        }

        Vehicle volswagen=null;
        Vehicle audiVehicle=null;
        try{
            audiVehicle=context.getBean("audi",Vehicle.class);
        }
        catch (NoSuchBeanDefinitionException no){
            System.out.println("No bean found for audi");
        }

        try{
            volswagen=context.getBean("vols",Vehicle.class);
        }
        catch (NoSuchBeanDefinitionException no){
            System.out.println("No bean found for vols");
        }

        if(volswagen!=null){
            System.out.println(volswagen.getName());
        }
        else{
            System.out.println(audiVehicle.getName());
        }*/


        var context=new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person=context.getBean(Person.class);
        Vehicle vehicle=context.getBean(Vehicle.class);

        //System.out.println("person name from spring context "+person.getName());
        //System.out.println("Vehicle name from spring context "+vehicle.getName());

        //System.out.println("vehicle that person owns "+person.getVehicle());

    }
}
