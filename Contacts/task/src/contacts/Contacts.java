package contacts;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static contacts.Utils.checkNumber;

public class Contacts {
    Scanner sc = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();
    private String filename;
    boolean searchShouldStop = false;


    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = new ArrayList<>(contacts);
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private void count() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    public void serialize() {
        if (filename != null) {
            try {
                Serialization.serialize(contacts, filename);
            } catch (IOException e) {
                System.out.println("Couldn't save contacts.");
            }
        }
    }

    private void remove(String idx) {
        contacts.remove(Integer.parseInt(idx) - 1);
        System.out.println("The record removed!");
        this.serialize();
    }

    private void edit(String record) {

        EditFactory factory = new EditFactory();
        Contact cont = factory.editAccount(contacts.get(Integer.parseInt(record) - 1));
        contacts.set(Integer.parseInt(record) - 1, cont);
        this.serialize();
        System.out.println("Saved");
        System.out.println(cont.getInfo());
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
        if (listCh.equals("back")) {
            return;
        }

        this.info(Integer.parseInt(listCh));

        this.contactAction(listCh);
    }

    private void info(int index) {
        Contact c = contacts.get(index - 1);
        System.out.println(c.getInfo());
    }

    private void search() {
        while (true) {
            if (searchShouldStop){
                return;
            }

            System.out.println("Enter search query: ");
            String query = sc.nextLine();

            Pattern queryP = Pattern.compile(".*" + query + ".*", Pattern.CASE_INSENSITIVE);
            List<Contact> result = new ArrayList<>();
            for (Contact contact : contacts) {
                List<Field> fields = contact.getAllFieldNames();
                for (Field field : fields) {
                    field.setAccessible(true);
                    try {
                        Object value = field.get(contact);
                        if (value != null && queryP.matcher(value.toString()).matches()) {
                            result.add(contact);
                        }
                    } catch (IllegalAccessException e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
            int size = result.size();
            System.out.println("Found " + size + " results: ");
            for (int i = 0; i < size; i++) {
                System.out.println(i + 1 + " " + result.get(i).toString());
            }

            System.out.println("[search] Enter action ([number], back, again):");
            String searchIn = sc.nextLine();
            if (searchIn.equals("back")){
                return;
            }

            if (searchIn.equals("again")){
                continue;
            }

            this.info(Integer.parseInt(searchIn));
            this.contactAction(searchIn);
        }
    }

    private void contactAction(String id){
        while (true){
            System.out.println();
            System.out.println("[record] Enter action (edit, delete, menu): ");
            String ch = sc.nextLine();

            if (ch.equals("menu")){
                searchShouldStop = true;
                return;
            }

            switch (ch){
                case "edit":
                    this.edit(id);
                    break;

                case "delete":
                    this.remove(id);
                    break;
            }
        }
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
                case "search":
                    this.search();
                    break;
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
