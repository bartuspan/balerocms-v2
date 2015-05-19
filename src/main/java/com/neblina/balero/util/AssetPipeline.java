/**
 * Balero CMS v2 Project: Proyecto 100% Mexicano de código libre.
 *
 * @author      Anibal Gomez <anibalgomez@icloud.com>
 * @copyright   Copyright (C) 2015 Neblina Software. Derechos reservados.
 * @license     Licencia Pública GNU versión 3 o superior; vea LICENSE.txt
 */

package com.neblina.balero.util;

import com.googlecode.htmlcompressor.compressor.HtmlCompressor;
import org.springframework.context.annotation.Profile;

import java.io.*;

@Profile("prod")
public class AssetPipeline {

    public void compress(String file) {
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
