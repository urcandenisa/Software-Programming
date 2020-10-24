package presentation.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

public class AccountsUpdateRegister extends Basic {

    private JTextField amountOfMoney;
    private JTextField type;
    private JButton submit;
    private JLabel completeFields;
    private JButton back;
    private JLabel success;
    private JLabel first;

    public AccountsUpdateRegister(){
        super();
        first = new JLabel("");
        first.setOpaque(false);
        first.setFont(font);
        first.setBounds(10, 190, 300, 20);

        success = new JLabel("");
        success.setOpaque(false);
        success.setFont(font);
        success.setBounds(95, 290, 300, 20);

        amountOfMoney = new JTextField("amount of money");
        amountOfMoney.setOpaque(false);
        amountOfMoney.setForeground(Color.lightGray);
        amountOfMoney.setFont(font);
        amountOfMoney.setBorder(new LineBorder(Color.lightGray, 1, true));
        amountOfMoney.setBounds(110, 215, 100, 20);

        type = new JTextField("type");
        type.setOpaque(false);
        type.setForeground(Color.lightGray);
        type.setFont(font);
        type.setBorder(new LineBorder(Color.lightGray, 1, true));
        type.setBounds(110, 237, 100, 20);

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
        submit.setBounds(140, 262, 40, 20);

        completeFields = new JLabel("");
        completeFields.setOpaque(false);
        completeFields.setFont(font);
        completeFields.setBounds(105, 290, 250, 20);

        mainPanel.add(back);
        mainPanel.add(first);
        mainPanel.add(submit);
        mainPanel.add(completeFields);
        mainPanel.add(amountOfMoney);
        mainPanel.add(type);
        mainPanel.add(success);
    }

    @Override
    public void resetValues() {
        completeFields.setText("");
        success.setText("");
        amountOfMoney.setForeground(Color.lightGray);
        type.setForeground(Color.lightGray);
        amountOfMoney.setText("amount of money");
        type.setText("type");
    }

    @Override
    public void addActionListener(ActionListener listener) {
        back.addActionListener(listener);
        submit.addActionListener(listener);
    }

    @Override
    public void addFocusListener(FocusListener listener) {
        amountOfMoney.addFocusListener(listener);
        type.addFocusListener(listener);
    }

    public JLabel getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success.setText(success);
    }

    public JTextField getamountOfMoney() {
        return amountOfMoney;
    }

    public void setamountOfMoney(String amountOfMoney) {
        this.amountOfMoney.setText(amountOfMoney);
        this.amountOfMoney.setForeground(Color.black);
    }
    
    public JTextField getTypeAccount() {
        return type;
    }

    public void setType(String type) {
        this.type.setText(type);
        this.type.setForeground(Color.black);
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public JLabel getCompleteFields() {
        return completeFields;
    }

    public void setCompleteFields(String completeFields) {
        this.completeFields.setText(completeFields);
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public JLabel getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first.setText(first);
    }

    public static void main(String[] args) {
        AccountsUpdateRegister view = new AccountsUpdateRegister();
        view.setVisible(true);
    }
}
