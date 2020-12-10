import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), 1);
        Month month = date.getMonth();
        while (date.getMonth() == month) {
            if (date.getDayOfWeek().toString().equals("MONDAY")) {
                System.out.println(date);
            }
            date = date.plusDays(1);
        }
    }
}