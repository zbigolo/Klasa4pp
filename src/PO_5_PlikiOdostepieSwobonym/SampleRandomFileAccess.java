package PO_5_PlikiOdostepieSwobonym;


import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.*;

public class SampleRandomFileAccess {
    public static void main (String[] args) throws IOException {

        RandomAccessFile file = null;

        try {
            file = new RandomAccessFile("dane.dat", "rw");
            System.out.println("Rozmiar pliku dane.dat " + file.length());

            file.seek(0);
            int i=0;
            for (i = 10; i < 20; i++)
                file.writeInt(i);

            file.seek(0);
            long number = 0;
             i = 0;

            while ( file.getFilePointer() < file.length()){

                System.out.println(number +"  " + file.readInt());
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }

    }
}
