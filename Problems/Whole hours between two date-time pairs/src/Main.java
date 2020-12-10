import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalDateTime time1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime time2 = LocalDateTime.parse(scanner.nextLine());

        System.out.println(Math.abs(time1.toEpochSecond(ZoneOffset.UTC) -
                time2.toEpochSecond(ZoneOffset.UTC)) / 3600);
    }
}