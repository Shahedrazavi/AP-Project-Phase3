package model;

import java.util.LinkedList;

public class PVChat extends Chat{

    public PVChat(ID id, LinkedList<ID> members, LinkedList<ID> chatLinks, ChatType chatType) {
        super(id, members, chatLinks, chatType);
    }
}
