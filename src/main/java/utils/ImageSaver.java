package utils;

import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.net.URL;

/**
 * Created by Billy on 6/7/2016.
 */
public class ImageSaver {
    public static final String DIRRECTORY = "D:/Java/Images";

    public static File saveImage(String directory, String currentUrl)  {
        try (InputStream imageReader = new BufferedInputStream(new URL(currentUrl).openStream());
             OutputStream imageWriter = new BufferedOutputStream(new FileOutputStream(DIRRECTORY +
                     File.separator + FilenameUtils.getName(currentUrl)))) {
            int byteRead;
            while ((byteRead = imageReader.read()) != -1) {
                imageWriter.write(byteRead);
            }
            return (new File(directory + File.separator + FilenameUtils.getName(currentUrl)));
        } catch (IOException e) {
            throw new RuntimeException("File is unsaved");
        }

    }
}
