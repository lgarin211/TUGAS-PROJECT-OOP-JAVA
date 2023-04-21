package Project_Kelompok;

//Code Genarated by JGuiD
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrameKasir extends JFrame {
    JPanel panelUtamaAtas = new JPanel(new GridLayout(4, 2, 30, 0));
    JPanel panelUtamaBawah = new JPanel();
    JLabel hargaLabel = new JLabel("Harga");
    JTextField hargaField = new JTextField();
    JLabel namaPembeliLabel = new JLabel("Nama Pembeli");
    JTextField namaPembeliField = new JTextField();
    JLabel barangLabel = new JLabel("Pilih Barang");
    JComboBox barangField = new JComboBox();
    JLabel quantityLabel = new JLabel("Quantity");
    JTextField quantityField = new JTextField();

    String[] TableTitle = { "No", "Nama", "Harga", "Quantity" };
    Object[][] TableData = { { "1", "Baju", "Rp. 100.000", "2" }, { "2", "Celana", "Rp. 50.000", "1" },
            { "3", "Yoyo", "Rp. 50.000", "1" } };
    JDesktopPane desktopPane = new JDesktopPane();
    // DefaultTableModel tableModel = new DefaultTableModel(TableData, TableTitle);

    JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);
    JTable table = new JTable(TableData, TableTitle);
    JScrollPane scrollPane = new JScrollPane(table);

    public FrameKasir() {
        // panelUtamaAtas.setSize(200, 100);
        panelUtamaAtas.add(hargaLabel);
        panelUtamaAtas.add(namaPembeliLabel);
        panelUtamaAtas.add(hargaField);
        panelUtamaAtas.add(namaPembeliField);
        panelUtamaAtas.add(barangLabel);
        panelUtamaAtas.add(quantityLabel);
        panelUtamaAtas.add(barangField);
        panelUtamaAtas.add(quantityField);

        add(panelUtamaAtas, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        new FrameKasir();
    }
}