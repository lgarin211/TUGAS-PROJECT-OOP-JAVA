package Project_Kelompok;
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

    JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);
    JTable table = new JTable(TableData, TableTitle);
    JScrollPane scrollPane = new JScrollPane(table);

    public FrameKasir() {
        panelUtamaAtas.add(hargaLabel);
        panelUtamaAtas.add(namaPembeliLabel);
        panelUtamaAtas.add(hargaField);
        panelUtamaAtas.add(namaPembeliField);
        panelUtamaAtas.add(barangLabel);
        panelUtamaAtas.add(quantityLabel);
        barangField.addItem("Pilih Barang");
        for (TambahProdukFrame L : main.DataProduk) {
            barangField.addItem(L.getNama());
        }
        panelUtamaAtas.add(barangField);
        panelUtamaAtas.add(quantityField);

        add(panelUtamaAtas, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String args[]) {
        new FrameKasir();
    }
}