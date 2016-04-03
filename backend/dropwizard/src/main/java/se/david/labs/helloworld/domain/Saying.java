package se.david.labs.helloworld.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Saying {
    @Length(max = 3)
    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(String content) {
        this.content = content;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
