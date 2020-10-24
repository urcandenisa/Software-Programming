package presentation.controller;

import businessLogic.AccountBusiness;
import businessLogic.EmployeeBusiness;
import businessLogic.ReportBusiness;
import model.Account;
import model.Employee;
import model.Report;
import presentation.view.EmployeeUpdateDelete;
import presentation.view.LogInView;
import presentation.view.PayBills;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PayBillsController {
    private PayBills payBills;
    private EmployeeUpdateDelete employeeUpdateDelete;
    private AccountBusiness accountBusiness;
    protected String bill;
    protected boolean paid;
    private LogInView logInView;
    private EmployeeBusiness employeeBusiness;
    private ReportBusiness reportBusiness;
    public PayBillsController(PayBills payBills, EmployeeUpdateDelete employeeUpdateDelete, LogInView logInView, EmployeeBusiness employeeBusiness, ReportBusiness reportBusiness, AccountBusiness accountBusiness){
        this.accountBusiness = accountBusiness;
        this.payBills = payBills;
        bill = "";
        paid = false;
        this.logInView = logInView;
        this.employeeBusiness = employeeBusiness;
        this.reportBusiness = reportBusiness;
        this.employeeUpdateDelete = employeeUpdateDelete;
        payBills.addActionListener(new ButtonListener());
        payBills.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                payBills.setSuccess("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Employee> employees = employeeBusiness.searchAfterName("username", "password", logInView.getUsername(), logInView.getPassword());
            Employee employee = employees.get(0);
            SimpleDateFormat dtf = new SimpleDateFormat("MM-dd-YYYY");
            Date now = new Date();
            if(e.getSource() == payBills.getBack()){
                payBills.setVisible(false);
                payBills.resetValues();
                employeeUpdateDelete.setVisible(true);
            }
            if(e.getSource() == payBills.getPlus()){
                if(payBills.getFoundAccounts().getSelectedValue() == null || payBills.getBills().getSelectedValue() == null){
                    payBills.setSuccess("      Select the account and the bill!");
                }else{
                    bill = (String) payBills.getBills().getSelectedValue();
                    int index = payBills.getBills().getSelectedIndex();
                    int comma = bill.indexOf(',');
                    comma++;
                    Double cost = Double.valueOf(bill.substring(comma));
                    Double sum = Double.valueOf(payBills.getTotal().getText()) + cost;
                    payBills.setTotal(String.valueOf(sum));
                    ((DefaultListModel) payBills.getBills().getModel()).remove(index);
                }
            }
            if(e.getSource() == payBills.getMinus()){
                if(paid == true){
                    payBills.setSuccess("          Everything is up to date.");
                }else {
                    if (bill.compareTo("") == 0) {
                        payBills.setSuccess("          Everything is up to date.");
                    }
                    ((DefaultListModel) payBills.getBills().getModel()).addElement(bill);
                    int comma = bill.indexOf(',');
                    comma++;
                    Double cost = Double.valueOf(bill.substring(comma));
                    Double sum = Double.valueOf(payBills.getTotal().getText()) - cost;
                    if (sum < 0) {
                        payBills.setSuccess("          Everything is up to date.");
                    } else {
                        payBills.setTotal(String.valueOf(sum));
                    }
                }
            }
            if(e.getSource() == payBills.getPay()){
               String value = payBills.getTotal().getText();
                if(Double.valueOf(value)!= 0){
                    Account fromAccount = (Account) payBills.getFoundAccounts().getSelectedValue();
                    Double toPay = fromAccount.getAmountOfMoney() - Double.valueOf(payBills.getTotal().getText());
                    if(toPay < 0){
                        payBills.setSuccess("Not enough money in your account!");
                    }else {
                        fromAccount.setAmountOfMoney(fromAccount.getAmountOfMoney() - Double.valueOf(payBills.getTotal().getText()));
                        accountBusiness.updateAccount(fromAccount);
                        payBills.setSuccess(" Your bills were successfully paid!");
                        payBills.setTotal("0");
                        String personalNumericalCode = fromAccount.getPersonalNumericalCode();
                        payBills.setFoundAccounts(accountBusiness.searchAfter("personalNumericalCode", personalNumericalCode));
                        Report report = new Report(employee.getId(), employee.getFirstName(), employee.getLastName(), "pay bills", dtf.format(now));
                        reportBusiness.add(report);
                    }
                }else{
                    payBills.setSuccess("          Everything is up to date.");
                }
            }
        }
    }
}
