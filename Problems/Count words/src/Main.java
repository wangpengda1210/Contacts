import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        int count = 0;
        boolean isSpace = true;
        int charNumber = reader.read();
        while (charNumber != -1) {
            char c = (char) charNumber;
            if (c != ' ' && isSpace) {
                isSpace = false;
                count++;
            } else if (c == ' '){
                isSpace = true;
            }
            charNumber = reader.read();
        }
        reader.close();
        System.out.println(count);
    }
}