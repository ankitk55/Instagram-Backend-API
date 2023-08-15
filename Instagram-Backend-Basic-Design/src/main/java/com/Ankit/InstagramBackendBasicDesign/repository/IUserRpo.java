package com.Ankit.InstagramBackendBasicDesign.repository;

import com.Ankit.InstagramBackendBasicDesign.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRpo extends JpaRepository<User,Long> {
    User findFirstByUserEmail(String newEmail);
}
