package org.example.Implementation;

import org.example.Interface.Speakers;
import org.example.model.Song;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {
    @Override
    public String makeSound(Song song) {
        return "playing the song "+song.getTitle()+" by "+song.getSingerName()+" with Bose speakers";
    }
}
