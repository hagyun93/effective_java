package me.whiteship.chapter01.item07.cache;

import java.util.HashMap;
import java.util.Map;

public class PostRepository {

    private Map<CacheKey, Post> cache;

    public PostRepository() {
        this.cache = new HashMap<>();
    }

    public Post getPostById(Integer id) {
        CacheKey key = new CacheKey(id);
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            // [TODO] DB에서 읽어오거나 REST API를 통해 읽어 올 수 있다.
            Post post = new Post();
            cache.put(key, post);
            return post;
        }
    }

    public Map<CacheKey, Post> getCache() {
        return cache;
    }
}
