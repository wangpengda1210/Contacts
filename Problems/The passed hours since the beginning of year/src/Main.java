import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime first = LocalDateTime.of(time.getYear(), 1,
                1, 0, 0, 0);

        System.out.println((time.toEpochSecond(ZoneOffset.UTC) -
                first.toEpochSecond(ZoneOffset.UTC)) / 3600);
    }
}