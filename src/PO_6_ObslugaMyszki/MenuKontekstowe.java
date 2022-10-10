package PO_6_ObslugaMyszki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuKontekstowe {

    private JPanel leftpanel;
    private JPanel rightpanel;
    private JMenuItem czerwone, szare, reset;
    private JMenuItem zolty, czarny, zielony;
    private JPopupMenu menuleft;
    private JPopupMenu menuright;

    private JPanel createPanel (int x, int dlugosc, Color tlo) {
        JPanel tmppanel = new JPanel(null);
        tmppanel.setBounds(x, 0, dlugosc, 200);
        tmppanel.setBackground(tlo);
        tmppanel.setVisible(true);
        return tmppanel;
    }

    public JPanel createContentPane () {
        JPanel myPanel = new JPanel(null);

        leftpanel = createPanel(0, 100, Color.blue);
        rightpanel = createPanel(200, 50, Color.green);

        menuleft = new JPopupMenu("Panel lewy");
        czerwone = new JMenuItem("RED");
        szare = new JMenuItem("GRAY");
        reset = new JMenuItem("BLUE");
        menuleft.add(czerwone);
        menuleft.add(szare);
        menuleft.add(reset);

        ActionListener leftListner = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "RED" -> {
                        leftpanel.setBackground(Color.red);
                        System.out.println("Zmian koloru tła panelu LEWEGO");
                    }

                    case "GRAY" -> {
                        leftpanel.setBackground(Color.gray);
                        System.out.println("Zmian koloru tła panelu LEWEGO");
                    }

                    case "BLUE" -> {
                        leftpanel.setBackground(Color.blue);
                        System.out.println("Zmian koloru tła panelu LEWEGO");
                    }

                }
            }
        };

        czerwone.addActionListener(leftListner);
        szare.addActionListener(leftListner);
        reset.addActionListener(leftListner);

        leftpanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getButton() == 3)
                    menuleft.show(leftpanel, e.getX(), e.getY());
            }
        });

        menuright = new JPopupMenu("Panel prawy");
        zolty = new JMenuItem("Yellow");
        czarny = new JMenuItem("Black");
        zielony = new JMenuItem("Green");
        menuright.add(zolty);
        menuright.add(czarny);
        menuright.addSeparator();
        menuright.add(zielony);

        ActionListener rightListner = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent evtr) {
                switch (evtr.getActionCommand()) {
                    case "Yellow" -> {
                        rightpanel.setBackground(Color.yellow);
                        System.out.println("Zmian koloru tła panelu PRAWEGO");
                    }

                    case "Black" -> {
                        rightpanel.setBackground(Color.black);
                        System.out.println("Zmian koloru tła panelu PRAWEGO");
                    }

                    case "Green" -> {
                        rightpanel.setBackground(Color.green);
                        System.out.println("Zmian koloru tła panelu PRAWEGO");
                    }
                }
            }
        };
        zolty.addActionListener(rightListner);
        czarny.addActionListener(rightListner);
        zielony.addActionListener(rightListner);

        rightpanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent evtr) {
                if (evtr.getButton() == 2)
                    menuright.show(rightpanel, evtr.getX(), evtr.getY());
            }
        });

        myPanel.add(leftpanel);
        myPanel.add(rightpanel);
        return myPanel;
    }

    public MenuKontekstowe () {
        JFrame myWindow = new JFrame("Menu Kontekstowe");
        myWindow.setContentPane(createContentPane());
        myWindow.setSize(600, 300);
        myWindow.setLayout(null);
        myWindow.setResizable(false);
        myWindow.setLocationRelativeTo(null);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setVisible(true);
    }

    public static void main (String[] args) {
        new MenuKontekstowe();
    }
}
