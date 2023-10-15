package com.example.Repository;

import com.example.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface IPostRepo extends JpaRepository<Post, Integer> {
}
