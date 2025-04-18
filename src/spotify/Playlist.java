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

    public void editTitle(String newtitle, String password){
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password");
        }
        this.title = newtitle;
    }

    public void addMusic(Music music, String password){
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password");
        }
        if(playlist.contains(music)){
            throw new InvalidOperationException("Music already exists in playlist");
        }
        playlist.add(music);
    }

    public void removeMusic(Music music, String password){
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("Invalid password");
        }
        if(!playlist.contains(music)){
            throw new InvalidOperationException("Music not found in playlist");
        }
        playlist.remove(music);
    }



}
