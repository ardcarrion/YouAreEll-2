package models;

import com.fasterxml.jackson.annotation.*;

/*
 * POJO for an Id object
 */
public class Id {

    public String getName() {
        return name;
    }

    public String getGithubId() {
        return github;
    }

    private String name;
    private  String github;


    public void setName(String name) {
        this.name = name;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @JsonCreator
    public Id(
            @JsonSetter("userid") String userid,
            @JsonSetter("name") String name,
            @JsonSetter("github") String github)
    {
        this.name = name;
        this.github = github;

    }


}