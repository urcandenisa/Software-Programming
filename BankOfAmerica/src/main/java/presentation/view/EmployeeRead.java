package presentation.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

public class EmployeeRead extends Basic {

    private JTextField personalNumericalCode;
    private JButton submit;
    private JButton register;
    private JLabel noMatching;
    private JButton back;

    public EmployeeRead(){
        super();

        JLabel introduceClient = new JLabel("Introduce client's personal numerical code: ");
        introduceClient.setOpaque(false);
        introduceClient.setFont(font);
        introduceClient.setBounds(60, 190, introduceClient.getPreferredSize().width, introduceClient.getPreferredSize().height);

        noMatching = new JLabel("");
        noMatching.setOpaque(false);
        noMatching.setFont(font);
        noMatching.setForeground(Color.black);
        noMatching.setBounds(110,   290, 200, 20);

        personalNumericalCode = new JTextField("personal numerical code");
        personalNumericalCode.setOpaque(false);
        personalNumericalCode.setForeground(Color.lightGray);
        personalNumericalCode.setFont(font);
        personalNumericalCode.setBorder(new LineBorder(Color.lightGray, 1, true));
        personalNumericalCode.setBounds(90, 205, 150, 20);

        submit = new JButton("Submit  ");  // asta e R-ul de fapt, read din CRUD
        submit.setOpaque(false);
        submit.setForeground(Color.black);
        submit.setFont(font);
        submit.setBorder(new LineBorder(Color.lightGray, 1, true));
        submit.setBounds(135, 230, submit.getPreferredSize().width, submit.getPreferredSize().height);

        JLabel registerClient = new JLabel("New client? Register here: ");
        registerClient.setOpaque(false);
        registerClient.setFont(font);
        registerClient.setBounds(100, 250, registerClient.getPreferredSize().width, registerClient.getPreferredSize().height);

        register = new JButton("Register"); // asta e C-ul, create
        register.setOpaque(false);
        register.setForeground(Color.black);
        register.setFont(font);
        register.setBorder(new LineBorder(Color.lightGray, 1, true));
        register.setBounds(135, 270, register.getPreferredSize().width, register.getPreferredSize().height);

        back = new JButton("Back");
        back.setOpaque(false);
        back.setForeground(Color.black);
        back.setFont(font);
        back.setBorder(new LineBorder(Color.lightGray, 1, true));
        back.setBounds(10, 350, 40, 20);

        mainPanel.add(registerClient);
        mainPanel.add(noMatching);
        mainPanel.add(back);
        mainPanel.add(introduceClient);
        mainPanel.add(personalNumericalCode);
        mainPanel.add(register);
        mainPanel.add(submit);
    }

    public JTextField getPersonalNumericalCode() {
        return personalNumericalCode;
    }

    public void setNoMatching(String message){
        this.noMatching.setText(message);
    }
    public void setPersonalNumericalCode(String personalNumericalCode) {
        this.personalNumericalCode.setText(personalNumericalCode);
        this.getPersonalNumericalCode().setForeground(Color.black);
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

    @Override
    public void resetValues() {
        this.personalNumericalCode.setText("personal numerical code");
        this.personalNumericalCode.setForeground(Color.lightGray);
    }

    @Override
    public void addActionListener(ActionListener listener) {
        submit.addActionListener(listener);
        back.addActionListener(listener);
        register.addActionListener(listener);
    }

    @Override
    public void addFocusListener(FocusListener listener) {
        personalNumericalCode.addFocusListener(listener);
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public static void main(String[] args) {
        EmployeeRead view = new EmployeeRead();
        view.setVisible(true);
    }
}
