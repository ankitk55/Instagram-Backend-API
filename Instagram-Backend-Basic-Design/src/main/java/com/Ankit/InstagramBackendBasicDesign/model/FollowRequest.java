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

public class FollowRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long followRequestId;
    @ManyToOne
    @JoinColumn(name = "fk_requestSendTo")
    private User requestSendTo;
    @ManyToOne
    @JoinColumn(name = "fk_requestSendBy")
    private User requestSendBy;

}
