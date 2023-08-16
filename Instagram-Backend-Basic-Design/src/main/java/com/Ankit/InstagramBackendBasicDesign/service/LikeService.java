package com.Ankit.InstagramBackendBasicDesign.service;

import com.Ankit.InstagramBackendBasicDesign.model.Like;
import com.Ankit.InstagramBackendBasicDesign.model.Post;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import com.Ankit.InstagramBackendBasicDesign.model.dto.likeDto.GetLikeDto;
import com.Ankit.InstagramBackendBasicDesign.repository.ILikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikeService {
    @Autowired
    ILikeRepo likeRepo;

    public String likePost(User myself, Post post) {
        Like like = new Like();
        like.setLiker(myself);
        like.setPost(post);
        likeRepo.save(like);
        return "you have successfully liked "+post.getUser().getUserFirstName()+" post";
    }
    public Boolean isPostAlreadyLiked(User liker, Post post){
        Like like = likeRepo.findFirstByLikerAndPost(liker,post);
      if(like==null){
          return false;
      }
      return true;
    }

    public String deleteLike(User liker, Post post) {
        Like like = likeRepo.findFirstByLikerAndPost(liker,post);
        likeRepo.delete(like);
        return "like deleted for post Id "+post.getPostId();
    }

    public ResponseEntity<List<GetLikeDto>> getAllLikesByPostId(Post post) {
        List<Like>likeList =likeRepo.findByPost(post);
        List<GetLikeDto> likeDtolist =new ArrayList<>();
        for(Like like :likeList){
            likeDtolist.add(new GetLikeDto(like.getLiker().getUserId(),like.getLiker().getUserFirstName(),like.getLiker().getUserLastName()));
        }
        return ResponseEntity.ok(likeDtolist);
    }
}
