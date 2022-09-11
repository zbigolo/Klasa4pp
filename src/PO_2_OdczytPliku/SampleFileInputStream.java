package PO_2_OdczytPliku;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class SampleFileInputStream {
    public static void main (String[] args) throws IOException {
        File plik = new File("filmy.txt");

        FileInputStream odczyt = null;
        try {
            odczyt = new FileInputStream(plik);

            int num = 0;
            while ((num = odczyt.read()) != -1)
                System.out.print((char) num);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (odczyt != null) odczyt.close();
        }
    }
}
