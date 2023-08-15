package com.Ankit.InstagramBackendBasicDesign.service;

import com.Ankit.InstagramBackendBasicDesign.model.Comment;
import com.Ankit.InstagramBackendBasicDesign.model.Follow;
import com.Ankit.InstagramBackendBasicDesign.model.Post;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import com.Ankit.InstagramBackendBasicDesign.model.dto.commentDto.AddCommentDto;
import com.Ankit.InstagramBackendBasicDesign.model.dto.commentDto.GetCommentDto;
import com.Ankit.InstagramBackendBasicDesign.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    ICommentRepo commentRepo;
    @Autowired
    PostService postService;
    @Autowired
    FollowService followService;


    public String postComment(AddCommentDto addCommentDto, User user, Post post) {
        Comment comment = new Comment();
        comment.setCommenter(user);
        comment.setPost(post);
        comment.setCommentCreationTimeStamp(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
        comment.setCommentContent(addCommentDto.getCommentContent());
        commentRepo.save(comment);
        return "comment Added ..";
    }

    public String deleteCommentById(User user, Long commentId) {
        Comment comment =commentRepo.findById(commentId).orElse(null);
        if(comment!=null && comment.getPost().getUser().equals(user) ){
            commentRepo.deleteById(commentId);
            return "comment deleted .. ";
        }
        if(comment==null || !comment.getCommenter().equals(user)){
            return "invalid comment id ..";
        }
        commentRepo.deleteById(commentId);
        return "comment deleted .. ";
    }

    public ResponseEntity<List<GetCommentDto>> allCommentsByPostId(User user, Long postId) {
        Post post= postService.getPostById(postId);
        if(post==null){
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        User postUser  =post.getUser() ;
        List<Follow>followList = followService.followRepo.findByFollowedToAndWantToFollow(postUser,user);
        if(postUser.getAccountType().toString().equals("PRIVATE")&& followList.size()<=0 && !user.equals(postUser)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        List<Comment>commentList =commentRepo.findByPost( post);
        List<GetCommentDto>dtoCommentList=new ArrayList<>();

        for(Comment comment:commentList){
            GetCommentDto commentDto =new GetCommentDto(comment.getCommentId(),comment.getCommentContent(),
                    comment.getCommentCreationTimeStamp(),comment.getCommenter().getUserId(),comment.getCommenter().getUserFirstName());
            dtoCommentList.add(commentDto);
        }
        return ResponseEntity.ok(dtoCommentList);
    }
//
//    public void deleteAllCommentByUser(User commenter) {
//        List<Comment>commentList=commentRepo.findByCommenter(commenter);
//        commentRepo.deleteAll(commentList);
//    }
}
