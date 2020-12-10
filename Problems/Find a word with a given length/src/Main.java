import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile("([^A-Za-z]|\\b)[A-Za-z]{" + size + "}([^A-Za-z]|\\b)");
        Matcher matcher = pattern.matcher(line);
        System.out.println(matcher.find() ? "YES" : "NO");
    }
}