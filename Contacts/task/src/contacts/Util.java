package contacts;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static boolean checkNumberValid(String number) {
        Pattern pattern = Pattern.compile("\\+?(\\([0-9A-Za-z]+\\)([ -][0-9A-Za-z]{2,})?|" +
                "[0-9a-zA-Z]+([ -]\\([0-9a-zA-Z]{2,}\\))?|" +
                "[0-9a-zA-Z]+([ -][0-9a-zA-Z]{2,})?)" +
                "([ -][0-9a-zA-Z]{2,})*");

        Matcher matcher = pattern.matcher(number);

        return matcher.matches();

    }

    public static Gender getGender(String genderChoice) {
        Gender gender;
        switch (genderChoice.toUpperCase()) {
            case "F":
                gender = Gender.FEMALE;
                break;
            case "M":
                gender = Gender.MALE;
                break;
            default:
                System.out.println("Bad gender!");
                gender = null;
        }
        return gender;
    }

    public static LocalDate getBirthDate(String birthDateString) {
        LocalDate birthday;
        try {
            birthday = LocalDate.parse(birthDateString);
        } catch (DateTimeParseException e) {
            birthday = null;
            System.out.println("Bad birth date!");
        }
        return birthday;
    }

    public static LocalDateTime getCurrentTime() {
        LocalDateTime timeNow = LocalDateTime.now();
        return LocalDateTime.of(timeNow.getYear(), timeNow.getMonth(),
                timeNow.getDayOfMonth(), timeNow.getHour(), timeNow.getMinute());
    }

    public static void serialize(Object obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
    }

    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

}
