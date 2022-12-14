package PO_3_ZapisDoPliku;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SampleFileOutputStream {
    public static void main(String[] args) throws IOException {
        File plikdanych = new File("save.png");
        File plikkopii = new File("savekopia.png");

        FileInputStream odczyt = null;
        FileOutputStream zapis = null;

        try{
            odczyt = new FileInputStream(plikdanych);
            zapis = new FileOutputStream(plikkopii);

            int bit = 0;
            while((bit = odczyt.read()) != -1){
                zapis.write(bit);
              //  System.out.print(bit);
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(odczyt != null) odczyt.close();
            if(zapis != null) zapis.close();
        }
    }
}
