package model;

import java.time.LocalDateTime;

public class Message extends Model {
    private String text;
    private ID image;
    private LocalDateTime createTime;
    /* isForwarded and isEditable are the same*/
    private boolean isForwarded;
    private boolean isFromTweet;
    private ID writerID;
    private boolean isDeleted;

    public Message(ID id, String text, ID image, LocalDateTime createTime, boolean isForwarded, boolean isFromTweet, ID writerID) {
        super(id);
        this.text = text;
        this.image = image;
        this.createTime = createTime;
        this.isForwarded = isForwarded;
        this.isFromTweet = isFromTweet;
        this.writerID = writerID;

        this.isDeleted = false;
    }
}
