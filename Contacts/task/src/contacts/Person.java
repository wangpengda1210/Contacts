package contacts;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Person extends Contact {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private Gender gender;

    public Person(String name, String surname, String number, LocalDate birthDate, Gender gender) {
        super(number);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nSurname: " + getSurname() + "\nBirth date: " +
                (getBirthDate() == null ? "[no data]" : getBirthDate()) + "\nGender: " +
                (getGender() == null ? "[no data]" : getGender() == Gender.MALE ? "M" : "F") +
                "\n" + super.toString();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String getFullName() {
        return getName() + " " + getSurname();
    }

    @Override
    public String[] getPossibleFields() {
        return new String[] {"name", "surname", "birth", "gender", "number"};
    }

    @Override
    public void setField(String field, String value) {
        switch (field) {
            case "name":
                setName(value);
                break;
            case "surname":
                setSurname(value);
                break;
            case "birth":
                setBirthDate(Util.getBirthDate(value));
                break;
            case "gender":
                setGender(Util.getGender(value));
                break;
            case "number":
                if (!Util.checkNumberValid(value)) {
                    System.out.println("Wrong number format!");
                    value = null;
                }
                setNumber(value);
                break;
        }
    }

    @Override
    public String getField(String field) {
        switch (field) {
            case "name":
                return getName();
            case "surname":
                return getSurname();
            case "birth":
                return getBirthDate() != null ? getBirthDate().toString() : null;
            case "gender":
                return getGender() == Gender.FEMALE ? "F" :
                        getGender() == Gender.MALE ? "M" : null;
            case "number":
                return getNumber();
            default:
                return null;
        }
    }

}
