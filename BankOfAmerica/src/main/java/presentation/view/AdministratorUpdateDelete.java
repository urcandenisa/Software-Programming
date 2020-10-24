package presentation.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.List;

public class AdministratorUpdateDelete extends Basic {
    // aici fa UPDATE SI DELETE!!!!!! u si d , inseamna ca a apasat submit daca am ajuns aici

    private JList foundEmployees;
    private JButton back;
    private JButton update;
    private JButton delete;
    private JLabel notSelected;
    private JLabel successfullyDeleted;
    private JLabel foundLabel;

    public AdministratorUpdateDelete(){

        back = new JButton("Back");
        back.setOpaque(false);
        back.setForeground(Color.black);
        back.setFont(font);
        back.setBorder(new LineBorder(Color.lightGray, 1, true));
        back.setBounds(10, 350, 40, 20);

        update = new JButton("Update");
        update.setOpaque(false);
        update.setForeground(Color.black);
        update.setFont(font);
        update.setBorder(new LineBorder(Color.lightGray, 1, true));
        update.setBounds(240, 210, 40, 20);

        delete = new JButton("Delete");
        delete.setOpaque(false);
        delete.setForeground(Color.black);
        delete.setFont(font);
        delete.setBorder(new LineBorder(Color.lightGray, 1, true));
        delete.setBounds(240, 240, 40, 20);

        foundLabel = new JLabel("");
        foundLabel.setOpaque(false);
        foundLabel.setFont(font);
        foundLabel.setBounds(10, 190, 200, 20);

        notSelected = new JLabel("");
        notSelected.setOpaque(false);
        notSelected.setFont(font);
        notSelected.setBounds(70, 265, 130, 20);

        successfullyDeleted = new JLabel("");
        successfullyDeleted.setOpaque(false);
        successfullyDeleted.setFont(font);
        successfullyDeleted.setBounds(70, 265, 130, 20);

        foundEmployees  = new JList();
        foundEmployees.setCellRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setOpaque(false);
                return this;
            }
        });
        foundEmployees.setOpaque(false);
        foundEmployees.setFont(font);
        foundEmployees.setBorder(new LineBorder(Color.lightGray, 1, true));
        foundEmployees.setBounds(10, 210, 220, 50);

        mainPanel.add(notSelected);
        mainPanel.add(delete);
        mainPanel.add(update);
        mainPanel.add(foundLabel);
        mainPanel.add(foundEmployees);
        mainPanel.add(back);
        mainPanel.add(successfullyDeleted);

    }

    public JList getFoundEmployees() {
        return foundEmployees;
    }

    public void setFoundEmployees(List<?extends Object> employees) {
        DefaultListModel<Object> list = new DefaultListModel<Object>();
        for(Object obj: employees){
            list.addElement(obj);
        }
        if(list == null){
            foundEmployees = new JList();
            return;
        }
        foundEmployees.setModel(list);
    }

    public JLabel getFound() {
        return this.foundLabel;
    }

    public void setFound(String found) {
        this.foundLabel.setText(found);
    }

    public void addActionListener(ActionListener buttonListener){
        this.back.addActionListener(buttonListener);
        this.delete.addActionListener(buttonListener);
        this.update.addActionListener(buttonListener);
    }

    @Override
    public void addFocusListener(FocusListener listener) {

    }

    public JLabel getNotSelected() {
        return notSelected;
    }

    public void setNotSelected(String notSelected) {
        notSelected =" Please select a record!";
        this.notSelected.setText(notSelected);
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public JButton getUpdate() {
        return update;
    }

    public void setUpdate(JButton update) {
        this.update = update;
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public JLabel getSuccessfullyDeleted() {
        return successfullyDeleted;
    }

    public void setSuccessfullyDeleted(String successfullyDeleted) {
        successfullyDeleted = "Successfully deleted!";
        this.successfullyDeleted.setText(successfullyDeleted);
    }

    public void resetValues(){
        successfullyDeleted.setText("");
        notSelected.setText("");
    }
    public static void main(String[] args) {
        AdministratorUpdateDelete view = new AdministratorUpdateDelete();
        view.setVisible(true);
    }
}
