package SlideShow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Przegladarka {
    private JButton wlewo;
    private JButton wprawo;
    private JLabel podpis;
    private JLabel window;
    private int next = 0;
    private BufferedImage myPicture;

    File dir = new File(".");

    File [] files;


    private JButton nawigacja(String text, int wspx){
        JButton button = new JButton(text);
        button.setBounds(wspx,520,100,20);
        button.setVisible(true);

        return button;
    }
    private JPanel createContentPane() throws IOException {


        JPanel myPanel = new JPanel(null);

        files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg");
            }
        });

        myPicture = ImageIO.read(new File(files[next].toURI()));
        Image resizemyPicture = myPicture.getScaledInstance(690, 400,
                Image.SCALE_SMOOTH);
        window = new JLabel(new ImageIcon(resizemyPicture));
        window.setBounds(50,50,700,400);
        window.setVisible(true);

        podpis = new JLabel(files[next].getName());
        podpis.setBounds(395,452,150, 30);
        podpis.setVisible(true);

        wprawo = nawigacja(">>",405);
        wlewo = nawigacja("<<",295);


        wprawo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {

                if (next < files.length-1){
                    next++;
                    try {
                        myPicture = ImageIO.read(new File(files[next].toURI()));
                        Image resizemyPicture = myPicture.getScaledInstance(690, 400,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(resizemyPicture);
                        window.setIcon(imageIcon);
                        podpis.setText(files[next].getName());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    next = 0;
                    try {
                        myPicture = ImageIO.read(new File(files[next].toURI()));
                        Image resizemyPicture = myPicture.getScaledInstance(690, 400,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(resizemyPicture);
                        window.setIcon(imageIcon);
                        podpis.setText(files[next].getName());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        wlewo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (next > 0){
                    next--;
                    try {
                        myPicture = ImageIO.read(new File(files[next].toURI()));
                        Image resizemyPicture = myPicture.getScaledInstance(690, 400,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(resizemyPicture);
                        window.setIcon(imageIcon);
                        podpis.setText(files[next].getName());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    next = files.length-1;
                    try {
                        myPicture = ImageIO.read(new File(files[next].toURI()));
                        Image resizemyPicture = myPicture.getScaledInstance(690, 400,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(resizemyPicture);
                        window.setIcon(imageIcon);
                        podpis.setText(files[next].getName());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        myPanel.add(window);myPanel.add(podpis);
        myPanel.add(wprawo); myPanel.add(wlewo);
        return myPanel;
    }

    public Przegladarka() throws IOException {
        JFrame frame = new JFrame("SlideShow Picture");
        frame.setContentPane(createContentPane());
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public static void main (String[] args) throws IOException {
            new Przegladarka();
    }

}
