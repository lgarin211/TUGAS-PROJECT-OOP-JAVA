package Project_Kelompok;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

public class FrameUpdate extends JFrame implements ActionListener {
    private JLabel headerUpdateProduk = new JLabel("Update Produk");
    private JPanel centerPanel = new JPanel(new GridLayout(3,2));
    private JPanel footerPanel = new JPanel();
    private JComboBox list = new JComboBox();
    private JTextField updateHarga = new JTextField("Update Harga");
    private JTextField updateStok = new JTextField("Update Stok");
    private JLabel labelProduk = new JLabel("List Produk");
    private JLabel labelHarga = new JLabel("Update Harga");
    private JLabel labelStok = new JLabel("Update Stok");
    private JButton updateButton = new JButton("Update");
    private JLabel labelList = new JLabel("List Produk");
    public static ArrayList<String[]> dataProduk = new ArrayList<>();


    public static void main(String[] args) {


        String[] a={"Barang 1","1000","5"};
        String[] b={"Barang 2","2000","10"};
        String[] c={"Barang 3","3000","15"};

        dataProduk.add(a);
        dataProduk.add(b);
        dataProduk.add(c);

        new FrameUpdate();
    }


    public FrameUpdate(){
        headerUpdateProduk.setHorizontalAlignment(SwingConstants.CENTER);

        add(headerUpdateProduk, BorderLayout.NORTH);

        for (String[] st:dataProduk) {
            list.addItem(st[0]);
        }

        centerPanel.add(labelProduk);
        centerPanel.add(list);

        centerPanel.add(labelHarga);
        centerPanel.add(updateHarga);

        centerPanel.add(labelStok);
        centerPanel.add(updateStok);

        add(centerPanel);

        footerPanel.add(updateButton);
        add(footerPanel, BorderLayout.SOUTH);

        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int po=0;
                for (String [] li:dataProduk) {
                    if(li[0].equals(list.getSelectedItem())){
                        updateHarga.setText(dataProduk.get(po)[1]);
                        updateStok.setText(dataProduk.get(po)[2]);
                    }
                    po++;
                }

            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int po=0;
                for (String [] li:dataProduk) {
                    if(li[0].equals(list.getSelectedItem())){
                        dataProduk.get(po)[1] = updateHarga.getText();
                        dataProduk.get(po)[2] = updateStok.getText();
                    }
                    po++;
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}