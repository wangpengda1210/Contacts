import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(00|01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20" +
                "|21|22|23):[0-5][0-9]";

        String time = scanner.nextLine();
        System.out.println(time.matches(regex) ? "YES" : "NO");
    }
}