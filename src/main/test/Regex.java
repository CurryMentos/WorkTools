import java.util.regex.Pattern;

/**
 * Created by zengyouzu on 2020-04-26.
 */
public class Regex {
    public static void main(String args[]) {
        String content = "19126";

        String pattern = "(\\d*)";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("是否匹配:" + isMatch);
    }
}
