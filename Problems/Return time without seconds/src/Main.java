import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        LocalTime time = LocalTime.parse(new Scanner(System.in).nextLine());
        System.out.println(time.minusSeconds(time.getSecond()));
    }
}