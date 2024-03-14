package com.movie.expert.services;

import com.movie.expert.daos.SubscriptionDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionDAO subscriptionDAO;

    @Override
    @Transactional
    public void subscribe(Long userId, Long subscribedUserId) {
        subscriptionDAO.subscribe(userId, subscribedUserId);
    }
}
