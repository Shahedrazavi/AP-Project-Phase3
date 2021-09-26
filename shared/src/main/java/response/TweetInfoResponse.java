package response;

public class TweetInfoResponse extends Response{
    private Object source;
    private String retweeter;
    private String profileName;
    private String username;
    private String replyingTo;

    public TweetInfoResponse(Object source,String retweeter, String profileName, String username, String replyingTo) {
        this.source = source;
        this.retweeter = retweeter;
        this.profileName = profileName;
        this.username = username;
        this.replyingTo = replyingTo;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.receiveTweetInfo(this);
    }

    public Object getSource() {
        return source;
    }

    public String getRetweeter() {
        return retweeter;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getUsername() {
        return username;
    }

    public String getReplyingTo() {
        return replyingTo;
    }
}
