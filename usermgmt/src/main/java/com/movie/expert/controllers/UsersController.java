package com.movie.expert.controllers;

import com.movie.expert.models.RegistrationRequest;
import com.movie.expert.models.RegistrationResponse;
import com.movie.expert.models.User;
import com.movie.expert.models.exceptions.PlatformError;
import com.movie.expert.models.exceptions.PlatformException;
import com.movie.expert.models.exceptions.UniquenessException;
import com.movie.expert.services.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@ControllerAdvice
public class UsersController {

    private final UserServiceImpl userService;

    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/public/registration")
    ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest request) {
        RegistrationResponse response = userService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/login")
    ResponseEntity<User> login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User response = userService.loadUserByUsername(username);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ExceptionHandler(PlatformException.class)
    public ResponseEntity<PlatformError> handleCustomException(UniquenessException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PlatformError(ex.getErrorCode(), ex.getErrorMsg()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<PlatformError> handleException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PlatformError(500, "Internal Server Error"));
    }
}
