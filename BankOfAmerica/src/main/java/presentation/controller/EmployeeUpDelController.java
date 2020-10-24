package presentation.controller;

import businessLogic.AccountBusiness;
import model.Account;
import model.Client;
import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeeUpDelController {
    private EmployeeUpdateDelete employeeUpdateDelete;
    private EmployeeRead employeeRead;
    private EmployeeUpdateRegister employeeUpdateRegister;
    private AccountsRead accountsRead;
    private TransferMoney transferMoney;
    private AccountBusiness accountBusiness;
    private PayBills payBills;
    public EmployeeUpDelController(EmployeeUpdateDelete employeeUpdateDelete, EmployeeRead employeeRead, EmployeeUpdateRegister employeeUpdateRegister, AccountsRead accountsRead, TransferMoney transferMoney, PayBills payBills, AccountBusiness accountBusiness){
        this.employeeUpdateDelete = employeeUpdateDelete;
        this.employeeRead = employeeRead;
        this.accountsRead = accountsRead;
        this.employeeUpdateRegister = employeeUpdateRegister;
        this.transferMoney = transferMoney;
        this.payBills = payBills;
        this.accountBusiness = accountBusiness;
        employeeUpdateDelete.addActionListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Client client = (Client) employeeUpdateDelete.getShowEmployee().getModel().getElementAt(0);
            List<Account> accounts = accountBusiness.searchAfter("personalNumericalCode",client.getPersonalNumericalCode());
            if(e.getSource() == employeeUpdateDelete.getBack()){
                employeeUpdateDelete.resetValues();
                employeeUpdateDelete.setVisible(false);
                employeeRead.setVisible(true);
                employeeRead.resetValues();
            }
            if(e.getSource() == employeeUpdateDelete.getUpdate()){

                employeeUpdateDelete.setVisible(false);
                employeeUpdateRegister.setProceed("Complete at least one field in order to proceed:");
                employeeUpdateRegister.setVisible(true);
            }
            if(e.getSource() == employeeUpdateDelete.getShowAccounts()){
                employeeUpdateDelete.setVisible(false);
                accountsRead.resetValues();
               // Client client = (Client) employeeUpdateDelete.getShowEmployee().getModel().getElementAt(0);
               // List<Account> accounts = accountBussiness.searchAfter("personalNumericalCode",client.getPersonalNumericalCode());
                int size = accounts == null ? 0 : accounts.size();
                accountsRead.setFound("We found "  + size + " matching(s):");
                accountsRead.setFoundAccounts(accounts);
                accountsRead.setVisible(true);
            }
            if(e.getSource() == employeeUpdateDelete.getTransferMoney()){
                employeeUpdateDelete.setVisible(false);
                transferMoney.setFoundAccounts(accounts);
                transferMoney.setVisible(true);
            }
            if(e.getSource() == employeeUpdateDelete.getPayBills()){
                employeeUpdateDelete.setVisible(false);
                payBills.setFoundAccounts(accounts);
                payBills.setVisible(true);
            }
        }
    }
}
