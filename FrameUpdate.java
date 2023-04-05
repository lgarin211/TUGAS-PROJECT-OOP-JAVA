import javax.swing.*;

public class FrameUpdate extends JFrame {
    JComboBox list;
    JTextArea updateHarga;
    JTextArea updateStok;
    JLabel labelHarga;
    JLabel labelStok;
    JButton updateButton;


    public FrameUpdate(){
        getContentPane().setLayout(null);
        UpdateProduk();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void UpdateProduk(){
        //Ini buat dropdown combobox
        list = new JComboBox();
        list.setLocation(25,10);
        list.setSize(200,50);
        list.setEditable(false);
        getContentPane().add(list);

        //Ini buat update harganya
        updateHarga = new JTextArea();
//        updateHarga.setText("Update Harga");
        updateHarga.setLocation(150,100);
        updateHarga.setSize(200,50);
        updateHarga.setRows(5);
        updateHarga.setColumns(5);
        getContentPane().add(updateHarga);

        //label untuk updateHarga
        labelHarga = new JLabel("Update Harga");
        labelHarga.setLocation(25,100);
        labelHarga.setSize(200,50);
        getContentPane().add(labelHarga);

        //label untuk updateStok
        labelStok = new JLabel("Update Stok");
        labelStok.setLocation(25,200);
        labelStok.setSize(200,50);
        getContentPane().add(labelStok);

        //Ini buat update stoknya
        updateStok = new JTextArea();
//        updateStok.setText("Update Stok");
        updateStok.setLocation(150,200);
        updateStok.setSize(200,50);
        updateStok.setRows(5);
        updateStok.setColumns(5);
        getContentPane().add(updateStok);

        //Button update
        updateButton = new JButton();
        updateButton.setLocation(150, 300);
        updateButton.setSize(100,50);
        updateButton.setText("Update");
        getContentPane().add(updateButton);

        setTitle("Update");
        setSize(400,400);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args) {
        new FrameUpdate();
    }
}
