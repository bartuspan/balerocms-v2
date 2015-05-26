/**
 * Silbato Project: Proyecto 100% Mexicano de código libre.
 *
 * @author      Anibal Gomez <anibalgomez@icloud.com>
 * @copyright   Copyright (C) 2015 Neblina Software. Derechos reservados.
 * @license     Licencia Pública GNU versión 3 o superior; vea LICENSE.txt
 */

package com.neblina.balero.web.authorized;

import com.neblina.balero.service.UserService;
import com.neblina.balero.service.repository.UserRepository;
import com.neblina.balero.util.PasswordGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    public UserController(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LogManager.getLogger(UserController.class.getName());

    @RequestMapping( value = {"", "/"} )
    public String rootIndex() {
        return "redirect:/user/dashboard";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@RequestParam("username") String username) {
        PasswordGenerator pwd = new PasswordGenerator();
        userService.createUserAccount("demo", "123456", "Pepito", "Perez", "demo@localhost", "USER");
        //inMemoryUserDetailsManager.createUser(new User("demo", "demo", new ArrayList<GrantedAuthority>()));
        //AuthorityUtils.createAuthorityList("ROLE_USER")
        try {
            inMemoryUserDetailsManager.createUser(new User(username, pwd.generatePassword("demo"), AuthorityUtils.createAuthorityList("ROLE_USER")));
        } catch (Exception e) {
            log.debug("inMemoryUserDetailsManager: " + e.getMessage());
        }
        return "redirect:/login";
    }

    @Secured("ROLE_USER")
    @RequestMapping("/dashboard")
    public String dashboardAdmin() {
        return "authorized/dashboard";
    }

}