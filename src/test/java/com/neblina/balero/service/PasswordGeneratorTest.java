/**
 * Prueba unitaria creada por:  Anibal Gomez <anibalgomez@icloud.com>
 */

package com.neblina.balero.service;

import com.neblina.balero.Application;
import com.neblina.balero.util.PasswordGenerator;
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
public class PasswordGeneratorTest extends TestCase {

    /**
     * @author Anibal Gomez <anibalgomez@icloud.com>
     * References:
     * http://www.mkyong.com/spring-security/spring-security-password-hashing-example/
     * https://github.com/spring-projects/spring-security-javaconfig/issues/113
     */
    @Test
    public void generatePassword() {
        PasswordGenerator pwd = new PasswordGenerator();

        System.out.println("Hash for pwd admin->" + pwd.generatePassword("admin"));
        System.out.println("Hash for pwd user->" + pwd.generatePassword("user"));
    }

}
