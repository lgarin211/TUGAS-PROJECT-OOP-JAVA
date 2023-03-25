import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FreamLihat extends JFrame {
    JLabel Lihat;
    JTable Table;
    JPanel TextPot;
    JButton Kembali;


    Object data[][] = { 
        { "1", "Baju", "Rp. 100.000", "2" }, 
        { "2", "Celana", "Rp. 50.000", "1" },
        { "1", "Baju", "Rp. 100.000", "2" }, 
        { "2", "Celana", "Rp. 50.000", "1" },
        { "1", "Baju", "Rp. 100.000", "2" }, 
        { "2", "Celana", "Rp. 50.000", "1" },
        { "1", "Baju", "Rp. 100.000", "2" }, 
        { "2", "Celana", "Rp. 50.000", "1" },
        { "1", "Baju", "Rp. 100.000", "2" }, 
        { "2", "Celana", "Rp. 50.000", "1" },
        { "1", "Baju", "Rp. 100.000", "2" }, 
        { "2", "Celana", "Rp. 50.000", "1" },
        { "1", "Baju", "Rp. 100.000", "2" }, 
        { "2", "Celana", "Rp. 50.000", "1" },
        
    };
    
    public FreamLihat() {
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void setupGUI() {
        Lihat = new JLabel();
        Lihat.setLocation(350, 0);
        Lihat.setSize(100, 100);
        Lihat.setText("Lihat Produk");
        Lihat.setToolTipText("");
        getContentPane().add(Lihat);


        TextPot = new JPanel();
        TextPot.setLocation(0, 100);
        TextPot.setSize(800, 400);
        // TextPot.setBorder(BorderFactory.createLineBorder(Color.red));   
        getContentPane().add(TextPot);
        String[] columnNames = { "No", "Nama", "Harga", "Quantity" };
        Table = new JTable(data, columnNames);
        Table.setPreferredScrollableViewportSize(new Dimension(700, 200));
        JScrollPane scrollPane = new JScrollPane(Table);
        TextPot.add(scrollPane);

        Kembali = new JButton();
		Kembali.setLocation(0, 10);
		Kembali.setSize(100, 50);
		Kembali.setText("Kembali");
		add(Kembali);


        setTitle("FreamLihat");
        setSize(800, 600);
        setVisible(true);
        setResizable(true);

    }

    public static void main(String args[]) {
        new FreamLihat();
    }
}
