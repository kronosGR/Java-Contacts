package contacts;

import java.time.DateTimeException;
import java.time.LocalDate;

import static contacts.Utils.checkNumber;

public class User extends Contact {

    private String surname;

    private LocalDate birthDate;

    private Gender gender;

    public User() {
    }

    public User(String name, String surname, String number) {
        super(name, number);
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = toDate(birthDate);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = toGender(gender);
    }

    private LocalDate toDate(String date) {
        LocalDate ld = null;
        try {
            ld = LocalDate.parse(date);
        } catch (DateTimeException e) {
            System.out.println("Bad birth date!");
        }
        return ld;
    }

    private Gender toGender(String gender) {
        Gender g = null;
        try {
            g = Gender.valueOf(gender);
        } catch (Exception e) {
            System.out.println("Bad gender!");
        }
        return g;
    }

    public String getInfo() {
        return "Name: " + this.name +
                "\nSurname: " + this.surname +
                "\nBirth date: " + (this.birthDate != null ? this.birthDate.toString() : "[no data]") +
                "\nGender: " + (this.gender != null ? this.gender.toString() : "[no data]") +
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
            case "surname":
                surname = value;
                break;
            case "birthdate":
                birthDate = toDate(value);
                break;
            case "gender":
                gender = toGender(value);
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

    enum Fields {
        NAME, SURNAME, BIRTHDATE, GENDER, NUMBER
    }

}
