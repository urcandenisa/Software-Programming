package presentation.controller;

import businessLogic.EmployeeBusiness;
import model.Employee;
import presentation.view.AdministratorRead;
import presentation.view.AdministratorUpdateRegister;
import presentation.view.AdministratorUpdateDelete;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdministratorUpDelController {
    AdministratorUpdateDelete view;
    AdministratorRead rView;
    EmployeeBusiness model;
    AdministratorUpdateRegister updateView;
    public AdministratorUpDelController(AdministratorUpdateDelete view, AdministratorRead rView, AdministratorUpdateRegister updateView, EmployeeBusiness model){
        this.view = view;
        this.rView = rView;
        this.updateView = updateView;
        this.model = model;
        view.addActionListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == view.getBack()){
                view.setVisible(false);
                rView.resetValues();
                view.resetValues();
                rView.setVisible(true);
            }
            if(e.getSource() == view.getUpdate()){
                view.setVisible(false);
                view.resetValues();
                updateView.setProceed("Complete at least one field in order to proceed");
                updateView.setVisible(true);

            }
            if(e.getSource() == view.getDelete()){
               if(view.getFoundEmployees().getModel().getSize() > 1){
                   String selectedItem = String.valueOf(view.getFoundEmployees().getSelectedValue());

                   if(selectedItem.compareTo("") == 0 ){
                       view.setNotSelected("anything");
                   }else{
                       System.out.println("code if there are more than 2 people with the same name" + selectedItem);
                   }
               }
               ListModel<Employee> list = view.getFoundEmployees().getModel();
               String firstName = list.getElementAt(0).getFirstName();
               String lastName = list.getElementAt(0).getLastName();
               String personalNumericalCode = list.getElementAt(0).getPersonalNumericalCode();
               model.deleteAfter(personalNumericalCode);
               view.setFoundEmployees(new ArrayList<>());
               view.setSuccessfullyDeleted("anything");
                view.resetValues();
            }
        }
    }

}
