package PO_1_OdczytPliku;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SampleScannerFile {
    public static void main(String[] args)  {
        File plik = new File("filmy.txt");
        Scanner input =null;

        String line = null;

        try{
            input = new Scanner(plik);
            while(input.hasNextLine() ){
              //  System.out.println(input.nextLine());,

                line = input.nextLine();
                System.out.println(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(input != null) input.close();
        }

    }
}
