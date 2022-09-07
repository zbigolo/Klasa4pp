package PAD_PierwszeMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu1 implements ActionListener {

    JMenuBar pasekMenu;
    JMenu plik;
    JMenu edycja;
    JMenu pomoc;
    JMenuItem nowy;
    JMenuItem wytnij;
    JMenuItem koniec;
    JMenuItem help;

    public JPanel createContentPane(){
        JPanel mojpanel = new JPanel();

        pasekMenu = new JMenuBar();

        plik = new JMenu("File");
        edycja = new JMenu("Edit");
        pomoc = new JMenu("Help");

        nowy = new JMenuItem("New");
        nowy.addActionListener(this);
        plik.add(nowy);

        koniec = new JMenuItem("Exit");
        koniec.addActionListener(this);
        plik.add(koniec);

        wytnij = new JMenuItem("Cut");
        wytnij.addActionListener(this);
        edycja.add(wytnij);

        help = new JMenuItem("Info");
        help.addActionListener(this);
        pomoc.add(help);

        pasekMenu.add(plik);
        pasekMenu.add(edycja);
        pasekMenu.add(pomoc);
        return mojpanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Info"))
          JOptionPane.showMessageDialog(null,
                  "Wersja programu 1.00",
                  "Info",
                  JOptionPane.INFORMATION_MESSAGE);
        else
        if (command.equals("Exit")) System.exit(0);
          else
            JOptionPane.showMessageDialog(null,
                   "Wybrano " + command,
                    command,
                    JOptionPane.ERROR_MESSAGE);
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


}
