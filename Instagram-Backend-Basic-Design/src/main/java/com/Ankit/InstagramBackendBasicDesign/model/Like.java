package com.Ankit.InstagramBackendBasicDesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "post_like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;
    @ManyToOne
    @JoinColumn(name = "fk_likerId")
    private User liker;
    @ManyToOne
    @JoinColumn(name = "fk_postId")
    private Post post;
}
