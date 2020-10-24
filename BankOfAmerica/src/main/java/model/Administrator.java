package model;

public class Administrator extends User {

    public Administrator(String username, String password) {
        super(username, password);
        this.setUsername("administrator");
    }
}
