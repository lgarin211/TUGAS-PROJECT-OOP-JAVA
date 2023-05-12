package Project_Kelompok;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame {
    private JTextArea Username;
    private JPasswordField password;
    private JButton TombolLogin;
    protected JLabel TEXTOFALERT;

    public static void main(String args[]) {
        new Login();
    }

    public Login() {
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setupGUI() {
        Username = new JTextArea();
        Username.setLocation(114, 114);
        Username.setSize(150, 30);
        Username.setText("admin");
        Username.setRows(5);
        Username.setColumns(5);
        getContentPane().add(Username);

        password = new JPasswordField();
        password.setLocation(114, 144);
        password.setSize(150, 30);
        password.setText("");
        password.setColumns(10);
        password.setEchoChar('*');
        getContentPane().add(password);

        String pass = password.getText();

        TombolLogin = new JButton();
        TombolLogin.setLocation(164, 175);
        TombolLogin.setSize(100, 30);
        TombolLogin.setText("LOGIN");
        getContentPane().add(TombolLogin);

        TEXTOFALERT = new JLabel();
        TEXTOFALERT.setLocation(50, 210);
        TEXTOFALERT.setSize(300, 50);
        TEXTOFALERT.setVisible(false);
        TEXTOFALERT.setHorizontalAlignment(JLabel.CENTER);
        TEXTOFALERT.setText("No_Label");
        getContentPane().add(TEXTOFALERT);

        setTitle("LOGIN");
        RunLogin();
        this.setSize(400, 300);
        setVisible(true);
        setResizable(true);

    }

    private void RunLogin() {
        TombolLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Mail = Username.getText();
                String Pass = password.getText();
                RunLogin(Mail, Pass);
            }
        });
    }

    private void RunLogin(String Mail, String Pass) {
        if (Mail.equals("admin") && Pass.equals("admin")) {
            System.out.println("Login Success");
            TEXTOFALERT.setText("Login Berhasil \nSelamat Datang " + Mail);
            TEXTOFALERT.setVisible(true);
            try {
                Thread.sleep(1000);
                this.dispose();
                new FrameMenu();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login Fail");
            TEXTOFALERT.setText("Login Gagal \nSilahkan Coba Lagi");
            TEXTOFALERT.setVisible(true);
        }
    }

}