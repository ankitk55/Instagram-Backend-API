package com.Ankit.InstagramBackendBasicDesign.service;

import com.Ankit.InstagramBackendBasicDesign.model.Follow;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import com.Ankit.InstagramBackendBasicDesign.repository.IFollowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowService {
    @Autowired
    IFollowRepo followRepo;

    FollowRequestService followRequestService;

    public String follow(User followerUser, User user) {
Follow follow = new Follow();

        follow.setFollowedTo(followerUser);
        followerUser.setFollower(followerUser.getFollower()+1);
        follow.setWantToFollow(user);
       user.setFollowing(user.getFollowing()+1);
        followRepo.save(follow);
        return "followed successfully ";
    }

    public String unfollowByUserId(User followerUser, User user) {
        List< Follow> follow1 =followRepo.findByFollowedToAndWantToFollow(followerUser,user);
        if(follow1.size()<=0){
            return "you can't unfollow this is already unfollowed .. ";
        }
        followerUser.setFollower(followerUser.getFollower()-1);
        user.setFollowing(user.getFollowing()-1);
        Follow followData = follow1.get(0);

        followRepo.delete(followData);
        return "successfully unfollowed ..";
    }

    public ResponseEntity<List<User>> getAllFollowersById(User followerUser) {
        List<Follow> follows=followRepo.findByFollowedTo(followerUser);
        List<User>followers = new ArrayList<>();
        for(Follow follow :follows){
            followers.add(follow.getWantToFollow());
        }
        return ResponseEntity.ok(followers);
    }

    public ResponseEntity<List<User>> getFollowingsById(User user) {
        List<Follow> follows=followRepo.findByWantToFollow(user);
        List<User>followings = new ArrayList<>();
        for(Follow following :follows){
            followings.add(following.getFollowedTo());
        }
        return ResponseEntity.ok(followings);
    }
}
