package presentation.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.Calendar;

public class LogInView extends JFrame {

    private final Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
    private final Font bigFont = new Font("Trebuchet MS", Font.PLAIN, 12);
    private Calendar calendar;
    private String timeOfTheDay = "";
    private JTextField username;
    private JPasswordField password;
    private JButton signIn;
    private JLabel notFound;

    public LogInView(){

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        calendar = Calendar.getInstance();

        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        if(timeOfDay >= 0 && timeOfDay < 12){
            timeOfTheDay = "Good Morning";
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            timeOfTheDay = "Good Afternoon";
        }else timeOfTheDay = "Good Evening";

        notFound = new JLabel();
        notFound.setOpaque(false);
        notFound.setFont(font);
        notFound.setBounds(85, 270, 200, 20);

        JLabel time = new JLabel(timeOfTheDay);
        time.setOpaque(false);
        time.setFont(bigFont);
        time.setBounds(120, 10, time.getPreferredSize().width, time.getPreferredSize().height);

        JLabel picLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("city.jpeg").getImage().getScaledInstance(320, 150, Image.SCALE_AREA_AVERAGING));
        picLabel.setIcon(imageIcon);
        picLabel.setBounds(0, 30, picLabel.getPreferredSize().width, picLabel.getPreferredSize().height);

        username = new JTextField("username");
        username.setFont(font);
        username.setOpaque(false);
        username.setForeground(Color.lightGray);
        username.setBorder(new LineBorder(Color.lightGray, 1, true));
        username.setBounds(90, 190, 140, 20);

        password = new JPasswordField("password");
        password.setFont(font);
        password.setOpaque(false);
        password.setEchoChar((char)0);
        password.setForeground(Color.lightGray);
        password.setBackground(Color.lightGray);
        password.setBorder(new LineBorder(Color.lightGray, 1, true));
        password.setBounds(90, 215, 140, 20);

        signIn = new JButton("Sign in");
        signIn.setFont(font);
        signIn.setOpaque(false);
        signIn.setBorder(new LineBorder(Color.lightGray, 1, true));
        signIn.setBounds(130, 240, 50, 20);

        mainPanel.add(time);
        mainPanel.add(picLabel);
        mainPanel.add(username);
        mainPanel.add(password);
        mainPanel.add(signIn);
        mainPanel.add(notFound);
        this.setContentPane(mainPanel);
        this.setSize(320, 400);
        this.setLocation(600, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFont(font);
        //this.setVisible(true);
        this.setTitle("");
    }

    public String getUsername() {
        return username.getText();
    }

    public JTextField jgetUsername() {
        return username;
    }

    public JPasswordField jgetPassword(){
        return password;
    }

    public void setUsername(String username) {
        this.username.setText(username);
        this.username.setForeground(Color.black);
    }

    public String getPassword(){
        return password.getText();
    }

    public void setPassword(String password){
        this.password.setText(password);
        this.password.setForeground(Color.black);
        this.password.setEchoChar('\u2022');
    }

    public void addFocusListener(FocusListener textEvent){
        username.addFocusListener(textEvent);
        password.addFocusListener(textEvent);
    }

    public void resetValues(){
        this.username.setForeground(Color.lightGray);
        this.password.setForeground(Color.lightGray);
        this.username.setText("username");
        this.password.setText("password");
        this.setNotFound("");
        this.password.setEchoChar('\u0000');

    }

    public JButton getSignIn() {
        return signIn;
    }

    public void setSignIn(JButton signIn) {
        this.signIn = signIn;
    }

    public void addActionListener(ActionListener actionListener){
        signIn.addActionListener(actionListener);
    }

    public void setNotFound(String message){
        notFound.setText(message);
    }

    public static void main(String[] args) {
        LogInView view = new LogInView();
        view.setVisible(true);
    }
}
