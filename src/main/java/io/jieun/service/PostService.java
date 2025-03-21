package io.jieun.service;

import io.jieun.data.Post;
import io.jieun.repository.PostRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostService {

    private PostRepository PostRepository = new PostRepository();

    public int save(String title, String body) {
        return PostRepository.save(title, body);
    }

    public Post getById(int postId) {
        return PostRepository.getById(postId);
    }

    public void update(int postId, String title, String body) {
        PostRepository.update(postId, title, body);
    }

    public void removeById(int postId) {
        PostRepository.removeById(postId);
    }

}
