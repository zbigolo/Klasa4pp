package PO_7_BazyDanych;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ExampleInsertandUpdateTable {

    public static void main (String[] args) throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        int resultQuery;
        String result = "0";
        int errorCode = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/";
            InputStream input = new FileInputStream("example.properties");
            Properties ustawienia = new Properties();
            ustawienia.load(input);

            connection = DriverManager.getConnection(
                    ustawienia.getProperty("db.url") + ustawienia.getProperty("db.base"),
                    ustawienia.getProperty("db.user"),
                    ustawienia.getProperty("db.password"));

            stmt = connection.createStatement();
            System.out.println("OPERATION INSERT");

            String insertdate = "INSERT INTO Osoba(pesel, imie, pensja) \n" +
                    "VALUES \n" +
                    "('92060982918', 'Marian', 1500), \n "+
                    "('54072921336', 'Tomasz',4000), \n "+
                    "('81043057675', 'Adrian',3500);";

            resultQuery = stmt.executeUpdate(insertdate);
            if (resultQuery > 0)
                System.out.println("Do tabeli Osoba wstawiono " + resultQuery + " wiersze");

            System.out.println("\n OPERATION UPDATE");
            String updatedate = "UPDATE Osoba \n" +
                    "SET pensja = 21400 \n" +
                    "WHERE imie = 'Adrian';";

            resultQuery = stmt.executeUpdate(updatedate);
            if (resultQuery > 0)
                System.out.println("W tabeli Osoba zaktualizowano " + resultQuery + " wierszy");

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch(SQLException e){
            result = e.getSQLState();
            String msg = "SQLState: " + ((SQLException)e).getSQLState() +"\n"+
                    "Error Code: " + ((SQLException)e).getErrorCode() +" \n " +
                    "Message: " + e.getMessage();
            JOptionPane.showMessageDialog(
                    null,
                    msg,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        finally {
            if (result.equals("0")) stmt.close();
            connection.close();

        }
    }

}
