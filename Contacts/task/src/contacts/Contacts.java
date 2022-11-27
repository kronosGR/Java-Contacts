package contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static contacts.Utils.checkNumber;

public class Contacts {
    Scanner sc = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();
    private String filename;


    public void setContacts(ArrayList<Contact> contacts){
        this.contacts = new ArrayList<>(contacts);
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private void count() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    public void serialize(){
        if (filename!= null){
            try {
                Serialization.serialize(contacts,filename);
            } catch (IOException e){
                System.out.println("Couldn't save contacts.");
            }
        }
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
        Contact cont = addFactory.createContact();
        if (cont != null) {
            contacts.add(cont);
            System.out.println("The record added");
            serialize();
        }
    }

    private void list() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(i + 1 + ". " + contacts.get(i).toString());
        }

        System.out.println("[list] Enter action ([number], back): ");
        String listCh = sc.nextLine();
        if (listCh.equals("back")){
            return;
        }

        this.info(Integer.parseInt(listCh));
    }

    private void info(int index) {
        Contact c = contacts.get(index - 1);
        System.out.println(c.getInfo());
    }

    public void getMenu() {
        while (true) {
            System.out.println();
            System.out.println("[menu] Enter action (add, list, search, count, exit): ");

            String choice = sc.nextLine();
            if (choice.equals("exit")) {
                break;
            }

            switch (choice) {
                case "count":
                    this.count();
                    break;
//                case "edit":
//                    this.edit();
//                    break;
//                case "remove":
//                    this.remove();
//                    break;
                case "add":
                    this.add();
                    break;
//                case "info":
//                    this.info();
//                    break;
                case "list":
                    this.list();
            }

        }
    }

}
