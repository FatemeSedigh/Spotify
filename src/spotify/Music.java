package spotify;

import java.util.ArrayList;

public class Music {

    private String title;
    private User singer;
    private int numberOfStream;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer){
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }

    public void play(){
        System.out.println("Now playing: \" + title + \" by \" + singer.getUsername()");
        numberOfStream += 1;
    }



}
