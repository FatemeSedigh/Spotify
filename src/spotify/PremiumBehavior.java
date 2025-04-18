package spotify;

public class PremiumBehavior implements UserBehavior {

    private int month;

    public PremiumBehavior(int month){
        this.month = month;
    }

    @Override
    void createPlaylist (String Title, User Owner){

    }

    @Override
    void playMusic (Music music){

    }

    @Override
    void buyPremium (User owner, int month){

    }


}
