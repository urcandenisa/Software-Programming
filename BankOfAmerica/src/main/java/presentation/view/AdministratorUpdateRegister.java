package presentation.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

public class AdministratorUpdateRegister extends Basic {

    private JTextField firstName;
    private JTextField lastName;
    private JTextField personalNumericalCode;
    private JTextField username;
    private JPasswordField password;
    private JButton back;
    private JButton submit;
    private JLabel completeOneField;
    private JLabel succesfullyUpdated;
    private JLabel proceed;
    public AdministratorUpdateRegister(){
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

        proceed = new JLabel("");
        proceed.setOpaque(false);
        proceed.setFont(font);
        proceed.setBounds(10, 190, 250, 20);

        completeOneField = new JLabel("");
        completeOneField.setOpaque(false);
        completeOneField.setFont(font);
        completeOneField.setBounds(40, 360, 250, 20);

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
        succesfullyUpdated.setBounds(107, 360, 160, 20);

        username = new JTextField("username");
        username.setOpaque(false);
        username.setForeground(Color.lightGray);
        username.setFont(font);
        username.setBorder(new LineBorder(Color.lightGray, 1, true));
        username.setBounds(110, 285, 100, 20);

        password = new JPasswordField("password");
        password.setEchoChar('\u0000');
        password.setOpaque(false);
        password.setForeground(Color.lightGray);
        password.setFont(font);
        password.setBorder(new LineBorder(Color.lightGray, 1, true));
        password.setBounds(110, 310, 100, 20);

        mainPanel.add(submit);
        mainPanel.add(succesfullyUpdated);
        mainPanel.add(back);
        mainPanel.add(completeOneField);
        mainPanel.add(proceed);
        mainPanel.add(firstName);
        mainPanel.add(lastName);
        mainPanel.add(personalNumericalCode);
        mainPanel.add(username);
        mainPanel.add(password);

    }
    @Override
    public void resetValues() {
        this.succesfullyUpdated.setText("");
        firstName.setText("first name");
        firstName.setForeground(Color.lightGray);
        lastName.setText("last name");
        lastName.setForeground(Color.lightGray);
        personalNumericalCode.setForeground(Color.lightGray);
        personalNumericalCode.setText("personal numerical code");
        username.setText("username");
        username.setForeground(Color.lightGray);
        password.setText("password");
        password.setForeground(Color.lightGray);
        password.setEchoChar('\u0000');
        this.setCompleteOneField("");
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
        username.addFocusListener(listener);
        password.addFocusListener(listener);
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

    public JTextField getUsername() {
        return username;
    }

    public String getProceed() {
        return proceed.getText();
    }

    public void setProceed(String proceed) {
        this.proceed.setText(proceed);
    }

    public void setUsername(String username) {
        this.username.setText(username);
        this.username.setForeground(Color.black);
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password.setText(password);
        this.password.setEchoChar('*');
        this.password.setForeground(Color.black);
    }

    public JButton getBack() {
        return back;
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

}
