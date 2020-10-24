package presentation.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

public class EmployeeUpdateRegister extends Basic {
    private JTextField firstName;
    private JTextField lastName;
    private JTextField identityCardNumber;
    private JTextField personalNumericalCode;
    private JTextField address;
    private JButton back;
    private JButton submit;
    private JLabel proceed;
    private JLabel completeOneField;
    private JLabel succesfullyUpdated;
    
    public  EmployeeUpdateRegister(){
        super();
        back = new JButton("Back");
        back.setOpaque(false);
        back.setForeground(Color.black);
        back.setFont(font);
        back.setBorder(new LineBorder(Color.lightGray, 1, true));
        back.setBounds(10, 350, 40, 20);

        submit = new JButton("Submit");
        submit.setOpaque(false);
        submit.setForeground(Color.black);
        submit.setFont(font);
        submit.setBorder(new LineBorder(Color.lightGray, 1, true));
        submit.setBounds(140, 340, 40, 20);

        completeOneField = new JLabel("");
        completeOneField.setOpaque(false);
        completeOneField.setFont(font);
        completeOneField.setBounds(103, 360, 250, 20);

        proceed = new JLabel("Complete all fields in order to proceed:");
        proceed.setOpaque(false);
        proceed.setFont(font);
        proceed.setBounds(10, 190, 250, 20);

        firstName = new JTextField("first name");
        firstName.setOpaque(false);
        firstName.setForeground(Color.lightGray);
        firstName.setFont(font);
        firstName.setBorder(new LineBorder(Color.lightGray, 1, true));
        firstName.setBounds(110, 210, 100, 20);

        lastName = new JTextField("last name");
        lastName.setOpaque(false);
        lastName.setForeground(Color.lightGray);
        lastName.setFont(font);
        lastName.setBorder(new LineBorder(Color.lightGray, 1, true));
        lastName.setBounds(110, 235, 100, 20);

        personalNumericalCode = new JTextField("personal numerical code");
        personalNumericalCode.setOpaque(false);
        personalNumericalCode.setForeground(Color.lightGray);
        personalNumericalCode.setFont(font);
        personalNumericalCode.setBorder(new LineBorder(Color.lightGray, 1, true));
        personalNumericalCode.setBounds(110, 260, 100, 20);

        succesfullyUpdated = new JLabel("" );
        succesfullyUpdated.setFont(font);
        succesfullyUpdated.setOpaque(false);
        succesfullyUpdated.setBounds(101, 360, 160, 20);

        identityCardNumber = new JTextField("identity card number");
        identityCardNumber.setOpaque(false);
        identityCardNumber.setForeground(Color.lightGray);
        identityCardNumber.setFont(font);
        identityCardNumber.setBorder(new LineBorder(Color.lightGray, 1, true));
        identityCardNumber.setBounds(110, 285, 100, 20);

        address = new JTextField("address");
        address.setOpaque(false);
        address.setForeground(Color.lightGray);
        address.setFont(font);
        address.setBorder(new LineBorder(Color.lightGray, 1, true));
        address.setBounds(110, 310, 100, 20);

        mainPanel.add(submit);
        mainPanel.add(succesfullyUpdated);
        mainPanel.add(back);
        mainPanel.add(completeOneField);
        mainPanel.add(proceed);
        mainPanel.add(firstName);
        mainPanel.add(lastName);
        mainPanel.add(personalNumericalCode);
        mainPanel.add(identityCardNumber);
        mainPanel.add(address);

    }
    @Override
    public void resetValues() {
        this.succesfullyUpdated.setText("");
        this.setCompleteOneField("");
        this.firstName.setText("first name");
        this.lastName.setText("last name");
        this.personalNumericalCode.setText("personal numerical code");
        this.identityCardNumber.setText("identity card number");
        this.address.setText("address");
        this.firstName.setForeground(Color.lightGray);
        this.lastName.setForeground(Color.lightGray);
        this.personalNumericalCode.setForeground(Color.lightGray);
        this.identityCardNumber.setForeground(Color.lightGray);
        this.address.setForeground(Color.lightGray);
    }

    @Override
    public void addActionListener(ActionListener listener) {
        submit.addActionListener(listener);
        back.addActionListener(listener);
    }

    @Override
    public void addFocusListener(FocusListener listener) {
        firstName.addFocusListener(listener);
        lastName.addFocusListener(listener);
        personalNumericalCode.addFocusListener(listener);
        identityCardNumber.addFocusListener(listener);
        address.addFocusListener(listener);
    }

    public JTextField getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);
        this.firstName.setForeground(Color.black);
    }

    public JTextField getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
        this.lastName.setForeground(Color.black);
    }

    public JTextField getPersonalNumericalCode() {
        return personalNumericalCode;
    }

    public void setSucces(String succes){
        this.succesfullyUpdated.setText(succes);
    }

    public void setPersonalNumericalCode(String personalNumericalCode) {
        this.personalNumericalCode.setText(personalNumericalCode);
        this.personalNumericalCode.setForeground(Color.black);
    }

    public void setLastName(JTextField lastName) {
        this.lastName = lastName;
    }

    public JTextField getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber.setText(identityCardNumber);
        this.identityCardNumber.setForeground(Color.black);
    }

    public void setPersonalNumericalCode(JTextField personalNumericalCode) {
        this.personalNumericalCode = personalNumericalCode;
    }

    public JTextField getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address.setText(address);
        this.address.setForeground(Color.black);
    }

    public JButton getBack() {
        return back;
    }

    public void setProceed(JLabel proceed) {
        this.proceed = proceed;
    }

    public void setCompleteOneField(JLabel completeOneField) {
        this.completeOneField = completeOneField;
    }

    public String getProceed() {
        return proceed.getText();
    }

    public void setProceed(String proceed) {
        this.proceed.setText(proceed);
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public JLabel getSuccesfullyUpdated() {
        return succesfullyUpdated;
    }

    public void setSuccesfullyUpdated(JLabel succesfullyUpdated) {
        this.succesfullyUpdated = succesfullyUpdated;
    }

    public JLabel getCompleteOneField() {
        return completeOneField;
    }

    public void setCompleteOneField(String completeOneField) {
        this.completeOneField.setText(completeOneField);
    }

    public static void main(String[] args) {
        EmployeeUpdateRegister view = new EmployeeUpdateRegister();
        view.setVisible(true);
    }
}
