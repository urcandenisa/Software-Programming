package presentation.controller;

import businessLogic.ClientBusiness;
import businessLogic.EmployeeBusiness;
import businessLogic.ReportBusiness;
import model.Client;
import model.Employee;
import model.Report;
import presentation.view.EmployeeRead;
import presentation.view.EmployeeUpdateDelete;
import presentation.view.EmployeeUpdateRegister;
import presentation.view.LogInView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class EmployeeUpRController {
    private EmployeeRead employeeRead;
    private EmployeeUpdateDelete employeeUpdateDelete;
    private EmployeeUpdateRegister employeeUpdateRegister;
    ClientBusiness model;
    EmployeeBusiness employeeBusiness;
    ReportBusiness reportBusiness;
    LogInView logInView;
    public EmployeeUpRController(EmployeeRead employeeRead, EmployeeUpdateRegister employeeUpdateRegister, EmployeeUpdateDelete employeeUpdateDelete, LogInView logInView,  EmployeeBusiness employeeBusiness, ReportBusiness reportBusiness, ClientBusiness model){
        this.employeeRead = employeeRead;
        this.employeeUpdateDelete = employeeUpdateDelete;
        this.employeeUpdateRegister = employeeUpdateRegister;
        this.reportBusiness = reportBusiness;
        this.model = model;
        this.employeeBusiness = employeeBusiness;
        this.logInView = logInView;
        employeeUpdateRegister.addActionListener(new ButtonListener());
        employeeUpdateRegister.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                employeeUpdateRegister.setSucces("");
                employeeUpdateRegister.setCompleteOneField("");
                if(e.getSource() == employeeUpdateRegister.getFirstName()){
                    employeeUpdateRegister.setFirstName("");
                }
                if(e.getSource() == employeeUpdateRegister.getLastName()){
                    employeeUpdateRegister.setLastName("");
                }
                if(e.getSource() == employeeUpdateRegister.getPersonalNumericalCode()){
                    employeeUpdateRegister.setPersonalNumericalCode("");
                }
                if(e.getSource() == employeeUpdateRegister.getIdentityCardNumber()){
                    employeeUpdateRegister.setIdentityCardNumber("");
                }
                if(e.getSource() == employeeUpdateRegister.getAddress()){
                    employeeUpdateRegister.setAddress("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Employee> employees = employeeBusiness.searchAfterName("username", "password",logInView.getUsername(), logInView.getPassword());
            List<Client>list = model.selectAll();
            int id = list.size() + 1;
            Employee employee = employees.get(0);
            SimpleDateFormat dtf = new SimpleDateFormat("MM-dd-YYYY");
            Date now = new Date();
            if(e.getSource() == employeeUpdateRegister.getBack()){

                employeeUpdateRegister.setVisible(false);
                employeeUpdateRegister.resetValues();
                employeeRead.setVisible(true);
            }
            if(e.getSource() == employeeUpdateRegister.getSubmit()){
                String firstName = "";
                String lastName = "";
                String personalNumericalCode = "";
                String identityCardNumber="";
                String address = "";
                boolean first_name = false;
                boolean last_name = false ;
                boolean personal_numerical_code = false;
                boolean identity_card_number = false;
                boolean address_ = false;
                try{
                    firstName = employeeUpdateRegister.getFirstName().getText();
                    lastName = employeeUpdateRegister.getLastName().getText();
                    personalNumericalCode = employeeUpdateRegister.getPersonalNumericalCode().getText();
                    identityCardNumber = employeeUpdateRegister.getIdentityCardNumber().getText();
                    address = employeeUpdateRegister.getAddress().getText();
                }catch (InputMismatchException ex){
                    ex.printStackTrace();
                }
                first_name = firstName.compareTo("first name") == 0;
                last_name = lastName.compareTo("last name") == 0 || lastName.compareTo("") == 0;
                personal_numerical_code = personalNumericalCode.compareTo("personal numerical code") == 0 || personalNumericalCode.compareTo("") == 0;
                identity_card_number = identityCardNumber.compareTo("identity card number") == 0 || identityCardNumber.compareTo("") == 0;
                address_ = address.compareTo("address") == 0 ||
                        address.compareTo("") == 0;
                boolean condition = first_name || firstName.compareTo("") == 0 || last_name || personal_numerical_code || identity_card_number || address_;
                if(employeeUpdateRegister.getProceed().compareTo("Complete all the fields in order to proceed:") == 0){
                    if(condition){
                        employeeUpdateRegister.setCompleteOneField("Complete all the fields!");
                    }else{
                        //aici e register, deci add la client cu datele preluate
                        List<Client> c = model.searchAfter(personalNumericalCode);
                        if(c != null){
                            employeeUpdateRegister.setCompleteOneField(" Client already exists!");
                        }else {
                            Client newClient = new Client(id, firstName, lastName, identityCardNumber, personalNumericalCode, address);
                            if(newClient == null){
                                employeeUpdateRegister.setSucces("Client can not be added");
                            }else {
                                if(model.addClient(newClient) == false)employeeUpdateRegister.setSucces("Client can not be added!");
                                else{
                                employeeUpdateRegister.resetValues();
                                employeeUpdateRegister.setSucces("Client successfully added!");

                                Report report = new Report(employee.getId(), employee.getFirstName(), employee.getLastName(), "register a new client", dtf.format(now));
                                reportBusiness.add(report);}
                            }
                        }
                    }
                }else //if(employeeUpdateRegister.getProceed().compareTo("Complete at least one field in order to proceed:") == 0)
                     {
                    if(first_name && firstName.compareTo("") == 0 && last_name && personal_numerical_code && identity_card_number && address_){ // if no field has been updated
                        employeeUpdateRegister.setCompleteOneField("Complete at least one field!");
                    }else{
                        Client client = (Client) employeeUpdateDelete.getShowEmployee().getModel().getElementAt(0);
                        firstName = client.getFirstName();
                        lastName = client.getLastName();
                        personalNumericalCode = client.getPersonalNumericalCode();
                        address = client.getAddress();
                        identityCardNumber = client.getIdentityCardNumber();
                        //aici ar trebui sa faca update...
                        if(first_name == false && firstName.compareTo("") != 0){
                            firstName = employeeUpdateRegister.getFirstName().getText();
                        }
                        if(last_name == false){
                            lastName = employeeUpdateRegister.getLastName().getText();
                        }
                        if(address_ == false){
                            address = employeeUpdateRegister.getAddress().getText();
                        }
                        if(identity_card_number == false){
                            identityCardNumber = employeeUpdateRegister.getIdentityCardNumber().getText();
                        }
                        if(personal_numerical_code == false){
                            personalNumericalCode = employeeUpdateRegister.getPersonalNumericalCode().getText();
                        }
                        Client newClient = new Client(client.getId(), firstName, lastName, identityCardNumber, personalNumericalCode, address);
                        model.updateClient(newClient);
                        employeeUpdateRegister.resetValues();
                        employeeUpdateRegister.setSucces("    Successfully updated!");
                        Report report = new Report(employee.getId(), employee.getFirstName(), employee.getLastName(), "updated client's info", dtf.format(now));
                        reportBusiness.add(report);
                    }
                }

            }
        }
    }

}
