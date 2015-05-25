package com.neblina.balero.service;

import com.neblina.balero.domain.User;
import com.neblina.balero.service.repository.UserRepository;
import com.neblina.balero.util.PasswordGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger log = LogManager.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    public User createUserAccount(String userName, String password, String firstName, String lastName,
                                  String email, String roles) {
        PasswordGenerator pwd = new PasswordGenerator();
        User user = new User();
        user.setUsername(userName);
        user.setPassword(pwd.generatePassword(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setRoles(roles);
        userRepository.save(user);
        // login
        //Authentication a = new UsernamePasswordAuthenticationToken("demo", user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        //SecurityContextHolder.getContext().setAuthentication(a);
        return user;
    }


    public List<User> getUserByUsername(String username) {
        List<User> user = userRepository.findOneByUsername(username);
        return user;
    }

}
