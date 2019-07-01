package models;

import com.fasterxml.jackson.annotation.*;

/*
 * POJO for an Id object
 */
public class Id {

    public String getName() {
        return name;
    }


    private String name;
    private String github;
    private String userId;

    @JsonCreator
    public Id(
            @JsonProperty("userid") String userid,
            @JsonProperty("name") String name,
            @JsonProperty("github") String github)
    {
        this.name = name;
        this.github = github;
        this.userId = userid;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return "Id{" +
                "name='" + name + '\'' +
                ", github='" + github + '\'' +
                '}';
    }
}