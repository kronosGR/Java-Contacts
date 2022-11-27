package contacts;

import java.util.Scanner;

import static contacts.Utils.checkNumber;

public class AddFactory {
    Scanner sc = new Scanner(System.in);

    public Contact createContact() {
        Contact contact = null;
        String number;
        String name;

        System.out.println("[add] Enter the type (person, organization) or back: :");
        String in = sc.nextLine();

        switch (in) {
            case "person":
                User us = new User();
                System.out.println("Enter the name:");
                name = sc.nextLine();
                us.setName(name);
                System.out.println("Enter the surname:");
                String surname = sc.nextLine();
                us.setSurname(surname);
                System.out.println("Enter the birth date:");
                String birthDate = sc.nextLine();
                us.setBirthDate(birthDate);
                System.out.println("Enter the gender (M, F)");
                String gender = sc.nextLine();
                us.setGender(gender);
                System.out.println("Enter the number:");
                number = sc.nextLine();
                if (!checkNumber(number)) {
                    System.out.println("Wrong number format!");
                    number = "[no number]";
                }
                us.setNumber(number);
                contact = us;
                break;
            case "organization":
                System.out.println("Enter the organization name:");
                name = sc.nextLine();
                System.out.println("Enter the address:");
                String address = sc.nextLine();
                System.out.println("Enter the number:");
                number = sc.nextLine();
                if (!checkNumber(number)) {
                    System.out.println("Wrong number format!");
                    number = "[no number]";
                }
                contact = new Organization(name, address, number);
                break;
            case "back":
                return null;
        }

        return contact;
    }
}
