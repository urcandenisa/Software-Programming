package presentation.view;

import javax.swing.*;
import java.awt.*;

public class ChargingView extends JFrame {

    private final Font font = new Font("Trebuchet MS", Font.PLAIN, 13);

    public ChargingView(){

        JPanel mainPanel = new JPanel();
        JLabel picLabel = new JLabel();
        JLabel textLabel = new JLabel("Bank of America");
        textLabel.setFont(font);
        textLabel.setForeground(new Color(3, 9, 63));
        textLabel.setOpaque(false);

        JLabel textLabel2 = new JLabel("<html>WHAT WOULD YOU LIKE <br> &nbsp &nbsp THE POWER TO DO?</html>");
        textLabel2.setFont(font);
        textLabel2.setForeground(new Color(0, 6, 20));
        textLabel2.setOpaque(false);

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("bank.png").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING));
        picLabel.setIcon(imageIcon);

        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("giphy.gif").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel loading = new JLabel();
        loading.setIcon(imageIcon1);
        loading.setOpaque(false);

        mainPanel.setLayout(null);
        loading.setBounds(130, 200, loading.getPreferredSize().width, loading.getPreferredSize().height);
        picLabel.setBounds(80, 10, picLabel.getPreferredSize().width, picLabel.getPreferredSize().height);
        textLabel.setBounds(105, 170, 100, 20);
        textLabel2.setBounds(85, 250, 140, 50);

        mainPanel.add(loading);
        mainPanel.add(picLabel);
        mainPanel.add(textLabel);
        mainPanel.add(textLabel2);
        this.setContentPane(mainPanel);
        this.setSize(320, 400);
        this.setLocation(600, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFont(font);
        this.setVisible(true);
        this.setTitle("");
    }

    public static void main(String[] args) {
        ChargingView view = new ChargingView();

    }

}
