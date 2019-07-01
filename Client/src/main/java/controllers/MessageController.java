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
    private TransactionController tc;
    public MessageController() {
        this.messagesSeen = new HashSet<>();
        tc = new TransactionController();
    }
    // why a HashSet??

    public ArrayList<Message> getMessages() {
        try {
            tc.getResponse("/messages");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(tc.getListMessage());
    }

    public ArrayList<Message> getMessagesForId(Id Id) {
        try {
            tc.getResponse("/" + Id.getGithubId() + "/messages");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(tc.getListMessage());
    }

    public Message getMessageForSequence(String seq) {
        try {
            tc.getResponse("/ids" + "/messages/" + seq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tc.getListMessage().get(0);
    }

    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        try {
            tc.getResponse("/" + myId.getGithubId() + "/messages/" + friendId.getGithubId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(tc.getListMessage());
    }

    public Message postMessage(Id myId, Id toId, Message msg) {

        try {
            tc.postResponse("/" + myId.getGithubId() + "/messages/" + toId.getGithubId(), msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public Message postMessage(Id myId, Message msg) {

        try {
            tc.postResponse("/" + myId.getGithubId() + "/message", msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}