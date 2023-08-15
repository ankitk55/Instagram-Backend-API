package com.Ankit.InstagramBackendBasicDesign.repository;

import com.Ankit.InstagramBackendBasicDesign.model.AuthenticationToken;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import com.Ankit.InstagramBackendBasicDesign.model.AuthenticationToken;
import com.Ankit.InstagramBackendBasicDesign.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationTokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByUser(User user);

    AuthenticationToken findFirstByTokenValue(String authTokenValue);



}
