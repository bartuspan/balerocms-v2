package com.neblina.balero.service;

import com.neblina.balero.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User create() {
        User newUser = new User();
        // Setters
        return newUser;
    }

}
