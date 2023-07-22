package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime updatedDate;

    private String postData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user-id")
    private User user;

}
