package org.example.Implementation;

import org.example.Interface.Speakers;
import org.example.model.Song;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeakers implements Speakers {
    @Override
    public String makeSound(Song song) {
        return "playing the song "+song.getTitle()+" by "+song.getSingerName()+" with sony speakers";
    }
}
