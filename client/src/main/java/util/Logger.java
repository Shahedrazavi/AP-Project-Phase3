package util;

import config.Config;

import java.io.*;
import java.time.LocalDateTime;

public class Logger {
    static Logger logger;
    private static Config config = Config.getConfig("logger");

    static String path = config.getProperty("file");

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    private Logger() {
//        try {
//            fileOutputStream = new FileOutputStream(path, true);
//            printStream = new PrintStream(fileOutputStream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public void log(String log) {
        File file = new File(path);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream stream = new FileOutputStream(file,true);
            PrintStream printStream = new PrintStream(stream);
            printStream.println(LocalDateTime.now() + ": " + log);
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        log("NOTICE level: Application Started.");
    }

    public void exit(){
        log("NOTICE level: Application exited.");
    }

    public void dbError(String db){
        log("FATAL level: Can't find \"" + db +"\" file.");
    }

    public void dbMakeFile(String db){
        log("WARN level : Made \""+ db +"\" file.");
    }

    public void signIn(String username, String userID) {
        log("NOTICE level: User with username: \"" + username + "\" and ID: \"" + userID + "\" logged in.");
    }

    public void signUp(String username, String userID) {
        log("NOTICE level: User with username: \"" + username + "\" and ID: \"" + userID + "\" created a new account.");
    }

    public void logOut(String username, String userID) {
        log("NOTICE level: User with username: \"" + username + "\" and ID: \"" + userID + "\" logged out.");
    }

    public void delete(String username, String userID) {
        log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" deleted account.");
    }

    public void passwordChange(String username, String userID) {
        log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" changed password.");
    }

    public void privacy(String username, String userID, boolean isPublic ){
        if (isPublic){
            log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" changed the account privacy to public.");
        }
        else {
            log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" changed the account privacy to private.");
        }
    }

    public void lastSeenType(String username, String userID, String lastSeen){
        log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" changed lastSeen & online type to " + lastSeen  + ".");
    }

    public void activation(String username, String userID, boolean isActive){
        if (isActive){
            log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" activated account.");
        }
        else {
            log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" deactivated account.");
        }
    }

    public void changeProfileName(String username, String userID){
        log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" changed profile name.");
    }

    public void changeBio(String username, String userID){
        log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" changed bio.");
    }

    public void newTweet(String username, String userID, String tweetID){
        log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" made a new tweet with ID: \"" + tweetID + "\".");

    }

    public void follow(String username1, String userID1 , String username2, String userID2){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" followed user with username: \"" + username2 + "\" and ID: \"" + userID2 +"\".");
    }

    public void unfollow(String username1, String userID1 , String username2, String userID2){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" unfollowed user with username: \"" + username2 + "\" and ID: \"" + userID2 +"\".");
    }

    public void block(String username1, String userID1 , String username2, String userID2){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" blocked user with username: \"" + username2 + "\" and ID: \"" + userID2 +"\".");
    }

    public void unblock(String username1, String userID1 , String username2, String userID2){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" unblocked user with username: \"" + username2 + "\" and ID: \"" + userID2 +"\".");
    }

    public void mute(String username1, String userID1 , String username2, String userID2){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" muted user with username: \"" + username2 + "\" and ID: \"" + userID2 +"\".");
    }

    public void unmute(String username1, String userID1 , String username2, String userID2){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" unmuted user with username: \"" + username2 + "\" and ID: \"" + userID2 +"\".");
    }

    public void addToGroup(String username1, String userID1 , String groupName, String groupID){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" is added to the group with name: \"" + groupName + "\" and ID: \"" + groupID +"\".");
    }

    public void removeFromGroup(String username1, String userID1 , String groupName, String groupID){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" is removed from the group with name: \"" + groupName + "\" and ID: \"" + groupID +"\".");
    }

    public void newGroup(String username1, String userID1 , String groupName, String groupID){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" created a new group with name: \"" + groupName + "\" and ID: \"" + groupID +"\".");
    }

    public void request(String username1, String userID1 , String username2, String userID2){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" requested from user with username: \"" + username2 + "\" and ID: \"" + userID2 +"\".");
    }

    public void accept(String username1, String userID1 , String username2, String userID2){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" accepted user with username: \"" + username2 + "\" and ID: \"" + userID2 +"\".");
    }

    public void reject(String username1, String userID1 , String username2, String userID2){
        log("INFO level: User with username: \"" + username1 + "\" and ID: \"" + userID1 + "\" rejected user with username: \"" + username2 + "\" and ID: \"" + userID2 +"\".");
    }

    public void newMemo(String username, String userID){
        log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" made a new Memo.");
    }

    public void newChatroom(String chatRoomID ,String user1ID, String user2ID){
        log("INFO level: New Chatroom with ID \""+chatRoomID+"\" created for users with ID: \"" + user1ID + "\" and ID: \"" + user2ID + "\".");
    }

    public void newChatMsg(String chatRoomID , int userNumber){
        log("INFO level: New Message sent by user number  \""+userNumber+"\" in the chatroom with ID: \"" + chatRoomID + "\".");
    }

    public void notifRemove(String username , String userID){
        log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" deleted a notification.");
    }

    public void like(String username , String userID , String tweetID , boolean liked){
        if (liked){
            log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" liked tweet with ID: \"" + tweetID +"\".");
        }
        else {
            log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" removed the like for tweet with ID: \"" + tweetID +"\".");
        }
    }

    public void retweet(String username , String userID , String tweetID , String retweetID){
        log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" retweeted tweet with ID: \"" + tweetID +"\".(Retweet ID is: \""+ retweetID + "\")");
    }

    public void reportTweet(String username , String userID , String tweetID){
        log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" reported tweet with ID: \"" + tweetID +"\".");
    }

    public void comment(String username , String userID , String tweetID , String commentID){
        log("INFO level: User with username: \"" + username + "\" and ID: \"" + userID + "\" retweeted tweet with ID: \"" + tweetID +"\".(Comment ID is: \""+ commentID + "\")");
    }

    public void serverDown(){
        log("FATAL level: server is down.");
    }

}