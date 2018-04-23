import java.text.DecimalFormat;

public class zad1 {

    public static void main (String[] args) {
        int argument = args.length;
        int[] intArg = new int[3];

        if (argument > 3)
        {
            int i = 0;
            System.out.println ("Po prostu wyświetle przekazane argumenty");
            while (argument > i)
                System.out.println ("Argument " + (i + 1) + " " + args[i++]);
            System.exit (0);
        }

        for(int i = 0; i < argument; i++)
        {
            try
            {
                intArg[i] = Integer.parseInt (args[i]);
            }
            catch (NumberFormatException e)
            {
                System.err.println ("Argument " + args[i] + " must be an integer.");
                System.exit (1);
            }
        }

        if (intArg[0] == 0)
        {
            System.err.println ("Dividing by 0");
            System.exit (3);
        }

        double delta = Math.pow (intArg[1], 2) - 4 * intArg[0] * intArg[2];
        if (delta < 0)
        {
            DecimalFormat f = new DecimalFormat("##.00");
            System.out.println("Dziedzina zespolona.");
            System.out.println("Bieguny równania:");
            System.out.println("  (" + (-intArg[1])/2*intArg[0] + " - " + f.format(Math.sqrt(-delta)) + "i)");
            System.out.println("  (" + (-intArg[1])/2*intArg[0] + " + " + f.format(Math.sqrt(-delta)) + "i)");
        }
        else if (delta == 0)
        {
            double x0 = -intArg[1] / (2 * intArg[0]);
            System.out.println ("Jedno Rozwiązanie");
            System.out.println ("   x0 = " + x0);
        }
        else
        {
            double x1 = (-intArg[1] - Math.sqrt(delta) / (2 * intArg[0]));
            double x2 = (-intArg[1] + Math.sqrt(delta) / (2 * intArg[0]));
            System.out.println("Dwa rozwjązania");
            System.out.println("   x1 = " + x1);
            System.out.println("   x2 = " + x2);
        }
        System.exit(0);
    }
}
