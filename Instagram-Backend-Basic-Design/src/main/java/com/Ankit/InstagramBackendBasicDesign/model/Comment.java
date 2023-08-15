package com.Ankit.InstagramBackendBasicDesign.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @NotBlank
    private String commentContent;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime commentCreationTimeStamp;
    @ManyToOne
    @JoinColumn(name = "fk_commenterId")
    private User commenter;
    @ManyToOne
    @JoinColumn(name = "fk_postId")
    private Post post;
}
