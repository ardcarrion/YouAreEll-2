package controllers;

import java.io.IOException;
import java.util.ArrayList;

import models.Id;

public class IdController {
    Id myId;
    private TransactionController tc;

    public IdController() {
        this.myId = new Id("-", "Foo", "foobar2");
        this.tc = new TransactionController();
    }

    public ArrayList<Id> getIds() {

        try {
            tc.getResponse("/ids");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList(tc.getIds());
    }

    public Id postId(Id id) {
        try {
            tc.postResponse("/ids");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.myId;
    }

    public Id putId(Id id) {
        return null;
    }
 
}