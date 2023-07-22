package com.example.Controller;

import com.example.Entity.Post;
import com.example.Service.AuthTokenUserService;
import com.example.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    AuthTokenUserService authTokenUserService;


    @PostMapping("post")
    public String uploadPost(@RequestBody Post post , @RequestParam String email , String token){
       if(authTokenUserService.authenticate(email , token))
       {
           return postService.uploadPost(post);
       }
       return "You are not authenticated user to upload the post";
    }

    @GetMapping("post")
    public Post getPostById(@RequestParam String email , @RequestParam String token , @RequestParam Integer id){
        if(authTokenUserService.authenticate(email , token)){
            return postService.getPostById(id);
        }
        return null;
    }
}
