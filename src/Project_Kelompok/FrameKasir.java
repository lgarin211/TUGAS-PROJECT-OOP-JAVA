package Project_Kelompok;
//Code Genarated by JGuiD
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameKasir extends JFrame {
    JLabel LKasir;
    JTextArea Nama;
    // input number
    JTextArea Harg;
    JTextArea QTY;
    JComboBox Barang;
    JPanel TextPot;
    JLabel Label;
    JLabel Label_2;
    JLabel Label_3;
    JLabel Label_4;

    JTable Table;

    Object data[][] = { { "1", "Baju", "Rp. 100.000", "2" }, { "2", "Celana", "Rp. 50.000", "1" } };

    public Object table;

    public FrameKasir() {
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void setupGUI() {
        LKasir = new JLabel();
        LKasir.setLocation(450, 0);
        LKasir.setSize(100, 50);
        LKasir.setText("Kasir");
        LKasir.setToolTipText("");
        getContentPane().add(LKasir);

        Nama = new JTextArea();
        Nama.setLocation(600, 150);
        Nama.setSize(200, 50);
        Nama.setText("Nama Pembeli");
        Nama.setRows(5);
        Nama.setColumns(5);
        getContentPane().add(Nama);

        Harg = new JTextArea();
        Harg.setLocation(100, 150);
        Harg.setSize(200, 50);
        Harg.setText("Harga");
        Harg.setRows(5);
        Harg.setColumns(5);
        getContentPane().add(Harg);

        QTY = new JTextArea();
        QTY.setLocation(600, 240);
        QTY.setSize(200, 50);
        QTY.setText("Quantity");
        QTY.setRows(5);
        QTY.setColumns(5);
        getContentPane().add(QTY);

        Barang = new JComboBox();
        Barang.addItem("BARANG 2");
        Barang.addItem("BARANG 1");
        Barang.addItem("BARANG 3");

        Barang.setLocation(100, 240);
        Barang.setSize(200, 50);
        Barang.setEditable(false);
        getContentPane().add(Barang);

        Label = new JLabel();
        Label.setLocation(100, 210);
        Label.setSize(100, 30);
        Label.setText("Pilih Barang");
        getContentPane().add(Label);

        Label_2 = new JLabel();
        Label_2.setLocation(100, 120);
        Label_2.setSize(100, 30);
        Label_2.setText("Harga");
        getContentPane().add(Label_2);

        Label_3 = new JLabel();
        Label_3.setLocation(600, 120);
        Label_3.setSize(100, 30);
        Label_3.setText("Nama Pembeli");
        getContentPane().add(Label_3);

        Label_4 = new JLabel();
        Label_4.setLocation(600, 210);
        Label_4.setSize(100, 30);
        Label_4.setText("Quantity");
        getContentPane().add(Label_4);

        TextPot = new JPanel();
        TextPot.setLocation(100, 300);
        TextPot.setSize(800, 150);
        // border red
        TextPot.setBorder(BorderFactory.createLineBorder(Color.red));
        getContentPane().add(TextPot);

        String[] columnNames = { "No", "Nama", "Harga", "Quantity" };
        Table = new JTable(data, columnNames);
        Table.setPreferredScrollableViewportSize(new Dimension(600, 100));
        JScrollPane scrollPane = new JScrollPane(Table);
        TextPot.add(scrollPane);

        setTitle("Kasir");
        setSize(1000, 500);
        setVisible(true);
        setResizable(false);

    }

    public static void main(String args[]) {
        new FrameKasir();
    }
}