package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.regex.Pattern;

public abstract class Contact implements Serializable {

    private String number;
    private final LocalDateTime timeCreated;
    private LocalDateTime timeLastEdit;

    private static final long serialVersionUID = 7L;

    public Contact(String number) {
        this.number = number;
        timeCreated = Util.getCurrentTime();
        timeLastEdit = Util.getCurrentTime();
    }

    public abstract String getFullName();

    public abstract String[] getPossibleFields();

    public abstract void setField(String field, String value);

    public abstract String getField(String field);

    public boolean containsKeyword(String keyword) {
        Pattern pattern = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);

        for (String field : getPossibleFields()) {
            String value = getField(field);

            if (value != null && pattern.matcher(value).find()) {
                return true;
            }
        }

        return false;
    }

    public boolean isPossibleField(String field) {
        return Arrays.asList(getPossibleFields()).contains(field);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getTimeLastEdit() {
        return timeLastEdit;
    }

    public void setTimeLastEdit(LocalDateTime timeLastEdit) {
        this.timeLastEdit = timeLastEdit;
    }

    @Override
    public String toString() {
        return "Number: " + (getNumber() == null ? "[no number]" : getNumber()) +
                "\nTime created: " + getTimeCreated() +
                "\nTime last edit: " + getTimeLastEdit();
    }
}
