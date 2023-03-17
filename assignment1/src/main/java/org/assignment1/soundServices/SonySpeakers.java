package org.assignment1.soundServices;

import org.assignment1.Interface.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeakers implements Speakers {
    @Override
    public void makeSound() {
        System.out.println("Sony speakers make sound");
    }
}
