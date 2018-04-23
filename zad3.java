import java.util.Scanner;
import java.util.Random;

public class zad3
{
    public static void main (String [] args)
    {
        Boolean doYouWannaPlayAgain = false;
        int widthOfTheCompartment = 100;
        do
        {
            Scanner userInput = new Scanner(System.in);
            Random generator = new Random();
            int magicNumber = generator.nextInt(widthOfTheCompartment + 1);                                      // + 1, aby zapewnić przedział <0, 200>
                                                                                                                        // magicNumber <- wylosowana liczba
            System.out.println("" + "Wylosowana liczba jest z przedziału 0:" + widthOfTheCompartment);
            System.out.println("Zgadnij co to za liczba");
            System.out.println("" + "Podpowiedź: Liczba = " + magicNumber);
            for (int attemptCounter = 0; ; attemptCounter++)
            {
                int choice = userInput.nextInt();
                if (choice < magicNumber)
                    System.out.println("Podana liczba jest mniejsza niż szukana");
                else if (choice > magicNumber)
                    System.out.println("Podana liczba jest większa niż szukana");
                else
                {
                    System.out.println("" + "Trafione za " + (attemptCounter + 1) + " razem");
                    break;
                }
            }
            System.out.println("Czy chcesz zagrać jeszcze raz? [false - nie, true - tak]: ");
            userInput.nextLine();                                                                                       //czyszczenie bufora
            doYouWannaPlayAgain = Boolean.valueOf(userInput.nextLine());
        } while (doYouWannaPlayAgain == true);
    }
}
