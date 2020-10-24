package presentation.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.List;

public class EmployeeUpdateDelete extends Basic {

    private JList showEmployee;
    private JButton update;
    private JButton delete;
    private JButton back;
    private JLabel successfullyDeleted;
    private JButton showAccounts;
    private JButton transferMoney;
    private JButton payBills;

    public  EmployeeUpdateDelete(){
        //inseamna ca s a introdus cnp u, si e validat corect

        back = new JButton("Back");
        back.setOpaque(false);
        back.setForeground(Color.black);
        back.setFont(font);
        back.setBorder(new LineBorder(Color.lightGray, 1, true));
        back.setBounds(10, 350, 40, 20);

        showEmployee =  new JList();
        showEmployee.setCellRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setOpaque(false);
                return this;
            }
        });
        showEmployee.setOpaque(false);
        showEmployee.setFont(font);
        showEmployee.setBorder(new LineBorder(Color.lightGray, 1, true));
        showEmployee.setBounds(10, 190, 220, 50);

        update = new JButton("Update");
        update.setOpaque(false);
        update.setForeground(Color.black);
        update.setFont(font);
        update.setBorder(new LineBorder(Color.lightGray, 1, true));
        update.setBounds(240, 190, 60, 20);

        transferMoney = new JButton("Transfer $");
        transferMoney.setOpaque(false);
        transferMoney.setForeground(Color.black);
        transferMoney.setFont(font);
        transferMoney.setBorder(new LineBorder(Color.lightGray, 1, true));
        transferMoney.setBounds(240, 220, 60, 20);

        showAccounts = new JButton("Show accounts");
        showAccounts.setOpaque(false);
        showAccounts.setForeground(Color.black);
        showAccounts.setFont(font);
        showAccounts.setBorder(new LineBorder(Color.lightGray, 1, true));
        showAccounts.setBounds(100, 245, 90, 20);

        delete = new JButton("Delete");
        delete.setOpaque(false);
        delete.setForeground(Color.black);
        delete.setFont(font);
        delete.setBorder(new LineBorder(Color.lightGray, 1, true));
        delete.setBounds(270, 220, 40, 20);

        JLabel text = new JLabel("Wanna pay bills instead? Check here:");
        text.setOpaque(false);
        text.setFont(font);
        text.setBounds(55, 265, 200, 20);

        payBills = new JButton("Pay bills");
        payBills.setOpaque(false);
        payBills.setForeground(Color.black);
        payBills.setFont(font);
        payBills.setBorder(new LineBorder(Color.lightGray, 1, true));
        payBills.setBounds(100, 285, 90, 20);


        successfullyDeleted = new JLabel("");
        successfullyDeleted.setOpaque(false);
        successfullyDeleted.setFont(font);
        successfullyDeleted.setBounds(70, 265, 130, 20);
        mainPanel.add(showEmployee);
        mainPanel.add(back);
        mainPanel.add(text);
        mainPanel.add(payBills);
        mainPanel.add(transferMoney);
        //mainPanel.add(successfullyDeleted);
        //mainPanel.add(delete);
        mainPanel.add(showAccounts);
        mainPanel.add(update);

    }
    @Override
    public void resetValues() {
        successfullyDeleted.setText("");
    }

    @Override
    public void addActionListener(ActionListener buttonListener) {
        this.back.addActionListener(buttonListener);
        this.delete.addActionListener(buttonListener);
        this.update.addActionListener(buttonListener);
        this.showAccounts.addActionListener(buttonListener);
        this.transferMoney.addActionListener(buttonListener);
        this.payBills.addActionListener(buttonListener);
    }

    @Override
    public void addFocusListener(FocusListener listener) {

    }

    public JList getShowEmployee() {
        return showEmployee;
    }

    public void setFoundEmployees(List<?extends Object> employees) {
        DefaultListModel<Object> list = new DefaultListModel<Object>();
        for(Object obj: employees){
            list.addElement(obj);
        }
        if(list == null){
            showEmployee = new JList();
            return;
        }
        showEmployee.setModel(list);
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

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public JLabel getSuccessfullyDeleted() {
        return successfullyDeleted;
    }

    public void setSuccessfullyDeleted(String successfullyDeleted) {
        this.successfullyDeleted.setText(successfullyDeleted);
    }

    public JButton getTransferMoney() {
        return transferMoney;
    }

    public void setTransferMoney(JButton transferMoney) {
        this.transferMoney = transferMoney;
    }

    public JButton getShowAccounts() {
        return showAccounts;
    }

    public void setShowAccounts(JButton showAccounts) {
        this.showAccounts = showAccounts;
    }

    public JButton getPayBills() {
        return payBills;
    }

    public void setPayBills(JButton payBills) {
        this.payBills = payBills;
    }

    public static void main(String[] args) {
        EmployeeUpdateDelete view = new EmployeeUpdateDelete();
        view.setVisible(true);
    }
}
