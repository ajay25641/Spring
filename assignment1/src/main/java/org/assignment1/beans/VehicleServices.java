package org.assignment1.beans;

import org.assignment1.Interface.Speakers;
import org.assignment1.Interface.Tyres;
import org.assignment1.soundServices.SonySpeakers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {


    @Autowired
    private Speakers speaker;
    private Tyres tyre;

    /*@Autowired
    public VehicleServices(@Qualifier("sonySpeakers") Speakers speaker , @Qualifier("michelinTyres") Tyres tyre){
        this.speaker=speaker;
        this.tyre=tyre;
    }*/
    @Autowired
    public void setTyre(Tyres tyre){
        this.tyre=tyre;
    }
    public void setSpeaker(Speakers speaker){
        this.speaker=speaker;
    }
    public void makeSound(){
        speaker.makeSound();
    }
    public void rotate(){
        tyre.rotate();
    }
}
