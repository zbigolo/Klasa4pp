package PAD_PierwszeMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu1 implements ActionListener {

    JMenuBar pasekMenu;
    JMenu plik;
    JMenu edycja;
    JMenuItem nowy;
    JMenuItem wytnij;

    public JPanel createContentPane(){
        JPanel mojpanel = new JPanel();

        pasekMenu = new JMenuBar();

        plik = new JMenu("FILE");
        edycja = new JMenu("EDIT");

        nowy = new JMenuItem("NEW");
        nowy.addActionListener(this);
        plik.add(nowy);

        wytnij = new JMenuItem("CUT");
        edycja.add(wytnij);

        pasekMenu.add(plik);
        pasekMenu.add(edycja);
        return mojpanel;
    }

    public Menu1() {

        JFrame frame = new JFrame("Pierwsze menu aplikacji");
        frame.setContentPane(createContentPane());
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);

        frame.setVisible(true);

         frame.setJMenuBar(pasekMenu);
    }


    public static void main(String[] args) {
            new Menu1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
