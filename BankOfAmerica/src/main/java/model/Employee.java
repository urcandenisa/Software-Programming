package model;

public class Employee extends User {

    private int id;
    private String firstName;
    private String lastName;
    private String personalNumericalCode;

    public Employee(){

    }
    public Employee(int id, String firstName, String lastName, String personalNumericalCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumericalCode = personalNumericalCode;
    }

    public Employee(int id, String firstName, String lastName, String personalNumericalCode, String username, String password) {
        super(username, password);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumericalCode = personalNumericalCode;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + personalNumericalCode + " " +
                this.getUsername() + " " +
                this.getPassword();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalNumericalCode() {
        return personalNumericalCode;
    }

    public void setPersonalNumericalCode(String personalNumericalCode) {
        this.personalNumericalCode = personalNumericalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
