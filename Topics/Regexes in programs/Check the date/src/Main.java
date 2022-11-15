import java.util.*;

class Date {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();
        String dateRegex = "([1-3][0-9](\\/|\\.|\\-)[0-1][0-2](\\/|\\.|\\-)(19|20)[0-9]{2})|((19|20)[0-9]{2}(\\/|\\.|\\-)[0-1][0-2](\\/|\\.|\\-)[1-3][0-9])";

        System.out.println(date.matches(dateRegex) ? "Yes" : "No");
    }
}