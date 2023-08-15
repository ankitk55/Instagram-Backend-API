package com.Ankit.InstagramBackendBasicDesign.service;

import com.Ankit.InstagramBackendBasicDesign.model.AuthenticationToken;
import com.Ankit.InstagramBackendBasicDesign.repository.IAuthenticationTokenRepo;
import com.Ankit.InstagramBackendBasicDesign.model.AuthenticationToken;
import com.Ankit.InstagramBackendBasicDesign.repository.IAuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationTokenRepo authTokenRepo;

    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authTokenRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getUser().getUserEmail();

        return tokenConnectedEmail.equals(email);
    }

    public void createToken(AuthenticationToken authToken) {
        authTokenRepo.save(authToken);
    }
}
