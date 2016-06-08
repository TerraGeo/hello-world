import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.net.URL;

/**
 * Created by Billy on 6/7/2016.
 */
public class ImageSaver {
    public static final String DIRRECTORY = "D:/Java/Images";

    public File saveImage(String directory, String currentUrl) throws IOException {
        URL url = new URL(currentUrl);
        try (InputStream imageReader = new BufferedInputStream(url.openStream());
             OutputStream imageWriter = new BufferedOutputStream(new FileOutputStream(DIRRECTORY +
                     File.separator + FilenameUtils.getName(currentUrl)))) {
            int byteRead;
            while ((byteRead = imageReader.read()) != -1) {
                imageWriter.write(byteRead);
            }
            return (new File(directory + File.separator + FilenameUtils.getName(currentUrl)));
        }

    }
}
