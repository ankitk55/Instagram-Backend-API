package com.Ankit.InstagramBackendBasicDesign.repository;

import com.Ankit.InstagramBackendBasicDesign.model.FollowRequest;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFollowRequestRepo extends JpaRepository<FollowRequest,Long> {
    List<FollowRequest> findByRequestSendTo(User user);

    List<FollowRequest> findByRequestSendToAndRequestSendBy(User followerUser, User user);
}
