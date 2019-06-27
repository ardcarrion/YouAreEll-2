package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.Id;
import models.Message;

public class MessageController {

    private HashSet<Message> messagesSeen;
    // why a HashSet??

    public ArrayList<Message> getMessages() {
        TransactionController tc = new TransactionController();
        try {
            tc.getResponse("/messages");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(tc.getListMessage());
    }

    public ArrayList<Message> getMessagesForId(Id Id) {
        TransactionController tc = new TransactionController();
        try {
            tc.getResponse("/" + Id.getGithubId() + "/messages");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(tc.getListMessage());
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }
 
}