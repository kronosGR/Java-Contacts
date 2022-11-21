import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        LocalDate date = LocalDate.ofYearDay(arr[0], arr[1]);
        System.out.println(date.getDayOfMonth() == date.lengthOfMonth());

    }
}