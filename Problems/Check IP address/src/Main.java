import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.next();

        String pattern = "((1?\\d{1,2}|2[0-4]\\d|25[0-5])\\.){3}(1?\\d{1,2}|2[0-4]\\d|25[0-5])";

        System.out.println(ip.matches(pattern) ? "YES" : "NO");
    }
}