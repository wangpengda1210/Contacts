import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), 1);
        date = date.withDayOfMonth(date.getMonth().length(date.isLeapYear()) - scanner.nextInt() + 1);
        System.out.println(date);
    }
}