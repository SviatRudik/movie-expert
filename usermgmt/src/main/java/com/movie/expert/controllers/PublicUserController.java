package com.movie.expert.controllers;

import com.movie.expert.models.*;
import com.movie.expert.securitypolicies.JwtUtil;
import com.movie.expert.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/public")
@AllArgsConstructor
public class PublicUserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/registration")
    ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest request) {
        RegistrationResponse response = userService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = (User) auth.getPrincipal();
        String token = jwtUtil.createToken(user);
        LoginResponse loginRes = new LoginResponse(request.getUsername(), token);
        return ResponseEntity.status(HttpStatus.OK).body(loginRes);
    }


}
