import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.nextLine());
        int gap = scanner.nextInt();
        int year = date.getYear();

        while (date.getYear() == year) {
            System.out.println(date);
            date = date.plusDays(gap);
        }
    }
}