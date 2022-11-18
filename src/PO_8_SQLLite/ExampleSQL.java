package PO_8_SQLLite;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExampleSQL {

    public static void main (String[] args) {
        Connection conn = null;

        String url = "jdbc:sqlite:./bases/";
        String filesdb = "DaneLinki.db";

        String[][] dane = new String[60][4];

        int i = 0;
        try {
            conn = DriverManager.getConnection(url+filesdb);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql = "SELECT id, tytul, przedmiot, nazwapliku FROM filmiki ORDER BY id";
        try (Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String id = Integer.toString(rs.getInt("id"));
                String tytul = rs.getString("tytul");
                String przedmiot = rs.getString("przedmiot");
                String name = rs.getString("nazwapliku");

                dane[i][0] = id;
                dane[i][1] = tytul;
                dane[i][2] = przedmiot;
                dane[i][3] = name;
                i++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

                String column[]={"ID","Tytuł","Przedmiot", "Nazwa pliku"};
                JFrame f = new JFrame("Table Example");
                JTable jt=new JTable(dane,column);

                jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF );
                jt.getColumnModel().getColumn(0).setPreferredWidth(30);
                jt.getColumnModel().getColumn(1).setPreferredWidth(450);
                jt.getColumnModel().getColumn(2).setPreferredWidth(60);
                jt.getColumnModel().getColumn(3).setPreferredWidth(220);
                jt.setBounds(30,40,800,300);


                JScrollPane sp=new JScrollPane(jt);
                f.add(sp);
                f.setSize(800,400);
                f.setVisible(true);



    }
}
