package org.example.Implementation;

import org.example.Interface.Speakers;
import org.example.Interface.Tyres;
import org.springframework.stereotype.Component;

@Component
public class MichelinTyres implements Tyres {


    @Override
    public String rotate() {
        return "Vehicle move with the help of machelin tyres";
    }

    @Override
    public String stop() {
        return "Vehicle stopped with the help of machelin tyres";
    }
}
