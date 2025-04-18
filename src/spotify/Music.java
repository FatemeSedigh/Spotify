package spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {

    private String title;
    private User singer;
    private int numberOfStream;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    public String getTitle(){
        return title;
    }
    public User getSinger(){
        return singer;
    }
    public int getNumberOfStream(){
        return numberOfStream;
    }
    public static List<Music> getAllMusics(){
        return allMusics;
    }

    public Music(String title, User singer){
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }

    public void play(){
        System.out.println("Now playing: \" + title + \" by \" + singer.getUsername()");
        numberOfStream += 1;
    }

    public static List<Music> search(String title){
        List<Music> result = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.title.equals(title)) {
                result.add(music);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public static List<Music> search(String title, String singer){
        for (Music music : allMusics) {
            if (music.title.equals(title) && music.singer.equals(singer)) {
                return music;
            }
        }
        return null;
    }
}
