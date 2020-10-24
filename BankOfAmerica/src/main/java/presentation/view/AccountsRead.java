package presentation.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

public class AccountsRead extends Basic {

    private JList foundAccounts;
    private JButton back;
    private JButton update;
    private JLabel found;
    private JButton delete;
    private JButton create;
    private JLabel success;
    private JLabel notSelected;

    public AccountsRead(){

        found = new JLabel("");
        found.setFont(font);
        found.setOpaque(true);
        found.setBounds(10, 190, 200, 20);

        success = new JLabel("");
        success.setFont(font);
        success.setOpaque(true);
        success.setBounds(90, 315, 200, 20);

        notSelected = new JLabel("");
        notSelected.setFont(font);
        notSelected.setOpaque(true);
        notSelected.setBounds(50, 315, 300, 20);
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
        foundAccounts.setBounds(10, 210, 220, 50);
        
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

       create = new JButton("Register");
       create.setOpaque(false);
       create.setForeground(Color.black);
       create.setFont(font);
       create.setBorder(new LineBorder(Color.lightGray, 1, true));
       create.setBounds(110, 290, 90, 20);

       JLabel newAccount = new JLabel("Looking for a new account? Create here: ");
       newAccount.setOpaque(true);
       newAccount.setFont(font);
       newAccount.setBounds(50, 265, newAccount.getPreferredSize().width,  20);

       mainPanel.add(newAccount);
       mainPanel.add(create);
       mainPanel.add(found);
       mainPanel.add(foundAccounts);
       mainPanel.add(delete);
       mainPanel.add(back);
       mainPanel.add(notSelected);
       mainPanel.add(update);
       mainPanel.add(success);

    }
    public void setNotSelected(String notSelected){
        this.notSelected.setText(notSelected);
    }
    public JButton getCreate() {
        return create;
    }

    public void setCreate(JButton create) {
        this.create = create;
    }

    public JLabel getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success.setText(success);
    }

    @Override
    public void resetValues() {
        this.setFoundAccounts(new ArrayList<>());
        this.setSuccess("");
    }

    @Override
    public void addActionListener(ActionListener listener) {
        create.addActionListener(listener);
        back.addActionListener(listener);
        update.addActionListener(listener);
        delete.addActionListener(listener);
    }

    @Override
    public void addFocusListener(FocusListener listener) {
        this.foundAccounts.addFocusListener(listener);
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

    public JLabel getFound() {
        return found;
    }

    public void setFound(String found) {
        this.found.setText(found);
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public static void main(String[] args) {
        AccountsRead view = new AccountsRead();
        view.setVisible(true);
    }
}
