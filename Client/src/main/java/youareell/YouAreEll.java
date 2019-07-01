package youareell;

import controllers.*;
import views.IdTextView;
import views.MessageTextView;


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

    public String get_messages(IdTextView fromId, IdTextView toId) {
        String mainurl = "/ids/" + fromId.toString() + "/messages/" + toId.toString();
        return MakeURLCall(mainurl, "GET", "");
    }

    public void send_messages(MessageTextView message) {

    }

    public String MakeURLCall(String mainurl, String method, String jpayload) {
        StringBuilder sb = new StringBuilder();
        if (mainurl.equals("/messages")) msgCtrl.getMessages()
                                                .stream()
                                                .map(MessageTextView::new)
                                                .forEach(msg ->sb.append(msg.toString()));
        else if (mainurl.equals("/ids")) idCtrl.getIds().stream()
                                                .map(IdTextView::new)
                                                .forEach(id -> sb.append(id.toString() + " "));
        return sb.toString();
    }
}
