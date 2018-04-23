public class zad2
{
    public static void main(String[] args) throws Exception
    {
        if(args.length != 3)
            throw new Exception("" + "Powinieneś podać 3 argumenty a podałeś " + args.length);

        int a, b;
        String tekst = args[0];

        try
        {
            a = Integer.parseInt(args[1]);
        } catch(NumberFormatException e)
          {
              throw new Exception("Drugi argument nie jest liczbą");
          }

        try
        {
            b = Integer.parseInt(args[2]);
        } catch(NumberFormatException e)
          {
              throw new Exception("Trzeci argument nie jest liczbą");
          }

        if(a <= 0)
            throw new Exception("Argument oznaczający początek podciągu jest ujemny");
        if(b <= 0)
            throw new Exception("Argument oznaczający koniec podciągu jest ujemny");
        if(a > b)
            throw new Exception("Argument oznaczający początek podciągu jest większy od argumentu oznaczającego koniec podziągu");
        if(b >= tekst.length())
            throw new Exception("trzeci argument jest większy niż całkowita długość argumentu pierwszego");

        System.out.println("" + tekst + " " + a + " " + b + " ");
        System.out.println(tekst.substring(a-1, b));
    }
}
