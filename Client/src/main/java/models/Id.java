package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * POJO for an Id object
 */
public class Id {

    public String getName() {
        return name;
    }

    public String getGithubId() {
        return githubId;
    }

    private String name;
    private  String githubId;
    private String userId;
    

    @JsonCreator
    public Id(
            @JsonProperty("github") String githubId,
            @JsonProperty("name") String name,
            @JsonProperty("userid") String userId) {
        this.name = name;
        this.githubId = githubId;
        this.userId = userId;
    }


}