import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String time1 = sc.nextLine();
        String[] time2 = sc.nextLine().split(" ");
        int hours = Integer.parseInt(time2[0]);
        int mins = Integer.parseInt(time2[1]);


        LocalTime time = LocalTime.parse(time1);
        time = time.minusHours(hours);
        time = time.minusMinutes(mins);
        System.out.println(time);

    }
}