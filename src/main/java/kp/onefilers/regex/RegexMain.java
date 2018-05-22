package kp.onefilers.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {

    public static void main(String[] args) {


        Pattern pat = Pattern.compile("(\\d{3}ABC)(_\\d{3})");
        String str = "123ABC_123";

        System.out.println(str.matches("(\\d{3})(ABC)(_\\d{3})"));

        Matcher mat = pat.matcher(str);
        mat.find();

        System.out.println(mat.group(1)+"-XYZ"+mat.group(2));
    }
}
