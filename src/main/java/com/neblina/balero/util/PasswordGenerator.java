package com.neblina.balero.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    /**
     * Password Encoder
     * @param password
     * @return String
     */
    public String generatePassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String generatedPassword = passwordEncoder.encode(password);
        return generatedPassword;
    }

}
