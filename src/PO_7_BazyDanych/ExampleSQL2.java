package PO_7_BazyDanych;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ExampleSQL2 {


    public static void main (String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;
        ResultSetMetaData rsmd;

        String result = "0";
        try {
            InputStream input = new FileInputStream("example.properties");
            Properties ustawienia = new Properties();
            ustawienia.load(input);

            connection = DriverManager.getConnection(
                    ustawienia.getProperty("db.url") + ustawienia.getProperty("db.base"),
                    ustawienia.getProperty("db.user"),
                    ustawienia.getProperty("db.password"));

            System.out.println("OPERATION SQL II");

            String sqlQuery = "SELECT imie, pesel, pensja " +
                    "\n FROM osoba " +
                    "\n WHERE (pensja > ?) and (imie = ?);";

            pstmt = connection.prepareStatement(sqlQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            pstmt.setString(2, "Adrian");
            pstmt.setInt(1, 20000);

            rs = pstmt.executeQuery();

            rsmd = rs.getMetaData();

            int rowcount = 0;
            if (rs.last()) {
                rowcount = rs.getRow();
                rs.beforeFirst();
            }
            System.out.println(rsmd.getColumnName(1) + "\t" + rsmd.getColumnName(2) + "\t \t" + rsmd.getColumnName(3));
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" +
                        rs.getString(2) + "\t" + rs.getString(3));
            }
            System.out.println("-----------------------------------");
            System.out.println("Liczba wierszy: " + rowcount);

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            result = e.getSQLState();
            String msg = "SQLState: " + e.getSQLState() + "\n" +
                    "Error Code: " + e.getErrorCode() + " \n " +
                    "Message: " + e.getMessage();
            JOptionPane.showMessageDialog(
                    null,
                    msg,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (result.equals("0")) pstmt.close();
            connection.close();
        }
    }

}
