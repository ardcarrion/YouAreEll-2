package views;

import models.Message;

public class MessageTextView {

    private Message message;
    public MessageTextView(Message msgToDisplay) {
        message = msgToDisplay;
    }
    @Override public String toString() {
        return message.getMessage();
    } 
}