import businessLogic.AccountBusiness;
import businessLogic.ClientBusiness;
import businessLogic.EmployeeBusiness;
import businessLogic.ReportBusiness;
import presentation.controller.*;
import presentation.view.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class Main {

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
