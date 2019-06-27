package views;

import controllers.*;
import models.Id;
import models.Message;


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
        StringBuilder sb = new StringBuilder();
        if (mainurl.equals("/messages")) msgCtrl.getMessages()
                                                .stream()
                                                .map(Message::getMessage)
                                                .forEach(str->sb.append(str + "\n"));
        else if (mainurl.equals("/ids")) idCtrl.getIds().stream()
                                                .map(Id::getGithubId)
                                                .forEach(str -> sb.append(str + " "));
        return sb.toString();
//        return "";
    }
}
