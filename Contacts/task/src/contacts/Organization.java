package contacts;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static contacts.Utils.checkNumber;

public class Organization extends Contact {
    String address;

    public Organization(String orgName, String address, String number) {
        super(orgName, number);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getInfo() {
        return "Organization name: " + this.name +
                "\nAddress: " + address +
                "\nNumber: " + number +
                "\nTime created: " + Contact.formatDate(creationDateTime) +
                "\nTime last edit: " + Contact.formatDate(lastEditDateTime);
    }

    @Override
    public void setField(String field, String value) {
        switch (field) {
            case "name":
                name = value;
                break;
            case "address":
                address = value;
                break;
            case "number":
                if (!checkNumber(value)) {
                    System.out.println("Wrong number format!");
                    number = "[no number]";
                }
                number = value;
                break;
        }
    }

}
