import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        LocalDateTime dt = LocalDateTime.parse(in);
        LocalDateTime dt2 = LocalDateTime.of(dt.getYear(), 1, 1, 0,0);
        System.out.println(dt2.until(dt, ChronoUnit.HOURS));

    }
}