import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static java.lang.Integer.parseInt;

/**
 * Created by Billy on 5/24/2016.
 */


public class FileDemo {
    public static final String HOME_SUBDIRECTORY = "SubFolder";
    public static final String FILE_NAME = "Zgymbo";
    public static File FOLDER = null;

    public static void main(String[] args) {
        for (int y = 0; y < parseInt(args[0]); y++) {
            FOLDER = folderCreator(args[3].concat(String.valueOf(y + 1)));
            for (int i = 0; i < randomize(parseInt(args[1])); i++) {
                File subfolder = folderCreator(FOLDER, HOME_SUBDIRECTORY.concat(String.valueOf(i + 1)));
                for (int i3 = 0; i3 < randomize(parseInt(args[2])) + 1; i3++) {
                    FileWriter writer = getFileWriter(subfolder, FILE_NAME.concat(String.valueOf(i3++)).concat(".txt"));
                    String string = "";
                    for (int i4 = 65, i5 = 0; i5 < floatingNumber(args[0], args[1], args[2]); i5++) {
                        string = string.concat(String.valueOf((char) i4++));
                    }
                    writeString(writer, string);
                }
            }

        }
    }

    public static Integer randomize(Integer a) {
        return new Random().nextInt(a);
    }

    public static Integer floatingNumber(String str1, String str2, String str3) {
        return (randomize(parseInt(str1)) * randomize(parseInt(str2)) * parseInt(str3) + 1024);
    }

    public static File folderCreator(File parentFolder, String childFolderPath) {
        File file = new File(parentFolder, childFolderPath);
        file.mkdirs();
        return file;
    }

    public static File folderCreator(String folderPath) {
        return folderCreator(new File(folderPath), "");
    }

    public static FileWriter getFileWriter(File subfolder, String targetFile) {
        try (FileWriter writer = new FileWriter(folderCreator(subfolder, targetFile))) {
            return writer;
        } catch (IOException e) {
            throw new RuntimeException("Writer not created");
        }
    }

    public static void writeString(FileWriter writer, String string) {
        try {
            writer.write(string);
        } catch (IOException e) {
            throw new RuntimeException("Writing finished unsuccessful");
        }
    }

}

//randomize(parseIt(args[0])) * randomize(parseIt(args[1])) * parseIt(args[2]) + 1024;