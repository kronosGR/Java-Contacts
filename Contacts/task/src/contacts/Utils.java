package contacts;

import java.time.LocalDate;

public class Utils {
    public static boolean checkNumber(String number) {
        return number.matches("^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*");
    }

}
