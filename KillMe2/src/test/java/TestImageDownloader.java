import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

// Created by Billy on 5/31/2016.


public class TestImageDownloader {
    public File file;

    @Test
    public void testImageDownloader() throws IOException {
        ImageDownloader imD1 = new ImageDownloader();
        file = imD1.downloadImage(ImageDownloader.CURRENT_URL,
                ImageDownloader.HOME_DIRECTORY);
        Assert.assertTrue(imD1.compareImage(file, ImageDownloader.IM2));
    }

    @After
    public void deleteImage() {
        file.delete();
    }
}
