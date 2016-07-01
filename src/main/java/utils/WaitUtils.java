package utils;

/**
 * Created by Billy on 6/29/2016.
 */
public class WaitUtils {
    public static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
