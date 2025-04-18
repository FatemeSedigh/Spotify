package spotify;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Playlist {

    private String title;
    private ArrayList<Music> playlist = new ArrayList<>();
    private User owner;

    public String getTitle(){
        return title;
    }
    public List<Music> getPlaylist(){
        return playlist;
    }
    public User getOwner(){
        return owner;
    }

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

    public List<Music> searchInPlaylist(String title){
        List<Music> result = new ArrayList<>();
        for (Music music : playlist) {
            if (music.getTitle().equals(title)) {
                result.add(music);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public Music playPlaylist(String title, User singer){
        for (Music music : playlist) {
            if (music.getTitle().equals(title) && music.getSinger().equals(singer)) {
                return music;
            }
        }
        return null;
    }

    public void playPlaylist() {
        for (Music music : playlist) {
            music.play();
        }
    }

    public void shufflePlaylist() {
        List<Music> shuffled = new ArrayList<>(playlist);
        Random rand = new Random();

        for (int i = shuffled.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Music temp = shuffled.get(i);
            shuffled.set(i, shuffled.get(j));
            shuffled.set(j, temp);
        }

        for (Music music : shuffled) {
            music.play();
        }
    }
}