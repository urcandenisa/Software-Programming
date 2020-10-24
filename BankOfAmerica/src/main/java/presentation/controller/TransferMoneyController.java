package presentation.controller;

import businessLogic.AccountBusiness;
import businessLogic.EmployeeBusiness;
import businessLogic.ReportBusiness;
import model.Account;
import model.Employee;
import model.Report;
import presentation.view.EmployeeUpdateDelete;
import presentation.view.LogInView;
import presentation.view.TransferMoney;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TransferMoneyController {
    private TransferMoney transferMoney;
    private EmployeeUpdateDelete employeeUpdateDelete;
    private AccountBusiness model;
    private LogInView logInView;
    private EmployeeBusiness employeeBusiness;
    private ReportBusiness reportBusiness;
    public TransferMoneyController(TransferMoney transferMoney, EmployeeUpdateDelete employeeUpdateDelete, LogInView logInView, EmployeeBusiness employeeBusiness, ReportBusiness reportBusiness,AccountBusiness model){
        this.transferMoney = transferMoney;
        this.employeeUpdateDelete = employeeUpdateDelete;
        this.model = model;
        this.logInView = logInView;
        this.employeeBusiness = employeeBusiness;
        this.reportBusiness = reportBusiness;
        transferMoney.addActionListener(new ButtonListener());
        transferMoney.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                transferMoney.setFail("");
                if(e.getSource() == transferMoney.getIntoAccount()){
                    transferMoney.setIntoAccount("");
                }
                if(e.getSource() == transferMoney.getAmountOfMoney()){
                    transferMoney.setAmountOfMoney("");
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
            List<Employee> employees = employeeBusiness.searchAfterName("username", "password", logInView.getUsername(), logInView.getPassword());
            Employee employee = employees.get(0);
            SimpleDateFormat dtf = new SimpleDateFormat("MM-dd-YYYY");
            Date now = new Date();
            if(e.getSource() == transferMoney.getBack()){
                transferMoney.setVisible(false);
                transferMoney.resetValues();
                employeeUpdateDelete.setVisible(true);
            }
            if(e.getSource() == transferMoney.getSubmit()){
                Account fromAccount = (Account) transferMoney.getFoundAccounts().getSelectedValue();
                if(fromAccount == null){
                    transferMoney.setFail("Select one account!");
                }else{
                    String identificationNumber = transferMoney.getIntoAccount().getText();
                    if(identificationNumber.compareTo("") == 0 || identificationNumber.compareTo("identification number") == 0){
                        transferMoney.setFail("Complete all the fields!");
                    }else{
                        String amount = transferMoney.getAmountOfMoney().getText();
                        if(amount.compareTo("") == 0 || amount.compareTo("amount") == 0){
                            transferMoney.setFail("Enter the amount of money!");
                        }else{
                            Double amountOfMoney = 0.0;
                            try {
                                amountOfMoney = Double.parseDouble(amount);
                            }catch(NumberFormatException ex){
                                transferMoney.setFail("Complete all the fields!");
                            }
                        List<Account> list = model.searchAfter("identificationNumber", identificationNumber);
                        if(list != null){
                            Account intoAccount = list.get(0);
                            if(intoAccount != null){
                                if(fromAccount.getAmountOfMoney() - amountOfMoney > 0){
                                    intoAccount.setAmountOfMoney(intoAccount.getAmountOfMoney() + amountOfMoney);
                                    fromAccount.setAmountOfMoney(fromAccount.getAmountOfMoney() - amountOfMoney);
                                    model.updateAccount(intoAccount);
                                    model.updateAccount(fromAccount);
                                    transferMoney.setSuccess("Money successfully transferred!");
                                    Report report = new Report(employee.getId(), employee.getFirstName(), employee.getLastName(),"money transfer", dtf.format(now));
                                    reportBusiness.add(report);
                                }
                                else transferMoney.setFail("Not enough money!");
                            }
                        }else{
                            transferMoney.setFail("Enter a valid bank account");
                        }
                        }
                    }
                }

            }
        }
    }
}
