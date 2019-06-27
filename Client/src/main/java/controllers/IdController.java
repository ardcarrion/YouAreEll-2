package controllers;

import java.io.IOException;
import java.util.ArrayList;

import models.Id;

public class IdController {
    Id myId;

    public ArrayList<Id> getIds() {
        TransactionController tc = new TransactionController();
        try {
            tc.makeObjectMap("/ids");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList(tc.getIds());
    }

    public Id postId(Id id) {
        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}