import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.lang.String;

public class zad5
{

    public static void main(String[] args) throws IOException
    {
        Vector<Double> vecA = null,
                       vecB = null,
                       vecS = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean loop;
        do
        {
            loop = false;

            System.out.println("Podaj pierwszy wektor: ");
            vecA = readLine(br.readLine());

            System.out.println("Podaj drugi wektor: ");
            vecB = readLine(br.readLine());

            try
            {
                vecS = sumVector(vecA, vecB);
            }
            catch (WektoryRoznejDlugosciException e)
            {
                System.out.println(e.getMessage() + " " + e.vecASize + " jest rozne od " + e.vecBSize);
                System.out.println("Sproboj ponownie!");
                loop = true;
            }
        }while(loop);

        System.out.println("A: " + vecA.toString());
        System.out.println("B: " + vecB.toString());
        System.out.println("S: " + vecS.toString());

        saveToFile("sum.txt", vecS);
    }

    static Vector<Double> readLine(String line)
    {
        Vector<Double> temp = new Vector<>();
        Scanner scanner = new Scanner(line);

        while(scanner.hasNext())
        {
            if(scanner.hasNextDouble())
                temp.add(scanner.nextDouble());
            else
                scanner.next();
        }
        scanner.close();

        return temp;
    }

    static Vector<Double> sumVector(Vector<Double> vecA, Vector<Double> vecB) throws WektoryRoznejDlugosciException
    {
        if(vecA.size() != vecB.size())
            throw new WektoryRoznejDlugosciException(vecA.size(), vecB.size());

        Vector<Double> temp = new Vector<>();

        for(int i = 0; i < vecA.size(); i++)
            temp.add(vecA.elementAt(i) + vecB.elementAt(i));

        return temp;
    }

    static void saveToFile(String filename, Vector<Double> vector) throws IOException
    {
        FileWriter fw = new FileWriter(filename);
        fw.write(vector.toString());
        fw.close();
    }
}

class WektoryRoznejDlugosciException extends Exception
{
    public int vecASize;
    public int vecBSize;

    public WektoryRoznejDlugosciException(int vecASize, int vecBSize)
    {
        super("Wektory Roznej Dlugosci Exception");
        this.vecASize = vecASize;
        this.vecBSize = vecBSize;
    }
}
