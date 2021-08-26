package model;

import java.util.LinkedList;

public class GroupChat extends Chat{

    public GroupChat(ID id, LinkedList<ID> members, LinkedList<ID> chatLinks, ChatType chatType) {
        super(id, members, chatLinks, chatType);
    }
}
