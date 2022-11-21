package contacts;

public class User extends Contact{

    private String name;
    private String surname;

    public User(String name, String surname, String number) {
        super(number);
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + number ;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
