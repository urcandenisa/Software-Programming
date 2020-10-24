package presentation.controller;

import businessLogic.AccountBusiness;
import businessLogic.EmployeeBusiness;
import businessLogic.ReportBusiness;
import model.Account;

import model.Client;
import model.Employee;
import model.Report;
import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class AccountsUpRController  {
    private AccountsUpdateRegister accountsUpdateRegister;
    private AccountsRead accountsRead;
    private EmployeeRead employeeRead;
    private EmployeeUpdateDelete employeeUpdateDelete;
    private AccountBusiness model;
    private LogInView logInView;
    private EmployeeBusiness employeeBusiness;
    private ReportBusiness reportBusiness;
    public AccountsUpRController(AccountsUpdateRegister accountsUpdateRegister, AccountsRead accountsRead, EmployeeRead employeeRead, EmployeeUpdateDelete employeeUpdateDelete,LogInView logInView, EmployeeBusiness employeeBusiness, ReportBusiness reportBusiness, AccountBusiness model){
        this.accountsUpdateRegister = accountsUpdateRegister;
        this.accountsRead = accountsRead;
        this.employeeRead = employeeRead;
        this.model = model;
        this.logInView = logInView;
        this.employeeBusiness = employeeBusiness;
        this.reportBusiness = reportBusiness;
        this.employeeUpdateDelete = employeeUpdateDelete;
        accountsUpdateRegister.addActionListener(new ButtonListener());
        accountsUpdateRegister.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                accountsUpdateRegister.setSuccess("");
                accountsUpdateRegister.setCompleteFields("");
                if(e.getSource() == accountsUpdateRegister.getamountOfMoney())
                  accountsUpdateRegister.setamountOfMoney("");
                if(e.getSource() == accountsUpdateRegister.getTypeAccount())
                 accountsUpdateRegister.setType("");
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
            if(e.getSource() == accountsUpdateRegister.getBack()){
                accountsUpdateRegister.resetValues();
                accountsUpdateRegister.setVisible(false);
                accountsRead.resetValues();
                Client client = (Client) employeeUpdateDelete.getShowEmployee().getModel().getElementAt(0);
                List<Account> accounts = model.searchAfter("personalNumericalCode",client.getPersonalNumericalCode());
                int size = accounts == null ? 0 : accounts.size();
                accountsRead.setFound("We found " + size + " matching(s):");
                String personalNumericalCode = employeeRead.getPersonalNumericalCode().getText();
                accountsRead.setFoundAccounts(model.searchAfter("personalNumericalCode",personalNumericalCode));
                accountsRead.setVisible(true);
            }
            if(e.getSource() == accountsUpdateRegister.getSubmit()){
                String personalNumericalCode = employeeRead.getPersonalNumericalCode().getText();
                double amountOfMoney = 0;
                String type = accountsUpdateRegister.getTypeAccount().getText();
                String amount = accountsUpdateRegister.getamountOfMoney().getText();
                Client client = (Client) employeeUpdateDelete.getShowEmployee().getModel().getElementAt(0);
                List<Account> accounts = model.searchAfter("personalNumericalCode",client.getPersonalNumericalCode());
                //adauga contul account la bd

                if(accountsUpdateRegister.getFirst().getText().compareTo("Complete all the fields in order to proceed:") == 0) {
                    Random rand = new Random();
                    int identif = rand.nextInt(100000);
                    if (amount.compareTo("") != 0 && amount.compareTo("amount of money") != 0 && type.compareTo("") != 0 && type.compareTo("type") != 0) {
                        amountOfMoney = Double.parseDouble(accountsUpdateRegister.getamountOfMoney().getText());
                        model.addAccount(new Account(personalNumericalCode, String.valueOf(identif), type, amountOfMoney, dtf.format(now)));
                        accountsUpdateRegister.setSuccess("Account successfully created!");
                        Report report = new Report(employee.getId(), employee.getFirstName(), employee.getLastName(), "created a new account", dtf.format(now));
                        reportBusiness.add(report);
                        accountsRead.resetValues();
                        int size = accounts == null ? 0 : accounts.size();
                        accountsRead.setFound("We found " + size + " matching(s):");
                        accountsRead.resetValues();
                    } else {
                        accountsUpdateRegister.setCompleteFields("Complete all the fields!");
                    }
                }else{
                    boolean amount_of_money = amount.compareTo("") != 0 && amount.compareTo("amount of money") != 0;
                    boolean type1 = type.compareTo("") != 0 && type.compareTo("type") != 0;

                    if(amount_of_money || type1){
                        Account account = (Account) accountsRead.getFoundAccounts().getSelectedValue();
                        if(amount_of_money)
                            account.setAmountOfMoney(Double.parseDouble(accountsUpdateRegister.getamountOfMoney().getText()));
                        if(type1){
                            account.setType(accountsUpdateRegister.getTypeAccount().getText());
                        }
                        model.updateAccount(account);
                        accountsUpdateRegister.setSuccess("Account successfully updated!");
                        Report report = new Report(employee.getId(), employee.getFirstName(), employee.getLastName(), "updated an account", dtf.format(now));
                        reportBusiness.add(report);
                    }else{
                        accountsUpdateRegister.setCompleteFields("Complete at least one field!");
                    }
                }
            }
        }
    }
}
