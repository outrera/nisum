package nisum.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {



    public static boolean emailIsValid(final String email, final String patternStr) {

        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean passwordIsValid(final String email, final String patternStr) {

        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
