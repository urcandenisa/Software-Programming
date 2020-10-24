package presentation.controller;

import businessLogic.AccountBusiness;
import businessLogic.ClientBusiness;
import businessLogic.EmployeeBusiness;
import businessLogic.ReportBusiness;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import model.Employee;
import model.Report;
import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdministratorRController {
     AdministratorRead view;
     AdministratorUpdateDelete secondView;
     AdministratorUpdateRegister upView;
     EmployeeBusiness model;
     ReportBusiness reportBusiness;
     LogInView logInView;
     public AdministratorRController(AdministratorRead view, AdministratorUpdateDelete secondView, AdministratorUpdateRegister upView, LogInView logInView, ReportBusiness reportBusiness, EmployeeBusiness model){
         this.view = view;
         this.secondView = secondView;
         this.model = model;
         this.upView = upView;
         this.logInView = logInView;
         this.reportBusiness = reportBusiness;
         view.addActionListener(new ButtonListener());
         view.addFocusListener(new TextListener());
     }

     class ButtonListener implements ActionListener{

         @Override
         public void actionPerformed(ActionEvent e) {
             String firstName = "";
             String lastName = "";
             try{
                 firstName = view.getFirstName();
                 lastName = view.getLastName();
             }catch(InputMismatchException ex){
                 ex.printStackTrace();
                 //DO SMTH
             }
             if(e.getSource() == view.getSubmit()){
                if(firstName.compareTo("") != 0 && lastName.compareTo("") != 0){
                    List<? extends Object> employees = model.searchAfterName("firstName", "lastName", firstName, lastName);

                    if(employees == null){
                        view.setNoMatching("anything");
                    }
                    else {
                        secondView.setFound("We found " + employees.size() + " matching(s):");
                        //System.out.println(employees.size());
                        secondView.setFoundEmployees(employees);
                        secondView.setVisible(true);
                        view.resetValues();
                        view.setVisible(false);

                    }
                }
             }
             if(e.getSource() == view.getRegister()){
                view.setVisible(false);
                view.resetValues();
                upView.setProceed("Complete all fields in order to proceed:");
                upView.setVisible(true);
                upView.resetValues();
             }
             if(e.getSource() == view.getBack()){
                view.setVisible(false);
                view.resetValues();
                logInView.resetValues();
                logInView.setVisible(true);
             }
             if(e.getSource() == view.getReports()){
                 if(firstName.compareTo("") != 0 && lastName.compareTo("") != 0 && firstName.compareTo("first name") != 0 && lastName.compareTo("last name") != 0){
                    List<Employee> employees = model.searchAfterName("firstName", "lastName", firstName, lastName);
                    if(employees != null) {
                        Employee employee = employees.get(0);
                        List<Report> reports = reportBusiness.searchAfterId(employee.getId());
                        for(int i = 0; i < reports.size(); i++){
                            reports.get(i).setFirstName(employee.getFirstName());
                            reports.get(i).setLastName(employee.getLastName());
                        }
                        Document document = new Document();
                        try {
                            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Reports.pdf"));
                            document.open();
                            for(int i = 0; i < reports.size(); i++){
                                document.add(new Paragraph(reports.get(i).toString()));
                            }
                            document.close();
                            writer.close();
                        } catch (DocumentException ex) {
                            ex.printStackTrace();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                    else{
                        view.setNoMatching("Employee " + firstName + " " + lastName + "doesn't exist!" );
                    }
                 }else{
                     view.setNoMatching("Employee " + firstName + " " + lastName + "doesn't exist!" );


                 }
             }
         }
     }

     class TextListener implements FocusListener{

         @Override
         public void focusGained(FocusEvent e) {
             view.getNoMatching().setText("");
             if(e.getSource() == view.getEmployeesFirstName()){
                 view.setEmployeesFirstName("");
             }
             if(e.getSource() == view.getEmployeesLastName()){
                 view.setEmployeesLastName("");
             }
         }
         @Override
         public void focusLost(FocusEvent e) {

         }
     }

    public static void main(String[] args) {
        ChargingView firstView = new ChargingView();
        LogInView view = new LogInView();
        ReportBusiness reportBusiness = new ReportBusiness();
        ClientBusiness clientBusiness = new ClientBusiness();
        AccountBusiness accountBussiness = new AccountBusiness();
        AdministratorUpdateDelete secondView = new AdministratorUpdateDelete();
        AdministratorRead administratorRead = new AdministratorRead();
        EmployeeBusiness employeeBusiness = new EmployeeBusiness();
        EmployeeRead employeeRead = new EmployeeRead();
        EmployeeUpdateDelete employeeUpdateDelete = new EmployeeUpdateDelete();
        EmployeeUpdateRegister updateRegister = new EmployeeUpdateRegister();
        AccountsRead accountsRead = new AccountsRead();
        TransferMoney transferMoney = new TransferMoney();
        PayBills payBills = new PayBills();
        PayBillsController payBillsController = new PayBillsController(payBills, employeeUpdateDelete, view, employeeBusiness, reportBusiness, accountBussiness);
        TransferMoneyController transferMoneyController = new TransferMoneyController(transferMoney,employeeUpdateDelete,view, employeeBusiness, reportBusiness,accountBussiness);
        AccountsUpdateRegister accountsUpdateRegister = new AccountsUpdateRegister();
        AccountsUpRController accountsUpRController = new AccountsUpRController(accountsUpdateRegister, accountsRead, employeeRead, employeeUpdateDelete, view, employeeBusiness, reportBusiness,accountBussiness);
        AccountsRController accountsRController = new AccountsRController(accountsRead, employeeUpdateDelete, accountsUpdateRegister, view, employeeBusiness, reportBusiness,accountBussiness );
        EmployeeUpDelController employeeUpDelController = new EmployeeUpDelController(employeeUpdateDelete, employeeRead, updateRegister, accountsRead, transferMoney, payBills, accountBussiness);
        EmployeeRController employeeRController = new EmployeeRController(employeeRead, updateRegister, employeeUpdateDelete, view, clientBusiness);
        EmployeeUpRController employeeUpRController = new EmployeeUpRController(employeeRead, updateRegister, employeeUpdateDelete, view, employeeBusiness, reportBusiness,clientBusiness);
        LogInController controller = new LogInController(view, administratorRead, employeeRead, employeeBusiness);
        AdministratorUpdateRegister updateView = new AdministratorUpdateRegister();
        AdministratorRController administratorController = new AdministratorRController(administratorRead, secondView, updateView, view, reportBusiness, employeeBusiness);
        AdministratorUpRController upController = new AdministratorUpRController(administratorRead, updateView, secondView, reportBusiness, employeeBusiness);
        AdministratorUpDelController administratorUpDelController = new AdministratorUpDelController(secondView, administratorRead,updateView, employeeBusiness);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        firstView.setVisible(false);
        view.setVisible(true);

    }

}
