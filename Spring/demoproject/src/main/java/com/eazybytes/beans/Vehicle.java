package com.eazybytes.beans;

import org.springframework.stereotype.Component;

import java.util.Random;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//@Component
public class Vehicle {
    private String name="audi";
    private int num=10;
    public Vehicle(){
       // System.out.println("Vehicle bean created by spring");
    }
    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void printHello(){
        System.out.println("print from spring context "+name);
    }


    public String toString(){
        return name;
    }



}
