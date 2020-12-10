import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String pwd = scanner.nextLine();

        System.out.println(pwd.matches(".*[A-Z].*") &&
                pwd.matches(".*[a-z].*") &&
                pwd.matches(".*\\d.*") &&
                pwd.matches(".{12,}") ? "YES" : "NO");
    }
}