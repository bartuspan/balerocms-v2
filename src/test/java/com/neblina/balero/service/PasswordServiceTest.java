/**
 * Prueba unitaria creada por:  Anibal Gomez <anibalgomez@icloud.com>
 */

package com.neblina.balero.service;

import com.neblina.balero.Application;
import com.neblina.balero.util.PasswordService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class PasswordServiceTest extends TestCase {

    @Test
    public void generatePassword() throws Exception {
        try {
            System.out.println("Generando password SHA1 para admin...");
            System.out.println(PasswordService.getInstance().encrypt("admin"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
