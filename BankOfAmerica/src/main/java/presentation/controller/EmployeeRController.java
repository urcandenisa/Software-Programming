package presentation.controller;

import businessLogic.ClientBusiness;
import presentation.view.EmployeeRead;
import presentation.view.EmployeeUpdateDelete;
import presentation.view.EmployeeUpdateRegister;
import presentation.view.LogInView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;


public class EmployeeRController {
    EmployeeRead employeeRead;
    EmployeeUpdateRegister updateRegister;
    EmployeeUpdateDelete employeeUpdateDelete;
    LogInView logInView;
    ClientBusiness model;
    public EmployeeRController(EmployeeRead employeeRead, EmployeeUpdateRegister updateRegister, EmployeeUpdateDelete employeeUpdateDelete, LogInView logInView, ClientBusiness model){
        this.employeeRead = employeeRead;
        this.updateRegister = updateRegister;
        this.logInView = logInView;
        this.employeeUpdateDelete = employeeUpdateDelete;
        this.model = model;
        employeeRead.addActionListener(new ButtonListener());
        employeeRead.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                employeeRead.setNoMatching("");
                if(e.getSource() == employeeRead.getPersonalNumericalCode()){
                    employeeRead.setPersonalNumericalCode("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == employeeRead.getSubmit()){
                String personalNumericalCode = employeeRead.getPersonalNumericalCode().getText();
                List<? extends Object> employees = model.searchAfter(personalNumericalCode);
                if(employees == null){
                    employeeRead.setNoMatching("No client matching!");
                }else{
                    employeeRead.setVisible(false);
                    employeeUpdateDelete.setFoundEmployees(employees);
                    employeeUpdateDelete.setVisible(true);
                }
            }
            if(e.getSource() == employeeRead.getRegister()){
                employeeRead.setVisible(false);
                updateRegister.setProceed("Complete all the fields in order to proceed:");
                updateRegister.setVisible(true);

            }
            if(e.getSource() == employeeRead.getBack()){
                employeeRead.setVisible(false);
                employeeRead.resetValues();
                logInView.resetValues();
                logInView.setVisible(true);
            }
        }
    }
}
