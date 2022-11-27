package contacts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    private static Contacts  contacts = new Contacts();
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the name of the person");
//        String name = sc.nextLine();
//        System.out.println("Enter the surname of the person");
//        String surname = sc.nextLine();
//        System.out.println("Enter the number");
//        String number = sc.nextLine();
//
//        System.out.println("A record created!");
//        System.out.println("A Phone Book with a single record created!");

        // load contacts
        load(args);

        contacts.getMenu();
    }

    private static void load(String[] args) {
        if (args.length > 0) {
            String fileName = args[0];
            contacts.setFilename(fileName);

            try {
                ArrayList<Contact> allContacts= (ArrayList<Contact>) Serialization.deserialize(fileName);
                contacts.setContacts(allContacts);
                System.out.println("Loaded contacts from file: " + fileName);
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("No contacts loaded. New contacts will be saved to \"" + fileName + "\"");
                System.out.println();
            }
        }
    }
}
