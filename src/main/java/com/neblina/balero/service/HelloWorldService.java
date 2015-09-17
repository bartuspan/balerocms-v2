package com.neblina.balero.service;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

    private static String version = "0.1-test";

    public String getVersion() {
        return version;
    }
}