package com.sayantha.nexttravel.service;

import com.sayantha.nexttravel.config.JWTService;
import com.sayantha.nexttravel.entity.UserDetails;
import com.sayantha.nexttravel.repo.UserRepo;
import com.sayantha.nexttravel.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private Response response;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTService jwtService;

    public Response register(UserDetails userDetails) {
        System.out.println(userDetails.toString());
        String password = passwordEncoder.encode(userDetails.getPassword());
        userDetails.setUserPassword(password);
        userRepo.save(userDetails);
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("User successfully registered and JWT Successfully generated!");
        response.setData(jwtService.generateToken(userDetails));
        return response;
    }


}
