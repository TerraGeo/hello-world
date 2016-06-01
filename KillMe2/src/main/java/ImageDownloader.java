
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.*;
import java.net.URL;

import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;

public class ImageDownloader {
    public static final String HOME_DIRECTORY = "D:/Java/Docs";
    public static final String CURRENT_URL = "http://wallpaperswide.com/download/burning_poker_joker-wallpaper-1680x1050.jpg";
    public static final File IM2 = new File("D:/Java/DocsCopy/burning_poker_joker-wallpaper-1680x1050.jpg");


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
    public int compareImage(File fileA, File fileB) {
        int percentage = 0;
        try {
            // take buffer data from both image files //
            BufferedImage biA = ImageIO.read(fileA);
            DataBuffer dbA = biA.getData().getDataBuffer();
            int sizeA = dbA.getSize();
            BufferedImage biB = ImageIO.read(fileB);
            DataBuffer dbB = biB.getData().getDataBuffer();
            int sizeB = dbB.getSize();
            int count = 0;
            // compare data-buffer objects //
            if (sizeA == sizeB) {
                for (int i = 0; i < sizeA; i++) {
                    if (dbA.getElem(i) == dbB.getElem(i)) {
                        count = count + 1;
                    }
                }
                percentage = (count * 100) / sizeA;
            } else {
                System.out.println("Both the images are not of same size");
            }
        } catch (Exception e) {
            System.out.println("Failed to compare image files ...");
        }
        return percentage;
    }
}