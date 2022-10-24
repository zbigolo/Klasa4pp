package PO_7_BazyDanych;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ExampleSQL1 {

    public static void main (String[] args) throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs;
        ResultSetMetaData rsmd;

        int resultQuery;
        String result = "0";
        int errorCode = 0;
        try {
            InputStream input = new FileInputStream("example.properties");
            Properties ustawienia = new Properties();
            ustawienia.load(input);

            connection = DriverManager.getConnection(
                    ustawienia.getProperty("db.url") + ustawienia.getProperty("db.base"),
                    ustawienia.getProperty("db.user"),
                    ustawienia.getProperty("db.password"));


            System.out.println("OPERATION SQL I");

            String sqlQuery = "SELECT imie, pesel, pensja " +
                    "\n FROM osoba " +
                    "\n WHERE pensja > 1400;";

      //     stmt = connection.createStatement();

          stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                  ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sqlQuery);

            rsmd = rs.getMetaData();

            int rowcount = 0;
            if (rs.last()) {
                rowcount = rs.getRow();
                rs.beforeFirst();
            }
            System.out.println("Liczba wierszy: "+ rowcount);

            System.out.println("Liczba kolumn: " + rsmd.getColumnCount() );

            System.out.println(rsmd.getColumnName(1)+"\t" +rsmd.getColumnName(2)+"\t"+
                    rsmd.getColumnName(3));
            while(rs.next()){
                System.out.println( rs.getString(1) +
                        "\t"+ rs.getString(2)+
                        "\t" + rs.getString(3));
            }

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
            //if (result.equals("0")) pstmt.close();
            connection.close();
        }
    }
}
