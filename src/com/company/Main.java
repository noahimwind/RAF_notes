package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws IOException {
        byte bf[] = {65, 84,73,87};
        int x = 1463654;
        double y = 37654.456;

        File file1 = new File("C:\\Users\\noah.duerkes\\Documents\\SWD_CD\\text2");
        RandomAccessFile raf = new RandomAccessFile(file1, "r");   // rw = read & write

        // write -----------------------------------------------------------------
        //  raf.write(bf);  // 4 Bytes -> "ATIW" weil das sind die ANSII Codes
        //  raf.write(45564);   // 1 Byte ( write ohne Parameter schreibt 1 Byte, aber Int wird übergeben ) -> Binär umwandeln und dann in der ANSII Tabelle gucken
        //  raf.writeInt(x);    // 4 Bytes
        //  raf.writeDouble(y); // 8 Bytes
        //  raf.writeBytes("ATIW"); // 4 Bytes -> ATIW ohne Null Bytes
        //  raf.writeChars("Willibald!");    // 20 Bytes ( 10 Characters x2 Bytes ) -> Null Byte vor jedem Character
        //  // = 41 Bytes

        // read ------------------------------------------------------------------
        System.out.println((char) raf.readByte()); // um das erste A auszulesen ( Zweierkomplement, also auch negative Zahlen )
        System.out.println((char) raf.read()); // um das erste A auszulesen

        // pointer ---------------------------------------------------------------
        System.out.println(raf.getFilePointer());   // Pointer steht an Stelle 2,weil wir bei 0 anfangen zu zählen
        raf.seek(9);    // 10. Byte um auf den Double zu kommen
        System.out.println(raf.readDouble());
        raf.skipBytes(4);   // 4 Bytes von ATIW überspringen ( man kann nicht wieder nach vorne mit skip )
        // Willibald ausgeben: (for Schleife, weil keine readCharS Methode
        for (int i = 0; i < 10; i++){
            System.out.println(raf.readChar());
        }
        raf.seek(39745);    // man kann mit Pointer auch hinter Dateiende gehen ( setzt aber überall NUL ein )

        raf.close();
    }
}
