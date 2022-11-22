package contacts;

import java.util.Scanner;

public class EditFactory {
    Scanner sc = new Scanner(System.in);

    public Contact editAccount(Contact cont) {
        String field;
        String value;

        switch (cont.getClass().toString()) {
            case "User":
                User tmp = (User) cont;
                System.out.println("Select a field (name, surname, birth, gender, number): ");
                field = sc.nextLine();
                System.out.println("Enter " + field + " :");
                value = sc.nextLine();
                tmp.setField(field, value);
                return tmp;
            case "Organization":
                Organization tmpO = (Organization) cont;
                System.out.println("Select a field (address, number): ");
                field = sc.nextLine();
                System.out.println("Enter " + field + " :");
                value = sc.nextLine();
                tmpO.setField(field, value);
                return tmpO;
            default:
                return null;
        }

    }
}
