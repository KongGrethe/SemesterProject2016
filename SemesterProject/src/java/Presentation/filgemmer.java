/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.Part;

/**
 *
 * @author Lasse
 */
public class filgemmer {

    public void savePartAs(Part inFile, String targetName) throws IOException {
        if (inFile.getSize() > 0) {
            OutputStream out = null;
            InputStream fileContent = null;

            try {
                out = new FileOutputStream(new File("C:/mappe/" + targetName));
                fileContent = inFile.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
            } catch (FileNotFoundException fne) {
                System.out.println(fne.getMessage());
            } finally {
                if (out != null) {
                    out.close();
                }
                if (fileContent != null) {
                    fileContent.close();
                }
            }
        }
    }

    public String getCleanFilename(String x) {
        return x.substring(x.lastIndexOf("\\") + 1);
    }
}
