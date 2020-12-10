import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalDateTime time = LocalDateTime.parse(scanner.nextLine())
                .plusMinutes(scanner.nextLong());
        System.out.println(time.getYear() + " " + time.getDayOfYear() + " " + time.toLocalTime());
    }
}