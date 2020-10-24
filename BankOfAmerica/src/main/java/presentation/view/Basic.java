package presentation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

public abstract class Basic extends JFrame {
    protected final Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
    protected JPanel mainPanel;
    protected JLabel whichUser;
    public Basic(){

        whichUser = new JLabel();
        whichUser.setOpaque(false);
        whichUser.setFont(font);
        whichUser.setBounds(10, 3, 300, 20);

        JLabel picLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("city.jpeg").getImage().getScaledInstance(320, 150, Image.SCALE_AREA_AVERAGING));
        picLabel.setIcon(imageIcon);
        picLabel.setBounds(0, 30, picLabel.getPreferredSize().width, picLabel.getPreferredSize().height);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.add(whichUser);
        mainPanel.add(picLabel);
        this.setContentPane(mainPanel);
        this.setSize(320, 400);
        this.setLocation(600, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFont(font);
        //this.setVisible(true);
        this.setTitle("");
    }

    public JLabel getWhichUser() {
        return whichUser;
    }

    public void setWhichUser(String whichUser) {
        this.whichUser.setText("Welcome back, "+ whichUser + "!");
    }

    public abstract void resetValues();

    public abstract void addActionListener(ActionListener listener);

    public abstract void addFocusListener(FocusListener listener);

}
