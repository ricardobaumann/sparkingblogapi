package sparglingblogapi;

import java.util.UUID;

public class Post {

    private final String id;

    private final String body;

    public Post(String id, String body) {
        this.id = id;
        this.body = body;
    }

    public Post(String body) {
        this.id = UUID.randomUUID().toString();
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
