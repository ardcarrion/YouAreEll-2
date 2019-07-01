package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.Id;

import static java.util.stream.Collectors.toList;

public class IdController {
    Id myId;
    private TransactionController tc;

    public IdController() {
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

    public Id postId(Id newId) {
        String name = newId.getName();
        Id foundId = findId(newId.getGithub());
        if (foundId != null) {
            foundId.setName(name);
            return putId(foundId);
        }
        try {
            tc.postResponse("/ids", newId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newId;
    }

    public Id findId(String githubId) {
        ArrayList<Id> ids = getIds();
        return findId(githubId, ids);
    }

    public Id findId(String githubId, ArrayList<Id> ids) {
        List<Id> foundId = ids.stream().filter(temp -> temp.getGithub().equals(githubId)).collect(toList());
        return (foundId.size() == 0) ? null : foundId.get(0);
    }

    public Id putId(Id id) {
        try {
            tc.putResponse("/ids", id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }
 
}