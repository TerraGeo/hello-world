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
        for (int y = 0; y < parseIt(args[0]); y++) {
            try {
                folder = new File(args[3].concat(String.valueOf(y + 1)));
                bool = dirCreate(folder);
                System.out.println(bool);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            System.out.println(y + " " + args[3]);
            for (int i = 0; i < randomize(parseIt(args[1])); i++) {
                File subfolder = new File(folder, homeSubDirectory.concat(String.valueOf(i + 1)));
                dirCreate(subfolder);
                for (int i3 = 0; i3 < randomize(parseIt(args[2])) + 1; i3++) {
                    try {
                        FileWriter writer = new FileWriter(new File(subfolder, filename.concat(String.valueOf(i3++)).concat(".txt")));
                        String string = "";
                        for (int i4 = 65, i5 = 0; i5 < floatingNumb(args[0], args[1], args[2]); i5++) {
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
    public static Integer randomize(Integer a) {
        Random random1 = new Random();
        return random1.nextInt(a);
    }
    public static Integer parseIt(String str){
        return Integer.parseInt(str);
    }
    public static Integer floatingNumb(String str1, String str2, String str3){
        return  randomize(parseIt(str1)) * randomize(parseIt(str2)) * parseIt(str3) + 1024;
    }
    public  static boolean dirCreate(File file){
        return file.mkdir();
    }
}
//randomize(parseIt(args[0])) * randomize(parseIt(args[1])) * parseIt(args[2]) + 1024;