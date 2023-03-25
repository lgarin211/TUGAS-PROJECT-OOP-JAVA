//Code Genarated by JGuiD
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FreamMenu extends JFrame {
	JButton Menu;
	JButton Menu_2;
	JButton Menu_3;
	JButton Menu_4;

	public FreamMenu() {
		this.setLayout(null);
		setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void setupGUI() {
		Menu = new JButton();
		Menu.setLocation(100, 35);
		Menu.setSize(100, 100);
		Menu.setText("Tambah");
		add(Menu);

		Menu_2 = new JButton();
		Menu_2.setLocation(200, 35);
		Menu_2.setSize(100, 100);
		Menu_2.setText("Updata");
		add(Menu_2);

		Menu_3 = new JButton();
		Menu_3.setLocation(100, 135);
		Menu_3.setSize(100, 100);
		Menu_3.setText("Kasir");
		add(Menu_3);

		Menu_4 = new JButton();
		Menu_4.setLocation(200, 135);
		Menu_4.setSize(100, 100);
		Menu_4.setText("Lihat");
		add(Menu_4);

		setTitle("FreamMen");
		setSize(400, 400);
		setVisible(true);
		setResizable(true);

	}

	public static void main(String args[]) {
		new FreamMenu();
	}
}