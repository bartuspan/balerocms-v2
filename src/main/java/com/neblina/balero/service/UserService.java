package com.neblina.balero.service;

import com.neblina.balero.domain.User;
import com.neblina.balero.service.repository.UserRepository;
import com.neblina.balero.util.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUserAccount(String userName, String firstName, String lastName,
                                  String email, String roles, String password) {
        PasswordGenerator pwd = new PasswordGenerator();
        User user = new User();
        user.setUsername(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setRoles(roles);
        user.setPassword(pwd.generatePassword(password));
        userRepository.save(user);
        return user;
    }

    public List<User> getUserByUsername(String username) {
        List<User> user = userRepository.findOneByUsername(username);
        return user;
    }

}
