package spotify;

public class RegularBehavior implements UserBehavior {

    private int playingLimit = 5;

    @Override
    public void createPlaylist (String Title, User Owner){
        throw new InvalidOperationException("Regular users cannot create playlists");
    }

    @Override
    public void playMusic (Music music){
        if(playingLimit > 0) {
            music.play();
            playingLimit --;
        } else {
            throw new InvalidOperationException ("Regular users can only play 5 songs per session");
        }
    }

    @Override
    public void buyPremium (User owner, int month){
        owner.setBehavior(new PremiumBehavior(month));
    }
}
