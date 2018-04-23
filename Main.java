import java.io.*;
import java.nio.file.*;
import java.util.Random;

public class zad4
{
    public static void main(String[] args) throws IOException {
        String nameOfFirstFile    = "iof.txt",
               nameOfSecondFile   = "niof.txt";
        int    numberOfChars      = 1000;
        Random rand               = new Random();
        char[] storedChainOfChars = new char[numberOfChars];
        String buffer1,
               buffer2;

        //generownie łańcucha do zapisu
        for(int i = 0; i < numberOfChars; i++)
            storedChainOfChars[i] = ((char)(rand.nextInt(95) + 32));

        //tworzenie obiektów do plików
        IOFile  iof  = new IOFile();
        NIOFile niof = new NIOFile();

        //start
        //metoda io
        long ioFileWriteTime = System.currentTimeMillis();
        iof.write(nameOfFirstFile, storedChainOfChars);
        long ioFileReadTime = System.currentTimeMillis();
        buffer1 = iof.read(nameOfFirstFile, numberOfChars);
        long ioFileDoneTime = System.currentTimeMillis();

        //metoda nio
        long nioFileWriteTime = System.currentTimeMillis();
        niof.write(nameOfSecondFile, storedChainOfChars);
        long nioFileReadTime = System.currentTimeMillis();
        buffer2 = niof.read(nameOfSecondFile, numberOfChars);
        long nioFileDoneTime = System.currentTimeMillis();

        //wydruk wczytanych tekstów
        System.out.println("" +        "=+=+ buffer1 +=+=");
        System.out.println(buffer1);
        System.out.println("" + "\n" + "=+=+ buffer2 +=+=");
        System.out.println(buffer2);


        double iofSpeed  = ioFileDoneTime - ioFileWriteTime,
               niofSpeed = nioFileDoneTime - nioFileWriteTime;

        //informacje o czasie wykonania
        System.out.println( "" + "\n\nmetoda       Typ operacji      ilość mikrosekund\n" +
                            "---------+-------------------+-------------------");
        System.out.println( "" +
                            " iof     |   Total:      " +
                            "    |        " + (ioFileDoneTime - ioFileWriteTime) +
                            "\n         |   Write-Read: " +
                            "    |        " + (ioFileReadTime - ioFileWriteTime) +
                            "\n         |   Read-Done:  " +
                            "    |        " + (ioFileDoneTime - ioFileReadTime) +
                            "\n niof    |   Total:      " +
                            "    |        " + (nioFileDoneTime - nioFileWriteTime) +
                            "\n         |   Write-Read: " +
                            "    |        " + (nioFileReadTime - nioFileWriteTime) +
                            "\n         |   Read-Done:  " +
                            "    |        " + (nioFileDoneTime - nioFileReadTime));
        if(iofSpeed > niofSpeed)
            System.out.println("" + "metoda niof jest około " + Math.round((100 - (niofSpeed / iofSpeed) * 100)) + "% szybsza");
        if(iofSpeed < niofSpeed)
            System.out.println("" + "metoda iof jest około " + Math.round(100 - (iofSpeed / niofSpeed) * 100) + "% szybsza");
        else
            System.out.println("Obie metody [iof i niof] są tak samo szybkie");
    }
}

interface io
{
    void   write(String filename, char[] text) throws IOException;
    String read(String filename, int numberOfChars) throws IOException;
}

class IOFile implements io
{
    @Override
    public void write(String filename, char[] text) throws IOException
    {
        FileWriter fw = new FileWriter(filename);
        fw.write(text);
        fw.close();
    }

    @Override
    public String read(String filename, int numberOfChars) throws IOException
    {
        FileReader fr = new FileReader(filename);
        char[] charBuff = new char[numberOfChars];
        fr.read(charBuff);
        return String.valueOf(charBuff);
    }
}

class NIOFile implements io
{
    @Override
    public void write(String filename, char[] text) throws IOException
    {
        Files.write(Paths.get(filename), new String(text).getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
    }

    @Override
    public String read(String filename, int numberOfChars) throws IOException
    {
        return String.join("\n", Files.readAllLines(Paths.get(filename)));
    }
}
