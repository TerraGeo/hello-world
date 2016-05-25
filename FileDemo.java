import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Billy on 5/24/2016.
 */
public class FileDemo {
    public static void main(String[] args) {
        String homeSubDirectory = "SubFolder";
        String filename = "Zgymbo";
        boolean bool = false;
        File folder = null;
        Random random = new Random();
        for (int y = 0; y < Integer.parseInt(args[0]); y++) {
            try {
                folder = new File(args[3].concat(String.valueOf(y + 1)));
                bool = folder.mkdir();
                System.out.println(bool);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            System.out.println(y + " " + args[3]);
            for (int i = 0; i < random.nextInt(Integer.parseInt(args[1])); i++) {
                File subfolder = new File(folder, homeSubDirectory.concat(String.valueOf(i + 1)));
                subfolder.mkdir();
                for (int i3 = 0; i3 < random.nextInt(Integer.parseInt(args[2])) + 1; i3++) {
                    try {
                        FileWriter writer = new FileWriter(new File(subfolder, filename.concat(String.valueOf(i3++)).concat(".txt")));
                        String string = "";
                        for (int i4 = 65, i5 = 0; i5 < random.nextInt(Integer.parseInt(args[0])) * random.nextInt(Integer.parseInt(args[1])) * Integer.parseInt(args[2]) + 1024; i5++) {
                            string = string.concat(String.valueOf((char) i4++));
                        }
                        writer.write(string);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
