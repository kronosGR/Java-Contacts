package contacts;

import java.util.ArrayList;
import java.util.Scanner;

import static contacts.Utils.checkNumber;

public class Contacts {
    Scanner sc = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();


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

        contacts.remove(Integer.parseInt(record) - 1);
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

        EditFactory factory = new EditFactory();
        Contact cont = factory.editAccount(contacts.get(Integer.parseInt(record) - 1));
        contacts.set(Integer.parseInt(record) - 1, cont);

        System.out.println("The record updated!");
    }

    private void add() {
        AddFactory addFactory = new AddFactory();
        contacts.add(addFactory.createContact());
        System.out.println("The record added");
    }

    private void list() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(i + 1 + ". " + contacts.get(i).toString());
        }
    }

    private void info() {
        this.list();
        System.out.println("Enter index to show info:");
        String index = sc.nextLine();
        Contact c = contacts.get(Integer.parseInt(index) - 1);
        System.out.println(c.getInfo());
    }

    public void getMenu() {
        while (true) {
            System.out.println();
            System.out.println("Enter action (add, remove, edit, count, info, exit):");

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
                case "info":
                    this.info();
                    break;
            }

        }
    }

}
