package org.example.Implementation;

import org.example.Interface.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BridgeStoneTyres implements Tyres {

    @Override
    public String rotate() {
        return "Vehicle moves with the help of bridgeStones tyres";
    }

    @Override
    public String stop() {
        return "Vehicle stopped with the help of bridgeStones tyres";
    }

}
