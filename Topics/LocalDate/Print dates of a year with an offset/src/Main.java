import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int days = sc.nextInt();

        LocalDate date = LocalDate.parse(input);

        for (int i = 0; i < days; i++) {
            System.out.println(date.toString());
            int year = date.getYear();
            date = date.plusDays(days);
            if (year != date.getYear()) {
                break;
            }
        }
    }
}