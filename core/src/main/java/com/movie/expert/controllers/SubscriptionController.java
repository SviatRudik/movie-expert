package com.movie.expert.controllers;

import com.movie.expert.securitypolicies.JwtUtil;
import com.movie.expert.services.SubscriptionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
@AllArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private final JwtUtil jwtUtil;

    @GetMapping
    ResponseEntity subscribe(@RequestParam(name = "userId") long userId, HttpServletRequest req) {
        long subscribedUserId = jwtUtil.getId(req);
        subscriptionService.subscribe(userId, subscribedUserId);
        return ResponseEntity.ok().build();
    }
}
