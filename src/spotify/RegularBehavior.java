package spotify;

public class RegularBehavior implements UserBehavior {

    private int playingLimit = 5;

    @Override
    void createPlaylist (String Title, User Owner){
        throw new InvalidOperationException("Regular users cannot create playlists");
    }

    @Override
    void playMusic (Music music){
        if(playingLimit > 0) {
            music.play();
            playingLimit --;
        } else {
            throw new InvalidOperationException ("Regular users can only play 5 songs per session");
        }
    }

    @Override
    void buyPremium (User owner, int month){
        owner.setBehavior(new PremiumBehavior(month));
    }
}
