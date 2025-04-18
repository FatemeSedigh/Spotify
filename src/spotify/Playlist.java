package spotify;

import java.util.ArrayList;

public class Playlist {

    private String title;
    private ArrayList<Music> playlist = new ArrayList<>();
    private User owner;

    public Playlist(String title, User owner){
        this.title = title;
        this.owner = owner;
    }

}
