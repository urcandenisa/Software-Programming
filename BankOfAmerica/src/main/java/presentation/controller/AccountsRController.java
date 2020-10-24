package presentation.controller;

import businessLogic.AccountBusiness;
import businessLogic.EmployeeBusiness;
import businessLogic.ReportBusiness;
import model.Account;
import model.Client;
import model.Employee;
import model.Report;
import presentation.view.AccountsRead;
import presentation.view.AccountsUpdateRegister;
import presentation.view.EmployeeUpdateDelete;
import presentation.view.LogInView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountsRController {
    private AccountsRead accountsRead;
    private EmployeeUpdateDelete employeeUpdateDelete;
    private AccountsUpdateRegister accountsUpdateRegister;
    private AccountBusiness model;
    private LogInView logInView;
    private EmployeeBusiness employeeBusiness;
    private ReportBusiness reportBusiness;
    public AccountsRController(AccountsRead accountsRead, EmployeeUpdateDelete employeeUpdateDelete, AccountsUpdateRegister accountsUpdateRegister,LogInView logInView, EmployeeBusiness employeeBusiness, ReportBusiness reportBusiness, AccountBusiness model){
        this.accountsRead = accountsRead;
        this.employeeUpdateDelete = employeeUpdateDelete;
        this.accountsUpdateRegister = accountsUpdateRegister;
        this.model = model;
        this.logInView = logInView;
        this.employeeBusiness = employeeBusiness;
        this.reportBusiness = reportBusiness;
        accountsRead.addActionListener(new ButtonListener());
        accountsRead.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                accountsRead.setNotSelected("");
                accountsRead.setSuccess("");
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
            if(e.getSource() == accountsRead.getBack()){
                accountsRead.resetValues();
                accountsRead.setVisible(false);
                employeeUpdateDelete.resetValues();
                employeeUpdateDelete.setVisible(true);
            }
            if(e.getSource() == accountsRead.getDelete()){
                Account account = (Account) accountsRead.getFoundAccounts().getSelectedValue();
                if(account == null) {
                    accountsRead.setNotSelected("Select at least one account to be deleted!");
                }else{
                model.delete(account);
                Client client = (Client) employeeUpdateDelete.getShowEmployee().getModel().getElementAt(0);
                List<Account> accounts = model.searchAfter("personalNumericalCode",client.getPersonalNumericalCode());
                int size = accounts == null ? 0 : accounts.size();
                accountsRead.setFound("We found "  + size + " matching(s):");
                accountsRead.setSuccess("Account successfully deleted!");
                if(accounts == null ){
                    accountsRead.setFoundAccounts(new ArrayList<>());
                }else
                accountsRead.setFoundAccounts(accounts);

                Report report = new Report(employee.getId(), employee.getFirstName(), employee.getLastName(), "deleted an account", dtf.format(now));
                reportBusiness.add(report);
                }
            }
            if(e.getSource() == accountsRead.getUpdate()){
                if(accountsRead.getFoundAccounts().getSelectedValue() == null){
                    accountsRead.setNotSelected("Select at least one account to be updated!");
                }else {
                    accountsRead.setVisible(false);
                    accountsUpdateRegister.setFirst("Complete at least one field in order to proceed:");
                    accountsUpdateRegister.setVisible(true);
                }
            }
            if(e.getSource() == accountsRead.getCreate()){
                accountsUpdateRegister.setFirst("Complete all the fields in order to proceed:");
                accountsRead.setVisible(false);
                accountsUpdateRegister.resetValues();
                accountsUpdateRegister.setVisible(true);

            }

        }
    }
}
