package com.movie.expert.daos;

import com.movie.expert.models.User;

public interface UserDAO {

    void register(User user);

    boolean checkUserExistsByEmail(String email);

    boolean checkUserExistsByUsername(String username);
}
