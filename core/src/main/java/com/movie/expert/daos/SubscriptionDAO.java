package com.movie.expert.daos;

public interface SubscriptionDAO {
    void subscribe(long userId, long subscribedUserId);
}
