package model;

public class Report {
    private int id;
    private String firstName;
    private String lastName;
    private String operation;
    private String dateOfCreation;
    public Report(){

    }
    public Report(int id, String firstName, String lastName, String operation, String dateOfCreation){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.operation = operation;
        this.dateOfCreation = dateOfCreation;
    }

    public String toString(){
        return "The employee " + id + " " + firstName + " " + lastName + " performed the operation " + operation + ", " + dateOfCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
