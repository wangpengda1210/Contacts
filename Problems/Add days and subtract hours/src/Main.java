import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println(LocalDateTime.parse(scanner.next())
                .plusDays(scanner.nextLong()).minusHours(scanner.nextLong()));
    }
}