package presentation.controller;

import businessLogic.EmployeeBusiness;
import model.Employee;
import presentation.view.AdministratorRead;
import presentation.view.EmployeeRead;
import presentation.view.LogInView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

public class LogInController {
    private LogInView view;
    private AdministratorRead administratorRead;
    private EmployeeBusiness model;
    private EmployeeRead employeeRead;
    public LogInController(LogInView view, AdministratorRead administratorRead, EmployeeRead employeeRead, EmployeeBusiness model){
        this.view = view;
        this.administratorRead = administratorRead;
        this.model = model;
        this.employeeRead = employeeRead;
        view.addFocusListener(new TextListener());
        view.addActionListener(new ButtonListener());
    }

    class TextListener implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            view.setNotFound("");
            if(e.getSource() == view.jgetUsername()) {
                view.setUsername("");
            }
            if(e.getSource() == view.jgetPassword()){
                view.setPassword("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            //nothing
        }
    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == view.getSignIn()){
                String username = view.getUsername();
                String password = view.getPassword();
                if(username.compareTo("administrator") == 0){
                    view.setVisible(false);
                    administratorRead.setWhichUser(username);
                    administratorRead.setVisible(true);
                }
                else{
                    List<Employee> list = model.searchAfterName("username", "password", username, password);
                    if(list != null){
                    Employee employee = list.get(0);
                    if(employee != null){
                        view.setVisible(false);
                        employeeRead.setWhichUser(username);
                        employeeRead.setVisible(true);
                    }else {
                        view.setNotFound("Incorrect username/password!");
                    }
                    }else{
                        view.setNotFound("Incorrect username/password!");
                    }
                }
            }
        }
    }

}
