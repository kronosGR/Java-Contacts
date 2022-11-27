package contacts;

public enum ContactType {
    PERSON("person"), ORGANIZATION("organization");

    private  String name;

    ContactType(String s) {
        this.name = s;
    }

    public boolean equalsName(String n){
        return this.name.equals(n);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
