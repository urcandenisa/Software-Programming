package presentation.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayBills extends Basic {
    private JButton back;
    private JList foundAccounts;
    private JList bills;
    private JTextField total;
    private JButton plus;
    private JButton minus;
    private JButton pay;
    private JLabel success;

    public PayBills(){

        JLabel first = new JLabel("Select one account in order to proceed:");
        first.setOpaque(false);
        first.setFont(font);
        first.setBounds(10, 190, 300, 20);

        back = new JButton("Back");
        back.setOpaque(false);
        back.setForeground(Color.black);
        back.setFont(font);
        back.setBorder(new LineBorder(Color.lightGray, 1, true));
        back.setBounds(10, 350, 40, 20);

        plus = new JButton("+");
        plus.setOpaque(false);
        plus.setForeground(Color.black);
        plus.setFont(font);
        plus.setBorder(new LineBorder(Color.lightGray, 1, true));
        plus.setBounds(280, 265, 20, 15);

        minus = new JButton("-");
        minus.setOpaque(false);
        minus.setForeground(Color.black);
        minus.setFont(font);
        minus.setBorder(new LineBorder(Color.lightGray, 1, true));
        minus.setBounds(280, 290, 20, 15);

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
        foundAccounts.setBounds(50, 210, 220, 40);

        bills  = new JList();
        bills.setCellRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setOpaque(false);
                return this;
            }
        });
        bills.setOpaque(false);
        bills.setFont(font);
        bills.setBorder(new LineBorder(Color.lightGray, 1, true));
        bills.setBounds(50, 265, 220, 40);


        List<String> list = new ArrayList<>();
        list.add("Electricity, 20.22");
        list.add("Internet, 50.22");
        list.add("Water, 20.22");
        this.setBills(list);

        pay = new JButton("Submit");
        pay.setOpaque(false);
        pay.setForeground(Color.black);
        pay.setFont(font);
        pay.setBorder(new LineBorder(Color.lightGray, 1, true));
        pay.setBounds(112, 330, 60, 20);


        JLabel second = new JLabel("your current bills: ");
        second.setOpaque(false);
        second.setFont(font);
        second.setBounds(10, 247, 220, 20);

        JLabel totalAmount = new JLabel("total amount to pay: ");
        totalAmount.setOpaque(false);
        totalAmount.setFont(font);
        totalAmount.setBounds(10, 302, totalAmount.getPreferredSize().width, 20);

        total = new JTextField("0");
        total.setOpaque(false);
        total.setForeground(Color.lightGray);
        total.setBorder(new LineBorder(Color.lightGray, 1, true));
        total.setFont(font);
        total.setEditable(false);
        total.setBounds(120, 307, 45, 20);

        success = new JLabel();
        //success.setText("Successfully paid! Check your account ;) ");
        success.setOpaque(false);
        success.setFont(font);
        success.setBounds(60, 350, 300, 20);

        mainPanel.add(pay);
        mainPanel.add(bills);
        mainPanel.add(success);
        mainPanel.add(second);
        mainPanel.add(back);
        mainPanel.add(minus);
        mainPanel.add(plus);
        mainPanel.add(first);
        mainPanel.add(total);
        mainPanel.add(totalAmount);
        mainPanel.add(foundAccounts);
    }
    @Override
    public void resetValues() {
        this.setFoundAccounts(new ArrayList<>());
        this.total.setText("amount");
        this.total.setForeground(Color.lightGray);
        this.success.setText("");
    }

    @Override
    public void addActionListener(ActionListener listener) {
        back.addActionListener(listener);
        plus.addActionListener(listener);
        minus.addActionListener(listener);
        pay.addActionListener(listener);
    }

    @Override
    public void addFocusListener(FocusListener listener) {
        foundAccounts.addFocusListener(listener);
        bills.addFocusListener(listener);
        total.addFocusListener(listener);
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

    public void setBills(List<?extends Object> billsList) {
        if(billsList == null) return;
        DefaultListModel<Object> list = new DefaultListModel<Object>();
        for(Object obj: billsList){
            list.addElement(obj);
        }
        if(list == null){
            bills = new JList();
            return;
        }
        bills.setModel(list);
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public void setFoundAccounts(JList foundAccounts) {
        this.foundAccounts = foundAccounts;
    }

    public JList getBills() {
        return bills;
    }

    public void setBills1(JList list){
        this.bills=list;
    }

    public JTextField getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total.setText(total);
        this.total.setForeground(Color.black);
    }

    public void setTotal(JTextField total) {
        this.total = total;
    }

    public JLabel getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success.setText(success);
    }

    public JButton getPlus() {
        return plus;
    }

    public void setPlus(JButton plus) {
        this.plus = plus;
    }

    public JButton getMinus() {
        return minus;
    }

    public void setMinus(JButton minus) {
        this.minus = minus;
    }

    public JButton getPay() {
        return pay;
    }

    public void setPay(JButton pay) {
        this.pay = pay;
    }

    public static void main(String[] args) {
        PayBills payBills = new PayBills();
        payBills.setVisible(true);
    }
}
