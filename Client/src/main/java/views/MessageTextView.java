package views;

import models.Message;

public class MessageTextView {

    private Message message;

    public MessageTextView(Message msgToDisplay) {
        message = msgToDisplay;
    }
    @Override public String toString() {
        String toId = (message.getToId().isEmpty()) ? "world" : message.getToId();
        return "\nFrom: " + message.getFromId() + " To: " + toId + "\n" + message.getMessage();
    } 
}