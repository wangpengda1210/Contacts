import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        System.out.println(Math.abs(LocalTime.parse(scanner.nextLine()).toSecondOfDay() -
                LocalTime.parse(scanner.nextLine()).toSecondOfDay()));
    }
}