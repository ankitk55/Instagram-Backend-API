package com.Ankit.InstagramBackendBasicDesign.repository;

import com.Ankit.InstagramBackendBasicDesign.model.Comment;
import com.Ankit.InstagramBackendBasicDesign.model.Post;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepo extends JpaRepository<Comment,Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findByCommenter(User commenter);
}
