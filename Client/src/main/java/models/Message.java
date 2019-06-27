package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/*
 * POJO for an Message object
 */
public class Message {

    private String sequence;
    private String timeStamp;
    private String message;
    private String fromId;
    private String toId;

    @JsonCreator
    public Message (
            @JsonProperty("sequence") String sequence,
            @JsonProperty("timestamp") String timestamp,
            @JsonProperty("fromid")  String fromId,
            @JsonProperty("toid") String toId,
            @JsonProperty("message") String message) {
        this.message = message;
        this.fromId = fromId;
        this.toId = toId;
        this.sequence = sequence;
        this.timeStamp = timestamp;
    }

    public String getMessage() {
        return fromId + " " + toId + " " + message;
    }

    public String getFromId() {
        return fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }
}