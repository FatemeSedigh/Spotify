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

}
