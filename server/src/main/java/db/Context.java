package db;

import model.Tweet;
import model.User;

public class Context {
    public DBSet<User> users = new UserDB();
    public DBSet<Tweet> tweets = new TweetDB();
}
