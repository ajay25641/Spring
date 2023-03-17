package org.assignment1.tyreServices;

import org.assignment1.Interface.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MichelinTyres implements Tyres {
    @Override
    public void rotate() {
        System.out.println("Michelin tyres rotate");
    }
}
