package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class User extends Model {
    private String username;
    private String password;
    private String profileName;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate birthday;
    private String bio;
    private ID avatar;

    private LocalDateTime lastSeen;

    private boolean isBirthdaySet;

    private boolean isActive;
    private boolean isPublic;
    private LastSeenType lastSeenType;

    private LinkedList<ID> following;
    private LinkedList<ID> followers;
    private LinkedList<ID> blockedUsers;
    private LinkedList<ID> mutedUsers;
    private LinkedList<ID> requested;
    private LinkedList<ID> requesters;


    private LinkedList<ID> tweets;
    private LinkedList<ID> likedTweets;

    private LinkedList<ID> chatLinks;
    private LinkedList<ID> notifs;


    public enum LastSeenType{
        everyone,
        followings,
        no_one
    }

    public User(ID ID, String username, String password,
                String profileName, String firstName, String lastName,
                String email, String phoneNumber, LocalDate birthday) {
        super(ID);
        this.username = username;
        this.password = password;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.avatar = null;

        this.isBirthdaySet = true;

        this.bio = "";
        this.lastSeen = LocalDateTime.now();

        this.isActive = true;
        this.isPublic = true;

        this.following = new LinkedList<>();
        this.followers = new LinkedList<>();
        this.blockedUsers = new LinkedList<>();
        this.mutedUsers = new LinkedList<>();
        this.requested = new LinkedList<>();
        this.requesters = new LinkedList<>();

        this.lastSeenType = LastSeenType.everyone;

        this.tweets = new LinkedList<>();
        this.likedTweets = new LinkedList<>();

        this.chatLinks = new LinkedList<>();
        this.notifs = new LinkedList<>();
    }

    public User(ID ID, String username, String password,
                String profileName, String firstName, String lastName,
                String email, String phoneNumber) {
        super(ID);
        this.username = username;
        this.password = password;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = null;
        this.avatar = null;

        this.isBirthdaySet = false;

        this.bio = "";
        this.lastSeen = LocalDateTime.now();

        this.isActive = true;
        this.isPublic = true;

        this.following = new LinkedList<>();
        this.followers = new LinkedList<>();
        this.blockedUsers = new LinkedList<>();
        this.mutedUsers = new LinkedList<>();
        this.requested = new LinkedList<>();
        this.requesters = new LinkedList<>();

        this.lastSeenType = LastSeenType.everyone;

        this.tweets = new LinkedList<>();
        this.likedTweets = new LinkedList<>();

        this.chatLinks = new LinkedList<>();
        this.notifs = new LinkedList<>();
    }

    public LinkedList<ID> getFollowing() {
        return following;
    }

    public LinkedList<ID> getFollowers() {
        return followers;
    }

    public LinkedList<ID> getBlockedUsers() {
        return blockedUsers;
    }

    public LinkedList<ID> getMutedUsers() {
        return mutedUsers;
    }

    public LinkedList<ID> getRequested() {
        return requested;
    }

    public LinkedList<ID> getRequesters() {
        return requesters;
    }

    public LinkedList<ID> getLikedTweets() {
        return likedTweets;
    }

    public ID getAvatar() {
        return avatar;
    }

    public boolean isBirthdaySet() {
        return isBirthdaySet;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public LastSeenType getLastSeenType() {
        return lastSeenType;
    }

    public LinkedList<ID> getTweets() {
        return tweets;
    }

    public LinkedList<ID> getChatLinks() {
        return chatLinks;
    }

    public LinkedList<ID> getNotifs() {
        return notifs;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getBio() {
        return bio;
    }

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public void setLastSeenType(LastSeenType lastSeenType) {
        this.lastSeenType = lastSeenType;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
