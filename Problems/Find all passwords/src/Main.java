import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile("(password)[\\s:]*[0-9A-Za-z]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        int count = 0;

        while (matcher.find()) {
            Pattern password = Pattern.compile("[0-9A-Za-z]+");
            Matcher passwordMatch = password.matcher(matcher.group());
            passwordMatch.find();
            passwordMatch.find();
            count++;
            System.out.println(passwordMatch.group());
        }

        if (count == 0) {
            System.out.println("No passwords found.");
        }
    }
}