package com.neblina.balero.service;

import com.neblina.balero.Application;
import com.neblina.balero.util.AssetPipeline;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;

@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class AssetPipelineTest extends TestCase {

    @Test
    public void printHtmlResourceFileList() throws IOException {
        try {
            AssetPipeline resources = new AssetPipeline();
            ArrayList<String> list = resources.getHtmlResourceFileList("templates/authorized");
            System.out.println("The arraylist contains the following elements: "  + list);
            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}