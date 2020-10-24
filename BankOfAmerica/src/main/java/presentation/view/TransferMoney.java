package presentation.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.List;

public class TransferMoney extends Basic{

    private JButton back;
    private JList foundAccounts;
    private JTextField intoAccount;
    private JButton submit;
    private JLabel first;
    private JLabel second;
    private JLabel success;
    private JLabel fail;
    private JTextField amountOfMoney;


    public TransferMoney(){

        first = new JLabel("Transfer");
        first.setOpaque(false);
        first.setFont(font);
        first.setBounds(10, 190, 200,20);

        JLabel first1 = new JLabel("from account:");
        first1.setOpaque(false);
        first1.setFont(font);
        first1.setBounds(100, 190, 200,20);

        success = new JLabel("");
        success.setOpaque(false);
        success.setFont(font);
        success.setBounds(90, 327, 200,20);

        fail = new JLabel("Fail to transfer money!");
        fail.setOpaque(false);
        fail.setFont(font);
        fail.setBounds(107, 327, 200,20);

        second = new JLabel("into account: ");
        second.setOpaque(false);
        second.setFont(font);
        second.setBounds(10, 265, 200,20);

        back = new JButton("Back");
        back.setOpaque(false);
        back.setForeground(Color.black);
        back.setFont(font);
        back.setBorder(new LineBorder(Color.lightGray, 1, true));
        back.setBounds(10, 350, 40, 20);

        foundAccounts  = new JList();
        foundAccounts.setCellRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setOpaque(false);
                return this;
            }
        });
        foundAccounts.setOpaque(false);
        foundAccounts.setFont(font);
        foundAccounts.setBorder(new LineBorder(Color.lightGray, 1, true));
        foundAccounts.setBounds(50, 215, 220, 50);

        submit = new JButton("Submit");
        submit.setOpaque(false);
        submit.setForeground(Color.black);
        submit.setFont(font);
        submit.setBorder(new LineBorder(Color.lightGray, 1, true));
        submit.setBounds(140, 310, 40, 20);

        intoAccount = new JTextField("identification number");
        intoAccount.setForeground(Color.lightGray);
        intoAccount.setOpaque(false);
        intoAccount.setBorder(new LineBorder(Color.lightGray, 1, true));
        intoAccount.setFont(font);
        intoAccount.setBounds(50, 285, 220, 20);

        amountOfMoney = new JTextField("amount");
        amountOfMoney.setForeground(Color.lightGray);
        amountOfMoney.setOpaque(false);
        amountOfMoney.setBorder(new LineBorder(Color.lightGray, 1, true));
        amountOfMoney.setFont(font);
        amountOfMoney.setBounds(52, 190, 45, 20);

        mainPanel.add(amountOfMoney);
        mainPanel.add(back);
        mainPanel.add(foundAccounts);
        mainPanel.add(submit);
        mainPanel.add(intoAccount);
        mainPanel.add(first);
        mainPanel.add(first1);
        mainPanel.add(second);
        mainPanel.add(success);
        mainPanel.add(fail);

    }
    @Override
    public void resetValues() {
        this.intoAccount.setForeground(Color.lightGray);
        this.intoAccount.setText("identification number");
        this.amountOfMoney.setText("amount");
        this.amountOfMoney.setForeground(Color.lightGray);
    }

    @Override
    public void addActionListener(ActionListener listener) {
        back.addActionListener(listener);
        submit.addActionListener(listener);
    }

    @Override
    public void addFocusListener(FocusListener listener) {
        foundAccounts.addFocusListener(listener);
        intoAccount.addFocusListener(listener);
        amountOfMoney.addFocusListener(listener);
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public JList getFoundAccounts() {
        return foundAccounts;
    }

    public void setFoundAccounts(List<?extends Object> accounts) {
        if(accounts == null) return;
        DefaultListModel<Object> list = new DefaultListModel<Object>();
        for(Object obj: accounts){
            list.addElement(obj);
        }
        if(list == null){
            foundAccounts = new JList();
            return;
        }
        foundAccounts.setModel(list);
    }

    public JTextField getIntoAccount() {
        return intoAccount;
    }

    public void setIntoAccount(String intoAccount) {
        this.intoAccount.setText(intoAccount);
        this.intoAccount.setForeground(Color.black);
    }

    public JLabel getFirst() {
        return first;
    }

    public void setFirst(JLabel first) {
        this.first = first;
    }

    public JLabel getSecond() {
        return second;
    }

    public void setSecond(JLabel second) {
        this.second = second;
    }

    public JLabel getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success.setText(success);
    }

    public JLabel getFail() {
        return fail;
    }

    public void setFail(String fail) {
        this.fail.setText(fail);
    }

    public JTextField getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(String amountOfMoney) {
        this.amountOfMoney.setText(amountOfMoney);
        this.amountOfMoney.setForeground(Color.black);
    }

    public static void main(String[] args) {
        TransferMoney view = new TransferMoney();
        view.setVisible(true);
    }
}
