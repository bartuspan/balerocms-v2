package com.neblina.balero.security;

/**
 * @author Anibal Gomez
 * Based on:
 * progrnotes.blogspot.mx/2012/07/spring-security-authenification-failure.html
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationErrorHandler implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private final Logger log = LoggerFactory.getLogger(UserAuthenticationErrorHandler.class);

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        Object userName = event.getAuthentication().getPrincipal();
        Object credentials = event.getAuthentication().getCredentials();
        log.warn("Failed login using USERNAME " + userName);
        log.warn("Failed login using PASSWORD " + credentials);
    }

}