package com.Ankit.InstagramBackendBasicDesign.service;

import com.Ankit.InstagramBackendBasicDesign.model.FollowRequest;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import com.Ankit.InstagramBackendBasicDesign.repository.IFollowRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowRequestService {
    @Autowired
    IFollowRequestRepo followRequestRepo;


    public String request(User user, User followerUser) {
        FollowRequest followRequest = new FollowRequest();
        List<FollowRequest> followRequests =followRequestRepo.findByRequestSendToAndRequestSendBy(followerUser,user);
        if(followRequests.size()>0){
            return "request already sent ..";
        }

        followRequest.setRequestSendBy(user);
        followRequest.setRequestSendTo(followerUser);
        followRequestRepo.save(followRequest);
        return "request has been sent successfully..";
    }

    public ResponseEntity<List<User>> getAllRequests(User user) {
        List<FollowRequest> followRequests =followRequestRepo.findByRequestSendTo(user);
        List<User> requestUsers = new ArrayList<>();
        for(FollowRequest followRequest1:followRequests){
            requestUsers.add(followRequest1.getRequestSendBy());
        }
        return ResponseEntity.ok(requestUsers);
    }

    public void deleteRequest(User myself, User followerUser) {
        List<FollowRequest> followRequests = followRequestRepo.findByRequestSendToAndRequestSendBy(myself,followerUser);
        if(followRequests.size()>0){
            FollowRequest followRequest1 = followRequests.get(0);
            followRequestRepo.delete(followRequest1);
        }

    }
}
