import spotify.*;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("user1", "password123");
            User user2 = new User("user2", "password123");
            User artist = new User("artist", "password123");

            user1.follow(user2);
            user2.follow(user1);
            user1.follow(artist);

            // Create music
            Music song1 = new Music("Song1", artist);
            Music song2 = new Music("Song2", artist);

            // User1 plays music
            user1.playMusic(song1);
            user1.playMusic(song2);

            // User1 buys premium
            user1.buyPremium(1);

            // Create playlist
            user1.createPlaylist("My Playlist");
            Playlist playlist = user1.getPlaylists().get(0);
            playlist.addMusic(song1, "password123");
            playlist.addMusic(song2, "password123");

            // Play playlist
            playlist.playPlaylist();

        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}