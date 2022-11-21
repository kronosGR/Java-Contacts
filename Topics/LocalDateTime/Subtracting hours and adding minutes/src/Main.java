import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String din = sc.nextLine();
        int[] ar = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        LocalDateTime dt = LocalDateTime.parse(din);

        System.out.println(dt.minusHours(ar[0]).plusMinutes(ar[1]));
    }
}