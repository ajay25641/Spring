package org.assignment1.tyreServices;

import org.assignment1.Interface.Tyres;
import org.springframework.stereotype.Component;

@Component
public class BridgeStoneTyres implements Tyres {
    @Override
    public void rotate() {
        System.out.println("BridgeStones tyres rotate");
    }
}
