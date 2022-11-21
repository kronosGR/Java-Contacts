import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        LocalDate date = LocalDate.parse(input);
        date = date.plusDays(14);
        System.out.println(date.toString());
    }
}