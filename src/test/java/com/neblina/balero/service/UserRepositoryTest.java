package com.neblina.balero.service;

import com.neblina.balero.Application;
import com.neblina.balero.domain.User;
import com.neblina.balero.service.repository.UserRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class UserRepositoryTest extends TestCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void search_TwoUserEntriesFound_ShouldReturnAListOfTwoEntries() {
        List<User> user = (List<User>) userRepository.findAll();
        assertThat(user.size(), is(2));
        assertThat(user, contains(
                allOf(
                        hasProperty("id", is(1L)),
                        hasProperty("username", is("admin"))
                ),
                allOf(
                        hasProperty("id", is(2L)),
                        hasProperty("username", is("user"))
                )
        ));

    }

    @Test
    public void createUser() {
        userService.createUserAccount("demo", "Pepito", "Perez", "admin@localhost", "ADMIN, USER", "123456");
        System.out.println("Creando Usuario Demo...");
    }

}

