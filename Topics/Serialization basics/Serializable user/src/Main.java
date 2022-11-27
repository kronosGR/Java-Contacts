import java.io.Serializable;

class User implements Serializable {
    String name;
    private transient String password;
    private static final long serialVersionUID = 1L;
}