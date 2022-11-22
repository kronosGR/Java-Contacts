package contacts;

import java.time.LocalDateTime;

public abstract class Contact {

    protected String name;
    protected String number;

    protected LocalDateTime creationDateTime;
    protected LocalDateTime lastEditDateTime;

    public Contact(){

    }
    public Contact (String name, String number){
        this.name = name;
        this.number = number;
        this.creationDateTime = LocalDateTime.now();
        this.lastEditDateTime = LocalDateTime.now();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getLastEditDateTime() {
        return lastEditDateTime;
    }

    public void setLastEditDateTime(LocalDateTime lastEditDateTime) {
        this.lastEditDateTime = lastEditDateTime;
    }

    public String getInfo() {
        return null;
    }

    abstract public void setField(String field, String value);
}
