package com.Ankit.InstagramBackendBasicDesign.repository;

import com.Ankit.InstagramBackendBasicDesign.model.Follow;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFollowRepo extends JpaRepository<Follow,Long> {

   List< Follow> findByFollowedToAndWantToFollow(User followerUser, User user);

   List<Follow> findByFollowedTo(User followerUser);

   List<Follow> findByWantToFollow(User user);
}
