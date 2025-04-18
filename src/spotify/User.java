package spotify;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private static ArrayList<User> allUsers;

    public User(String username, String password){

        if(usernameExists(username)){
            throw new InvalidOperationException("Username already exists");
        }
        if (password.length() < 8) {
            throw new InvalidOperationException("Password must be at least 8 characters");
        }

        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    private boolean usernameExists(String username) {
        return allUsers.stream().anyMatch(u -> u.getUsername().equals(username));
    }



}
