package contacts;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.reflect.Modifier.isProtected;

public abstract class Contact implements Serializable {

    protected String name;
    protected String number;

    protected LocalDateTime creationDateTime;
    protected LocalDateTime lastEditDateTime;

    private static final long serialVersionUID = 123;

    public Contact(){
        this.creationDateTime = LocalDateTime.now();
        this.lastEditDateTime = LocalDateTime.now();
    }

    public Contact (String name, String number){
        this();
        this.name = name;
        this.number = number;
    }

    public static String formatDate(LocalDateTime date){
        DateTimeFormatter outputFormatter = DateTimeFormatter
                .ofPattern("uuuu-MM-dd'T'HH:mm");
        return date.format(outputFormatter);
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

    public final List<Field> getAllFieldNames() {
        final List<Field> allFields = new ArrayList<>(30);
        Collections.addAll(allFields, getClass().getDeclaredFields());
        Class<?> currentClass = getClass().getSuperclass();
        while (null != currentClass) {
            final Field[] declaredFields = Arrays
                    .stream(currentClass.getDeclaredFields())
                    .filter(filed -> isProtected(filed.getModifiers()))
                    .toArray(Field[]::new);
            Collections.addAll(allFields, declaredFields);
            currentClass = currentClass.getSuperclass();
        }
        return allFields;
    }
}
