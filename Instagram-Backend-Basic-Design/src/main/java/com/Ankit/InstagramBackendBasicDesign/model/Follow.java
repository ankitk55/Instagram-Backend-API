package com.Ankit.InstagramBackendBasicDesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followId;
    @ManyToOne
    @JoinColumn(name = "fk_wantToFollow")
    private User wantToFollow;
    @ManyToOne
    @JoinColumn(name = "fk_followedTo")
    private User followedTo;
}
