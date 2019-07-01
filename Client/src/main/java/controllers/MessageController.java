package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.Id;
import models.Message;
import views.SimpleShell;

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
            tc.getResponse("/ids/" + Id.getGithub() + "/messages");
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
            tc.getResponse("/" + myId.getGithub() + "/messages/" + friendId.getGithub());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(tc.getListMessage());
    }



    public Message postMessage(Id myId, Message msg) {

        try {
            tc.postResponse("/ids/" + myId.getGithub() + "/messages", msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

}