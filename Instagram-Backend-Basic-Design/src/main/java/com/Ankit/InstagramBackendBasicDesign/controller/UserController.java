package com.Ankit.InstagramBackendBasicDesign.controller;

import com.Ankit.InstagramBackendBasicDesign.model.Follow;
import com.Ankit.InstagramBackendBasicDesign.model.Post;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import com.Ankit.InstagramBackendBasicDesign.model.dto.SignInInput;
import com.Ankit.InstagramBackendBasicDesign.model.dto.SignUpOutput;
import com.Ankit.InstagramBackendBasicDesign.model.dto.commentDto.AddCommentDto;
import com.Ankit.InstagramBackendBasicDesign.model.dto.commentDto.GetCommentDto;
import com.Ankit.InstagramBackendBasicDesign.model.enums.AccountType;
import com.Ankit.InstagramBackendBasicDesign.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {
        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutUser(String email, String token) {
        return userService.sigOutUser(email, token);
    }

    @PutMapping("user/email/{newEmail}")
    public String updateUserEmail(@PathVariable String newEmail,@RequestParam @Valid String email, @RequestParam String token){
        return userService.updateUserEmail(newEmail,email,token);
    }
    @PutMapping("user/phone/{newPhoneNumber}")
    public String updateUserPhone(@PathVariable String newPhoneNumber,@RequestParam @Valid String email, @RequestParam String token){
        return userService.updateUserPhone(newPhoneNumber,email,token);
    }
    @PutMapping("user/password/{newPassword}")
    public String updatePassword(@PathVariable @Valid String newPassword,@RequestParam @Valid String email, @RequestParam String token){
        return userService.updatePassword(newPassword,email,token);
    }

    @PostMapping("createPost")
    public String addPost(@RequestParam @Valid String email, @RequestParam String token,@RequestBody Post post){
        return userService.addPost(email,token,post);
    }

    @PutMapping("edit/post/{postId}")
    public String editPost(@PathVariable Long postId,@RequestParam @Valid String email, @RequestParam String token,@RequestParam String newPostData){
        return userService.editPost(postId,email,token,newPostData);
    }

    @GetMapping("my/posts")
    public List<Post> getAllPost(@RequestParam @Valid String email, @RequestParam String token){
        return userService.getAllPost(email,token);
    }

    @DeleteMapping("post/{postId}")
    public String deletePostById(@PathVariable Long postId,@RequestParam @Valid String email, @RequestParam String token){
        return userService.deletePostById(postId,email,token);
    }

    @DeleteMapping("user/account")
    public String deleteUserAccount(@RequestParam @Valid String email,@RequestParam String token){

            return userService.deleteUserAccount(email,token);
    }
@PostMapping("follow/{userId}")
    public String follow(@RequestParam @Valid String email,@RequestParam String token,@PathVariable Long userId){
        return userService.follow(email,token,userId);
}
@DeleteMapping("unfollow/{userId}")
    public String unfollowByUserId(@RequestParam @Valid String email,@RequestParam String token,@PathVariable Long userId){
        return userService.unfollowByUserId(email,token,userId);
}
@GetMapping("followers/{userId}")
    public ResponseEntity<List<User>>getAllFollowersById(@RequestParam @Valid String email,@RequestParam String token,@PathVariable Long userId){
        return userService.getAllFollowersById(email,token,userId);
}
@GetMapping("followings/{userId}")
    public ResponseEntity<List<User>>getFollowingsById(@RequestParam @Valid String email,@RequestParam String token,@PathVariable Long userId){
        return userService.getFollowingsById(email,token,userId);
}
@GetMapping("profile/{userId}")
    public ResponseEntity<User> getProfileById(@RequestParam @Valid String email,@RequestParam String token,@PathVariable Long userId){
        return userService.getProfileById(email,token,userId);
}
@GetMapping("all/follow/requests")
    public ResponseEntity<List<User>> getAllRequests(@RequestParam @Valid String email,@RequestParam String token){
        return userService.getAllRequests(email,token);
}
@PutMapping("follow/request/accept/{userId}")
    public String requestAcceptByUserId(@RequestParam @Valid String email,@RequestParam String token,@PathVariable Long userId){
        return userService.requestAcceptByUserId(email,token,userId);
}
@DeleteMapping("follow/request/{userId}")
    public String deleteFollowRequests(@RequestParam @Valid String email,@RequestParam String token,@PathVariable Long userId){
        return userService.deleteFollowRequest(email,token,userId);
}
@PutMapping("account/type/{accountType}")
    public String updateAccountType(@RequestParam @Valid String email, @RequestParam String token, @PathVariable AccountType accountType){
        return userService.updateAccountType(email,token,accountType);
}
    @DeleteMapping("comment/{commentId}")
    public String deleteCommentById(@RequestParam @Valid String email, @RequestParam String token, @PathVariable Long commentId){
        return userService.deleteCommentById(email,token,commentId);
    }
    @GetMapping("comments/post/{postId}")
    public ResponseEntity<List<GetCommentDto>>allCommentsByPostId(@RequestParam @Valid String email, @RequestParam String token, @PathVariable Long postId){
        return userService.allCommentsByPostId(email,token,postId);
    }
    @PostMapping("comment/post/{postId}")
    public String postComment(@RequestParam @Valid String email, @RequestParam String token, @RequestBody AddCommentDto addCommentDto, @PathVariable Long postId){
        return userService.postComment(email,token,addCommentDto,postId);
    }

}
