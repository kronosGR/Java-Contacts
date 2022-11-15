package contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class Contacts {
    Scanner sc = new Scanner(System.in);
    ArrayList<User> contacts = new ArrayList<>();

    private boolean checkNumber(String number) {
        return number.matches("^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*");
    }

    private void count() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    private void remove() {
        if (contacts.size() == 0) {
            System.out.println("No records to remove!");
            return;
        }

        this.list();
        System.out.println("Select record:");
        String record = sc.nextLine();

        contacts.remove(Integer.parseInt(record)  - 1);
        System.out.println("The record removed!");
    }

    private void edit() {
        if (contacts.size() == 0) {
            System.out.println("No records to edit!");
            return;
        }

        this.list();
        System.out.println("Select record:");
        String record = sc.nextLine();
        System.out.println("Select a field (name, surname, number):");
        String field = sc.nextLine();

        switch (field) {
            case "name":
                System.out.println("Enter name:");
                contacts.get(Integer.parseInt(record) - 1).setName(sc.nextLine());
                break;
            case "surname":
                System.out.println("Enter surname:");
                contacts.get(Integer.parseInt(record)  - 1).setSurname(sc.nextLine());
                break;
            case "number":
                System.out.println("Enter number:");
                String num =sc.nextLine();
                if (!checkNumber(num)) {
                    System.out.println("Wrong number format!");
                    num = "[no number]";
                }
                contacts.get(Integer.parseInt(record)  - 1).setNumber(num);
                break;
        }

        System.out.println("The record updated!");
    }

    private void add() {
        System.out.println("Enter the name:");
        String name = sc.nextLine();
        System.out.println("Enter the surname:");
        String surname = sc.nextLine();
        String number;
        System.out.println("Enter the number:");
        number = sc.nextLine();
        if (!checkNumber(number)) {
            System.out.println("Wrong number format!");
            number = "[no number]";
        }
        contacts.add(new User(name, surname, number));
        System.out.println("The record added");
    }

    private void list() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(i + 1 + ". " + contacts.get(i).toString());
        }
    }

    public void getMenu() {
        while (true) {
            System.out.println("Enter action (add, remove, edit, count, list, exit):");

            String choice = sc.nextLine();
            if (choice.equals("exit")) {
                break;
            }

            switch (choice) {
                case "count":
                    this.count();
                    break;
                case "edit":
                    this.edit();
                    break;
                case "remove":
                    this.remove();
                    break;
                case "add":
                    this.add();
                    break;
                case "list":
                    this.list();
                    break;
            }

        }
    }

}
