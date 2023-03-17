package org.assignment1.Main;

import org.assignment1.beans.Person;
import org.assignment1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
      var context=new AnnotationConfigApplicationContext(ProjectConfig.class);
      Person person=context.getBean(Person.class);
      person.setName("lucy");
      System.out.println("name of the person is "+person.getName());
      System.out.println("vehicle owned by person is "+person.getVehicle());

      person.getVehicle().getVehicleServices().makeSound();
      person.getVehicle().getVehicleServices().rotate();
        //System.out.println("vehicle owned by person is "+person.getVehicle());

    }
}
