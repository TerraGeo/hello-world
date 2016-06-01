import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ImageDownloader {
    public static final String HOME_DIRECTORY = "D:\\";
    public static final String CURRENT_URL = "http://wallpaperswide.com/download/burning_poker_joker-wallpaper-1680x1050.jpg";
    public static final File IM2 = new File("D:\\burning_poker_joker-wallpaper-1680x1050.jpg");


    public File downloadImage(String sourceUrl, String targetDirectory) throws IOException {
        URL imageUrl = new URL(sourceUrl);
        try (InputStream imageReader = new BufferedInputStream(imageUrl.openStream());
             OutputStream imageWriter = new BufferedOutputStream(new FileOutputStream(targetDirectory
                     + File.separator + FilenameUtils.getName(sourceUrl)))) {
            int readByte;
            while ((readByte = imageReader.read()) != -1) {
                imageWriter.write(readByte);
            }
            return new File(targetDirectory + File.separator + FilenameUtils.getName(sourceUrl));
        }
    }
    public boolean compareImage(File fileA, File fileB) {
         try (BufferedReader br1 = new BufferedReader(new FileReader(fileA));
            BufferedReader br2 = new BufferedReader(new FileReader(fileB))){
            return readFiles(br1).equals(readFiles(br2));
        } catch (IOException e) {
            throw new RuntimeException("Files are invalid");
        }
    }

    private List<Integer> readFiles(BufferedReader bufferedReader) throws IOException {
        List<Integer> fileBytes = new ArrayList<>();
        int _byte;
        while ((_byte = bufferedReader.read()) != -1) {
            fileBytes.add(_byte);
        }
        return fileBytes;
    }
}
