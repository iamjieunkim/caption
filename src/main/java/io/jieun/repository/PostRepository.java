package io.jieun.repository;

import io.jieun.data.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//repository저장소
//Spring MVC
//리포지터리는 정확히 -> 데이터 소스가 있던
//컨트롤러는 사용자 요청을 받아서 처리하는 것이고
public class PostRepository {

    private int sequence = 0;
    private List<Post> postList = new ArrayList<>();

    public int save(String title, String body) {

        Post newPost = new Post(++sequence, title, body);
        postList.add(newPost);

        return newPost.getId();
    }

    public Post getById(int postId) {
        return postList.get(postId - 1);
    }

    public void update(int postId, String title, String body) {
        Post findPost = postList.get(postId - 1);

        findPost.setTitle(title);
        findPost.setBody(body);

        findPost.setUpdatedAt(LocalDate.now());

    }

    public void removeById(int postId) {
        Post findPost = postList.get(postId - 1);

        if (findPost != null) {
            postList.set(postId - 1, null);
        }
    }
}
