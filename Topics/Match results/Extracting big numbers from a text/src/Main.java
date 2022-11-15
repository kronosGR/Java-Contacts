import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(stringWithNumbers);

        while (matcher.find()) {
            int len = matcher.end() - matcher.start();
            if (len >= 10) {
                System.out.println(matcher.group() + ":" + len);
            }
        }
    }
}