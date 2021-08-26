package model;

import java.util.LinkedList;

public class Chat extends Model{
    private LinkedList<ID> messages;
    private LinkedList<ID> members;
    private LinkedList<ID> chatLinks;
    private ChatType chatType;
    private ID lastSeenMessage;

    enum ChatType{
        Private,
        Group
    }

    public Chat(ID id, LinkedList<ID> members, LinkedList<ID> chatLinks, ChatType chatType) {
        super(id);
        this.members = members;
        this.chatLinks = chatLinks;
        this.chatType = chatType;

        this.messages = new LinkedList<>();
        this.lastSeenMessage = null;
    }
}
