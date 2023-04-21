
//Code Genarated by JGuiD
package Project_Kelompok;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame {

    JTextArea Username;
    JPasswordField password;
    JButton untitled_3;
    JLabel TEXTOFALERT;


    public Login() {
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void setupGUI() {
        Username = new JTextArea();
        Username.setLocation(114, 114);
        Username.setSize(150, 30);
        Username.setText("LOGIN");
        Username.setRows(5);
        Username.setColumns(5);
        getContentPane().add(Username);

        password = new JPasswordField();
        password.setLocation(114, 144);
        password.setSize(150, 30);
        password.setText("Passwor");
        password.setColumns(10);
        password.setEchoChar('*');
        getContentPane().add(password);
        // get value password
        String pass = password.getText();

        untitled_3 = new JButton();
        untitled_3.setLocation(164, 175);
        untitled_3.setSize(100, 30);
        untitled_3.setText("Login");
        getContentPane().add(untitled_3);

        TEXTOFALERT = new JLabel();
        TEXTOFALERT.setLocation(50,210);
        TEXTOFALERT.setSize(300,50);
        TEXTOFALERT.setVisible(false);
        TEXTOFALERT.setHorizontalAlignment(JLabel.CENTER);
        TEXTOFALERT.setText("No_Label");
        getContentPane().add(TEXTOFALERT);


        setTitle("LOGIN");
        setSize(400, 400);
        setVisible(true);
        setResizable(true);

    }

    public static void main(String args[]) {
        new Login();
    }
}