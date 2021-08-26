package model;

public class ChatLink extends Model {
    private ID linkedChat;
    private ID lastSeenMessage;

    public ChatLink(ID id, ID linkedChat) {
        super(id);
        this.linkedChat = linkedChat;

        this.lastSeenMessage = null;
    }
}
