/**
 * Balero CMS v2 Project: Proyecto 100% Mexicano de código libre.
 *
 * @author      Anibal Gomez <anibalgomez@icloud.com>
 * @copyright   Copyright (C) 2015 Neblina Software. Derechos reservados.
 * @license     Licencia Pública GNU versión 3 o superior; vea LICENSE.txt
 */

package com.neblina.balero.util;

import com.googlecode.htmlcompressor.compressor.HtmlCompressor;
import com.neblina.balero.web.TestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

@Configuration
@Profile("prod")
public class AssetPipeline {

    private static final Logger log = LogManager.getLogger(TestController.class.getName());

    public AssetPipeline() {
        log.debug("Running Balero CMS Resource Compiler...");
    }

    public void compress(String file) {
        log.debug("Compiling Resource... " + file);
        String html = "", sCurrentLine;
        try {
            BufferedReader input = new BufferedReader(new FileReader(multiPlatformResourcesPath(file)));
            while ((sCurrentLine = input.readLine()) != null) {
                html += sCurrentLine;
            }
            HtmlCompressor compressor = new HtmlCompressor();
            String compressedHtml = compressor.compress(html);
            FileWriter output = new FileWriter(multiPlatformResourcesPath(file));
            BufferedWriter bw = new BufferedWriter(output);
            bw.write(compressedHtml);
            bw.close();
        } catch (Exception e) {
            System.out.println("Asset Pipeline Error: " + e.getMessage());
        }
    }

    public String multiPlatformResourcesPath(String file) {
        String resource = System.getProperty("user.dir") +
                "/src/main/resources/" + file;
        return resource.replace("\\", "/");
    }

}
