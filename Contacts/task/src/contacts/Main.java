package contacts;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (new File("phonebook.db").exists()) {
            System.out.println("open phonebook.db");
            try {
                contacts = (ArrayList<Contact>) Util.deserialize("phonebook.db");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        label:while (true) {
            System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");
            String choice = scanner.nextLine().toLowerCase();
            switch (choice) {
                case "add":
                    System.out.print("Enter the type (person, organization): ");
                    switch (scanner.nextLine().toLowerCase()) {
                        case "person":
                            addPerson(scanner);
                            System.out.println("The record created!");
                            break;
                        case "organization":
                            addOrg(scanner);
                            System.out.println("The record created!");
                            break;
                        default:
                            System.out.println("Not a correct type");
                    }
                    break;
                case "list":
                    printContactList(contacts);
                    listFunction(scanner);
                    break;
                case "search":
                    searchFunction(scanner);
                    break;
                case "count":
                    System.out.println("The Phone Book has " + contacts.size() + " records.");
                    break;
                case "exit":
                    try {
                        Util.serialize(contacts, "phonebook.db");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break label;
                default:
                    System.out.println("Not a correct option");
                    break;
            }
        }
    }

    private static void searchFunction(Scanner scanner) {
        System.out.print("Enter search query: ");
        String keyword = scanner.nextLine().toLowerCase();
        ArrayList<Contact> result = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.containsKeyword(keyword)) {
                result.add(contact);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No record found");
            return;
        }

        printContactList(result);
        while (true) {
            System.out.print("\n[search] Enter action ([number], back, again): ");
            String option = scanner.nextLine().toLowerCase();
            try {
                int id = Integer.parseInt(option);
                if (id > result.size() || id <= 0) {
                    System.out.println("Not a correct id");
                } else {
                    recordFunction(scanner, result.get(id - 1));
                    return;
                }
            } catch (NumberFormatException e) {
                switch (option) {
                    case "back":
                        return;
                    case "again":
                        searchFunction(scanner);
                        return;
                    default:
                        System.out.println("Not a correct option");
                }
            }
        }
    }

    private static void listFunction(Scanner scanner) {
        if (contacts.size() == 0) {
            System.out.println("No record to show");
            return;
        }

        while (true) {
            System.out.print("\n[list] Enter action ([number], back): ");
            String input = scanner.nextLine().toLowerCase();
            try {
                int id = Integer.parseInt(input);
                if (id > contacts.size() || id <= 0) {
                    System.out.println("Not a correct id");
                } else {
                    recordFunction(scanner, contacts.get(id - 1));
                    return;
                }
            } catch (NumberFormatException e) {
                if ("back".equals(input)) {
                    return;
                } else {
                    System.out.println("Not a correct option");
                }
            }
        }
    }

    private static void recordFunction(Scanner scanner, Contact contact) {
        System.out.println(contact);

        while (true) {
            System.out.print("\n[record] Enter action (edit, delete, menu): ");
            switch (scanner.nextLine().toLowerCase()) {
                case "menu":
                    return;
                case "edit":
                    String options = Arrays.toString(contact.getPossibleFields())
                            .replace('[', '(')
                            .replace(']', ')');
                    System.out.print("Select a field " + options + ": ");
                    String field = scanner.nextLine().toLowerCase();
                    if (!contact.isPossibleField(field)) {
                        System.out.println("Not correct option");
                        break;
                    } else {
                        System.out.print("Enter " + field + ": ");
                        contact.setField(field, scanner.nextLine());
                        contact.setTimeLastEdit(Util.getCurrentTime());
                        System.out.println("Saved");
                        System.out.println(contact);
                    }
                    break;
                case "delete":
                    contacts.remove(contact);
                    System.out.println("The record deleted!");
                    return;
                default:
                    System.out.println("Not a correct option");
            }
        }
    }

    private static void addPerson(Scanner scanner) {
        System.out.print("Enter the name of the person: ");
        String name = scanner.nextLine();
        System.out.print("Enter the surname of the person: ");
        String surname = scanner.nextLine();
        System.out.print("Enter the birth date: ");
        String birthDateString = scanner.nextLine();
        LocalDate birthday = Util.getBirthDate(birthDateString);
        System.out.print("Enter the gender (M, F): ");
        String genderChoice = scanner.nextLine().toUpperCase();
        Gender gender = Util.getGender(genderChoice);

        System.out.print("Enter the number: ");
        String number = scanner.nextLine();

        if (!Util.checkNumberValid(number)) {
            System.out.println("Wrong number format!");
            number = null;
        }

        contacts.add(new Person(name, surname, number, birthday, gender));
    }

    private static void addOrg(Scanner scanner) {
        System.out.print("Enter the organization name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the address: ");
        String address = scanner.nextLine();
        System.out.print("Enter the number: ");
        String number = scanner.nextLine();

        if (!Util.checkNumberValid(number)) {
            System.out.println("Wrong number format!");
            number = null;
        }

        contacts.add(new Organization(name, address, number));
    }

    private static void printContactList(ArrayList<Contact> list) {
        int i = 1;
        for (Contact contact : list) {
            System.out.println(i + ". " + contact.getFullName());
            i++;
        }
    }

}
