package views;

import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.*;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import models.Id;
import models.Message;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class YouAreEll {

    private MessageController msgCtrl;
    private IdController idCtrl;

    public YouAreEll (MessageController m, IdController j) {
        // used j because i seems awkward
        this.msgCtrl = m;
        this.idCtrl = j;
    }



    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(new MessageController(), new IdController());
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() {
        return MakeURLCall("/ids", "GET", "");
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }

    public String MakeURLCall(String mainurl, String method, String jpayload) {
        TransactionController tc = new TransactionController();
        try {
            tc.makeObjectMap(mainurl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        if (mainurl.equals("/ids")) {
            Stream<Id> ids = tc.getIds().stream();
            ids.map(Id::getGithubId).forEach(foo -> sb.append(foo + " "));
        } else {
            Stream<Message> messages = tc.getListMessage().stream();
            messages.map(Message::getMessage).forEach(bar -> sb.append(bar + "\n"));
        }
        return sb.toString();
    }
}
