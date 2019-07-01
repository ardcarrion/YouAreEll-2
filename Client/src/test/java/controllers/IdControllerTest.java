package controllers;

import models.Id;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;


public class IdControllerTest {

    @Test
    public void getIds() {
    }

    @Test
    public void findId1() {
        IdController j = new IdController();
        ArrayList<Id> ids = new ArrayList<>();
        Id id1 = new Id("-", "Foo", "foobar");
        Id id2 = new Id("-", "Tess", "tester");
        Id id3 = new Id("-", "Spam", "spamalot");
        Id expected = new Id("-", "Alicia", "ardcarrion");
        ids.add(id1);
        ids.add(id2);
        ids.add(id3);
        ids.add(expected);
        Id actual = j.findId(expected.getGithub(), ids);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findId2() {
        IdController j = new IdController();
        ArrayList<Id> ids = new ArrayList<>();
        Id id1 = new Id("-", "Foo", "foobar");
        Id id2 = new Id("-", "Tess", "tester");
        Id id3 = new Id("-", "Spam", "spamalot");
        ids.add(id1);
        ids.add(id2);
        ids.add(id3);
        Id actual = j.findId("ardcarrion", ids);
        Assert.assertNull(actual);
    }

}