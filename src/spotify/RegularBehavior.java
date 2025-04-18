package spotify;

public class RegularBehavior implements UserBehavior {

    private int playingLimit = 5;

    @Override
    void createPlaylist (String Title, User Owner){
        throw new InvalidOperationException("Regular users cannot create playlists");
    }

    @Override
    void playMusic (Music music){

    }

    @Override
    void buyPremium (User owner, int month){

    }



}
