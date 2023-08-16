package com.Ankit.InstagramBackendBasicDesign.repository;

import com.Ankit.InstagramBackendBasicDesign.model.Like;
import com.Ankit.InstagramBackendBasicDesign.model.Post;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILikeRepo extends JpaRepository<Like,Long> {
    public List<Like> findByLikerAndPost(User liker, Post post);

    Like findFirstByLikerAndPost(User liker, Post post);

    List<Like> findByPost(Post post);
}
