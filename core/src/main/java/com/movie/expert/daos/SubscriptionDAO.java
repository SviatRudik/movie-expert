package com.movie.expert.daos;

public interface SubscriptionDAO {
    void subscribe(Long userId, Long subscribedUserId);
}
