import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        int b = inputStream.read();
        while (b != -1) {
            byte b1 = (byte) b;
            System.out.print(b1);
            b = inputStream.read();
        }
    }
}