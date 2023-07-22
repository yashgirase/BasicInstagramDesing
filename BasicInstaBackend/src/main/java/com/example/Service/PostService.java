package com.example.Service;

import com.example.Entity.Post;
import com.example.Repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    public String uploadPost(Post post) {
        post.setCreatedDate(LocalDateTime.now());
        post.setUpdatedDate(LocalDateTime.now());
        postRepo.save(post);
        return "Post uploaded successfully..";
    }

    public Post getPostById(Integer id) {
        return postRepo.findById(id).orElse(null); // if post found them return else return null;
    }
}
