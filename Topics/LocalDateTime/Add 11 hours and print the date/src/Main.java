import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        LocalDateTime dt = LocalDateTime.parse(in);
        dt = dt.plusHours(11);
        System.out.println(LocalDate.of(dt.getYear(), dt.getMonth(), dt.getDayOfMonth()));
    }
}