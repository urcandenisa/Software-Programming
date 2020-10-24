package presentation.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

public class AdministratorRead extends Basic {

    private JButton submit;
    private JButton register;
    private JTextField employeesFirstName;
    private JTextField employeesLastName;
    private JLabel noMatching;
    private JButton reports;
    private JButton back;


    public AdministratorRead(){

        super();
        JLabel introduceEmployeeLabel = new JLabel("Introduce employee's name: ");
        introduceEmployeeLabel.setOpaque(false);
        introduceEmployeeLabel.setFont(font);
        introduceEmployeeLabel.setBounds(90, 190, introduceEmployeeLabel.getPreferredSize().width, introduceEmployeeLabel.getPreferredSize().height);

        employeesFirstName = new JTextField("first name");
        employeesFirstName.setOpaque(false);
        employeesFirstName.setForeground(Color.lightGray);
        employeesFirstName.setFont(font);
        employeesFirstName.setBorder(new LineBorder(Color.lightGray, 1, true));
        employeesFirstName.setBounds(110, 210, 100, 20);

        employeesLastName = new JTextField("last name");
        employeesLastName.setOpaque(false);
        employeesLastName.setForeground(Color.lightGray);
        employeesLastName.setFont(font);
        employeesLastName.setBorder(new LineBorder(Color.lightGray, 1, true));
        employeesLastName.setBounds(110, 235, 100, 20);

        submit = new JButton("Submit  ");  // asta e R-ul de fapt, read din CRUD
        submit.setOpaque(false);
        submit.setForeground(Color.black);
        submit.setFont(font);
        submit.setBorder(new LineBorder(Color.lightGray, 1, true));
        submit.setBounds(140, 260, submit.getPreferredSize().width, submit.getPreferredSize().height);

        JLabel newEmployeeLabel = new JLabel("Hired someone new? Register here: ");
        newEmployeeLabel.setOpaque(false);
        newEmployeeLabel.setFont(font);
        newEmployeeLabel.setBounds(78, 280, newEmployeeLabel.getPreferredSize().width, newEmployeeLabel.getPreferredSize().height);

        register = new JButton("Register"); // asta e C-ul, create
        register.setOpaque(false);
        register.setForeground(Color.black);
        register.setFont(font);
        register.setBorder(new LineBorder(Color.lightGray, 1, true));
        register.setBounds(140, 300, register.getPreferredSize().width, register.getPreferredSize().height);

        reports = new JButton("Reports");
        reports.setOpaque(false);
        reports.setForeground(Color.black);
        reports.setFont(font);
        reports.setBorder(new LineBorder(Color.lightGray, 1, true));
        reports.setBounds(260, 350, reports.getPreferredSize().width, reports.getPreferredSize().height);

        noMatching = new JLabel("");
        noMatching.setOpaque(false);
        noMatching.setFont(font);
        noMatching.setForeground(Color.black);
        noMatching.setBounds(78, 315, 200, 20);

        back = new JButton("Back");
        back.setOpaque(false);
        back.setForeground(Color.black);
        back.setFont(font);
        back.setBorder(new LineBorder(Color.lightGray, 1, true));
        back.setBounds(10, 350, 40, 20);

        mainPanel.add(back);
        mainPanel.add(noMatching);
        mainPanel.add(employeesFirstName);
        mainPanel.add(employeesLastName);
        mainPanel.add(introduceEmployeeLabel);
        mainPanel.add(submit);
        mainPanel.add(newEmployeeLabel);
        mainPanel.add(register);
        mainPanel.add(reports);

    }

    public String getFirstName(){
        return employeesFirstName.getText().toString();
    }
    public String getLastName(){
        return employeesLastName.getText().toString();
    }

    public void addActionListener(ActionListener buttonListener){
        submit.addActionListener(buttonListener);
        register.addActionListener(buttonListener);
        back.addActionListener(buttonListener);
        reports.addActionListener(buttonListener);
    }

    public void addFocusListener(FocusListener textEvent){
        employeesFirstName.addFocusListener(textEvent);
        employeesLastName.addFocusListener(textEvent);
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public JButton getRegister() {
        return register;
    }

    public void setRegister(JButton register) {
        this.register = register;
    }

    public JTextField getEmployeesFirstName() {
        return employeesFirstName;
    }

    public void setEmployeesFirstName(String employeesFirstName) {
        this.employeesFirstName.setText(employeesFirstName);
        this.employeesFirstName.setForeground(Color.black);
    }

    public JTextField getEmployeesLastName() {
        return employeesLastName;
    }

    public void setEmployeesLastName(String employeesLastName) {
        this.employeesLastName.setText(employeesLastName);
        this.employeesLastName.setForeground(Color.black);
    }

    public void resetValues(){
        this.employeesFirstName.setText("first name");
        this.employeesLastName.setText("last name");
        this.noMatching.setText("");
        this.employeesFirstName.setForeground(Color.lightGray);
        this.employeesLastName.setForeground(Color.lightGray);
    }

    public JButton getReports() {
        return reports;
    }

    public void setReports(JButton reports) {
        this.reports = reports;
    }

    public JLabel getNoMatching() {
        return noMatching;
    }

    public void setNoMatching(String noMatching) {
        this.noMatching.setText("No matching values has been found!");
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public static void main(String[] args) {
        AdministratorRead view = new AdministratorRead();
        view.setVisible(true);
    }
}
