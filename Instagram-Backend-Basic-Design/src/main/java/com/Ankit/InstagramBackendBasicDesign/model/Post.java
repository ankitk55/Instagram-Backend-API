package com.Ankit.InstagramBackendBasicDesign.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime postCreationTime;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime postUpdatedTime;

    private String postData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_userId")
    private User user;

}
