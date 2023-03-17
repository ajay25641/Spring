package org.assignment1.soundServices;

import org.assignment1.Interface.Speakers;
import org.springframework.stereotype.Component;



@Component
public class BoseSpeakers implements Speakers {

    @Override
    public void makeSound() {
        System.out.println("Bose speakers make sound");
    }
}
