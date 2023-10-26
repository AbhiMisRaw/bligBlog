package com.example.BligBlog.service;


import com.example.BligBlog.domain.Post;
import com.example.BligBlog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository ;

    public void addPost(Post post){
        postRepository.addPost(post);
    }
    public Set<Post> findAllPosts(){
        return postRepository.findAllPosts();
    }

    public boolean postExistWithTitle(String title) {
        return findAllPosts().stream().anyMatch(post -> post.getTitle().equals(title));
    }

    public Post findOnePost(Integer postId) {
        return postRepository.findAllPosts().stream().filter(post -> post.getId().equals(postId)).findFirst()
                .orElseThrow(() -> new BligBlogException("Cannot find post by id :"+ postId)) ;
    }
}
