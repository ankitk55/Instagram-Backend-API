package com.Ankit.InstagramBackendBasicDesign.service;

import com.Ankit.InstagramBackendBasicDesign.model.Post;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import com.Ankit.InstagramBackendBasicDesign.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    IPostRepo iPostRepo;



    public String addPost(User user, Post post) {
        post.setPostCreationTime(LocalDateTime.now());
        post.setUser(user);
        iPostRepo.save(post);
        return "post uploaded..";
    }

    public String editPost(Long postId, String newPostData,User user) {
        Post post =iPostRepo.findById(postId).orElse(null);
        if(post ==null){
            return "invalid postId";
        }
        User postUser =post.getUser();
        if(postUser.equals(user)){
            post.setPostUpdatedTime(LocalDateTime.now());
            post.setPostData(newPostData);
            iPostRepo.save(post);
            return "post Information updated";
        }
        return "invalid postId";

    }

    public List<Post> getAllPost(User user) {
        return iPostRepo.findByUser(user);
    }

    public String deletePostById(Long postId, User user) {
        Post post =iPostRepo.findById(postId).orElse(null);
        if(post ==null){
            return "invalid postId";
        }
        User postUser =post.getUser();
        if(postUser.equals(user)){
            iPostRepo.deleteById(postId);
            return "post deleted ..";
        }
        return "invalid postId";
    }

    public void deleteAllPostByUser(User user) {
        List<Long>postIds=new ArrayList<>();
        List<Post>posts= iPostRepo.findByUser(user);
        for(Post singlePost:posts){
            postIds.add(singlePost.getPostId());
        }
        iPostRepo.deleteAllById(postIds);

    }

    public Post getPostById(Long postId) {
       return iPostRepo.findById(postId).orElse(null);
    }
}
