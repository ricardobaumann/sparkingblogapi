package sparglingblogapi;

import javax.inject.Singleton;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class PostService {

    private final Map<String,Post> postMap = new HashMap<>();

    public Post create(final Post post) {
        Post createdPost = new Post(post.getBody());
        postMap.put(createdPost.getId(),createdPost);
        return createdPost;
    }

    public Collection<Post> get() {
        return postMap.values();
    }

    public Post get(String id) {
        return postMap.get(id);
    }

    public void delete(String id) {
        postMap.remove(id);
    }

}
