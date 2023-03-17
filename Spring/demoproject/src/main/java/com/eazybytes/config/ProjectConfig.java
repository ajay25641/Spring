/*
package com.eazybytes.config;

import com.eazybytes.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.beans.BeanProperty;

@Configuration
public class ProjectConfig {
    @Bean
    Vehicle vehicle1(){
        var veh=new Vehicle();
        veh.setName("Audi 8");
        //ystem.out.println(veh.getName());
        return veh;
    }
    @Bean("bmw")
    Vehicle vehicle2(){
        var veh=new Vehicle();
        veh.setName("BMW");
        //System.out.println(veh.getName());
        return veh;
    }
    @Primary
    @Bean
    Vehicle vehicle23(){
        var veh=new Vehicle();
        veh.setName("ferrari");
        return veh;
    }
    @Bean
    String getString(){
        return "Hello world";
    }

    @Bean
    Integer getNumber(){
        return 16;
    }
}
*/

package com.eazybytes.config;

import com.eazybytes.beans.Person;
import com.eazybytes.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.beans.BeanProperty;

@Configuration
@ComponentScan(basePackages = "com.eazybytes.beans")
public class ProjectConfig {

    /*@Bean
    public Vehicle vehicle(){
        Vehicle veh=new Vehicle();
        veh.setName("audi");
        return veh;
    }

    *//*@Bean
    public Person person(){
        Person p=new Person();
        p.setName("Lucy");
        p.setVehicle(vehicle());
        return p;
    }
*//*
    @Bean
    Person person(Vehicle vehicle){
        Person p=new Person();
        p.setName("Lucy");
        p.setVehicle(vehicle);
        return p;
    }*/

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
    @Primary
    Vehicle vehicle3(){
        Vehicle veh3=new Vehicle();
        veh3.setName("Honda");
        return veh3;
    }

}