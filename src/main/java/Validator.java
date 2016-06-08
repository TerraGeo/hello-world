import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Billy on 6/7/2016.
 */
public class Validator {
    public static String validator(String desirableString){
        Pattern pat = Pattern.compile(".*jpg");
        Matcher matcher = pat.matcher(desirableString);
        matcher.find();
        return matcher.group();
    }
}
