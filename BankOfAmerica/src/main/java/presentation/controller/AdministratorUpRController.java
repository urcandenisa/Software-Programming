package presentation.controller;

import businessLogic.EmployeeBusiness;
import businessLogic.ReportBusiness;
import model.Employee;
import model.Report;
import presentation.view.AdministratorRead;
import presentation.view.AdministratorUpdateRegister;
import presentation.view.AdministratorUpdateDelete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.InputMismatchException;
import java.util.List;

public class AdministratorUpRController {
    AdministratorRead readView;
    AdministratorUpdateDelete upView;
    AdministratorUpdateRegister updateView;
    EmployeeBusiness model;
    ReportBusiness reportBusiness;
    public AdministratorUpRController(AdministratorRead readView, AdministratorUpdateRegister updateView, AdministratorUpdateDelete upView, ReportBusiness reportBusiness, EmployeeBusiness model){
        this.readView = readView;
        this.upView = upView;
        this.updateView = updateView;
        this.model = model;
        this.reportBusiness = reportBusiness;
        updateView.addActionListener(new ButtonListener());
        updateView.addFocusListener(new TextListener());
    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == updateView.getBack()){
                updateView.setVisible(false);
                updateView.resetValues();
                readView.resetValues();
                readView.setVisible(true);
            }
            if(e.getSource() == updateView.getSubmit()){
                List<Employee> employeeList = model.selectAll();

                String firstName = "";
                String lastName = "";
                String personalNumericalCode = "";
                String username = "";
                String password = "";
                boolean first_name = false;
                boolean last_name = false ;
                boolean personal_numerical_code = false;
                boolean password_ = false;
                boolean username_ = false;
                try{
                    firstName = updateView.getFirstName().getText();//ce s a scris de la tastatura
                    lastName = updateView.getLastName().getText();
                    personalNumericalCode = updateView.getPersonalNumericalCode().getText();
                    username = updateView.getUsername().getText();
                    password = updateView.getPassword().getText();
                    first_name = firstName.compareTo("first name") == 0;
                    last_name = lastName.compareTo("last name") == 0 || lastName.compareTo("") == 0;
                    personal_numerical_code = personalNumericalCode.compareTo("personal numerical code") == 0 || personalNumericalCode.compareTo("") == 0;
                    username_ = username.compareTo("username") == 0 || username.compareTo("") == 0;
                    password_ = password.compareTo("password") == 0 ||
                            password.compareTo("") == 0;
                }catch (InputMismatchException ex){
                    ex.printStackTrace();
                }
                if(updateView.getProceed().compareTo("Complete at least one field in order to proceed")==0) {
                    if (first_name && last_name && personal_numerical_code && username_ && password_) {
                        //this means no field has been updated
                        updateView.setCompleteOneField("Please complete at least one field!");
                    } else {
                        int id = employeeList.size();
                        Employee employee = (Employee) upView.getFoundEmployees().getModel().getElementAt(0);
                        firstName = employee.getFirstName();
                        lastName = employee.getLastName();
                        personalNumericalCode = employee.getPersonalNumericalCode();
                        username = employee.getUsername();
                        password = employee.getPassword();
                        if (first_name == false && firstName.compareTo("") != 0) {
                            // vezi ca faci update la ala ce era in administratorUpDelcontroller
                            firstName = updateView.getFirstName().getText();
                        }
                        if (last_name == false) {
                            lastName = updateView.getLastName().getText();
                        }
                        if (personal_numerical_code == false) {
                            personalNumericalCode = updateView.getPersonalNumericalCode().getText();
                        }
                        if (username_ == false) {
                            username = updateView.getUsername().getText();
                        }
                        if (password_ == false) {
                            password = updateView.getPassword().getText();
                        }
                        model.updateEmployee(firstName, lastName, personalNumericalCode, username, password, id);
                        updateView.resetValues();
                        updateView.setSucces("Successfully updated! ");
                    }
                }else{
                    if(first_name || last_name || username_ || password_ || personal_numerical_code){
                        updateView.setCompleteOneField("             Please complete all fields!");
                    }else{
                        if(firstName.compareTo("") == 0){
                            updateView.setCompleteOneField("              Please complete all fields!");
                        }else{
                            int newId= ReflectionExample.retrieveId(employeeList);
                            newId++;
                            Employee employee = new Employee(newId, firstName, lastName, personalNumericalCode, username, password);
                            System.out.println(employee.toString());
                            model.addEmployee(employee);
                            updateView.resetValues();
                            updateView.setSucces("   Successfully added! ");

                        }
                    }

                }
            }
        }
    }

    class TextListener implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            updateView.setCompleteOneField("");
            updateView.setSucces("");
            if(e.getSource() == updateView.getFirstName()){
                updateView.setFirstName("");
            }
            if(e.getSource() == updateView.getLastName()){
                updateView.setLastName("");
            }
            if(e.getSource() == updateView.getUsername()){
                updateView.setUsername("");
            }
            if(e.getSource() == updateView.getPassword()){
                updateView.setPassword("");
            }
            if(e.getSource() == updateView.getPersonalNumericalCode()){
                updateView.setPersonalNumericalCode("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }
}
