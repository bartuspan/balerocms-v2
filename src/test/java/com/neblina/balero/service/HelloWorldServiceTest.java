package com.neblina.balero.service;

import com.neblina.balero.Application;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class HelloWorldServiceTest extends TestCase {

    @Autowired
    HelloWorldService service;

    @Test
    public void test_getVersion() throws Exception {
        assertTrue(service.getVersion().endsWith("-test"));
    }

}