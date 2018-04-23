import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;

public class zad6
{
    public static void main(String[] args)
    {
        TreeMap<NrTelefoniczny, Wpis> map = new TreeMap<>();

        Osoba oA = new Osoba("Jan", "Kowalski", "Łanowa", new NrTelefoniczny("041","983798797"));
        Osoba oB = new Osoba("Łukasz", "Starzak", "Malinowa", new NrTelefoniczny("042","313213211"));
        Osoba oC = new Osoba("Adam", "Jarzębski", "Srebrzynska", new NrTelefoniczny("043","456456456"));
        Osoba oD = new Osoba("Jacek", "Zieliński", "Traktorowa4", new NrTelefoniczny("044","123456789"));
        Osoba oE = new Osoba("Paweł", "Stępniewski", "Jaracza", new NrTelefoniczny("045","172858296"));
        Osoba oF = new Osoba("Ubimubłim", "Osas", "Łanowa", new NrTelefoniczny("046","859204758"));
        Osoba oG = new Osoba("Umar", "Naraka", "Malinowa", new NrTelefoniczny("047","225855856"));
        Osoba oH = new Osoba("Jerzy", "Maciejewski", "Srebrzynska", new NrTelefoniczny("048","194857295"));
        Osoba oI = new Osoba("Jurand", "Sprychowski", "Traktorowa4", new NrTelefoniczny("049","191919191"));
        Osoba oJ = new Osoba("Paweł", "Nowak", "Jaracza", new NrTelefoniczny("050","987654321"));

        Firma fA = new Firma("Junuszex", "Uniwersytecka",new NrTelefoniczny("042","885855855"));
        Firma fB = new Firma("Społem", "Stara",new NrTelefoniczny("042","800800800"));
        Firma fC = new Firma("Biedronka", "Zapyziała",new NrTelefoniczny("042","200200200"));
        Firma fD = new Firma("Złomex", "Zepsuta",new NrTelefoniczny("043","401402403"));
        Firma fE = new Firma("Schody", "Pokrętna",new NrTelefoniczny("043","505404606"));
        Firma fF = new Firma("Skoda", "Wolna 0",new NrTelefoniczny("042","789789456"));
        Firma fG = new Firma("Sukcesja", "Pusta",new NrTelefoniczny("045","343491917"));
        Firma fH = new Firma("Elektryczny", "Wsteczna",new NrTelefoniczny("045","753951654"));
        Firma fI = new Firma("Składaki", "Rdzawa",new NrTelefoniczny("045","654825159"));
        Firma fJ = new Firma("Żabka", "Brazylijska",new NrTelefoniczny("045","349167819"));

        map.put(fI.getNrTelefonu(), fI);
        map.put(oF.getNrTelefonu(), oF);
        map.put(fG.getNrTelefonu(), fG);
        map.put(oD.getNrTelefonu(), oD);
        map.put(fF.getNrTelefonu(), fF);
        map.put(oG.getNrTelefonu(), oG);
        map.put(fB.getNrTelefonu(), fB);
        map.put(oH.getNrTelefonu(), oH);
        map.put(fD.getNrTelefonu(), fD);
        map.put(oJ.getNrTelefonu(), oJ);
        map.put(fC.getNrTelefonu(), fC);
        map.put(oB.getNrTelefonu(), oB);
        map.put(fA.getNrTelefonu(), fA);
        map.put(fJ.getNrTelefonu(), fJ);
        map.put(oA.getNrTelefonu(), oA);
        map.put(oE.getNrTelefonu(), oE);
        map.put(oC.getNrTelefonu(), oC);
        map.put(fH.getNrTelefonu(), fH);
        map.put(fE.getNrTelefonu(), fE);
        map.put(oI.getNrTelefonu(), oI);


        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext())
            map.get(iterator.next()).opis();
    }
}

class NrTelefoniczny implements Comparable<NrTelefoniczny>
{
    private String kierunkowy;
    private String telefon;

    public String getNrKierunkowy()
    {
        return kierunkowy;
    }

    public String getNrTelefonu()
    {
        return telefon;
    }

    public NrTelefoniczny(String kierunkowy, String telefon)
    {
        this.kierunkowy = kierunkowy;
        this.telefon    = telefon;
    }

    @Override
    public int compareTo(NrTelefoniczny nr)
    {
        int nrKierunkowy = kierunkowy.compareTo(nr.kierunkowy);

        if(nrKierunkowy == 0)
            return telefon.compareTo(nr.telefon);
        else
            return nrKierunkowy;
    }
}

abstract class Wpis
{
    abstract void opis();
}

class Osoba extends Wpis
{
    private String          imie;
    private String          nazwisko;
    private String          adres;
    private NrTelefoniczny  telefon;

    public NrTelefoniczny getNrTelefonu()
    {
        return telefon;
    }

    public Osoba(String imie, String nazwisko, String adres, NrTelefoniczny telefon)
    {
        this.imie       = imie;
        this.nazwisko   = nazwisko;
        this.adres      = adres;
        this.telefon    = telefon;
    }

    @Override
    public void opis()
    {
        System.out.format("Imie: %-20s Nazwisko: %-15s Ulica: %-15s Nr telefonu: %-3s-%-20s\n", imie, nazwisko, adres, telefon.getNrKierunkowy(), telefon.getNrTelefonu());
    }
}

class Firma extends Wpis
{
    private String          nazwa;
    private String          adres;
    private NrTelefoniczny  telefon;

    public NrTelefoniczny getNrTelefonu()
    {
        return telefon;
    }

    public Firma(String nazwa, String adres, NrTelefoniczny telefon){
        this.nazwa = nazwa;
        this.adres = adres;
        this.telefon = telefon;
    }

    @Override
    public void opis()
    {
        System.out.format("Nazwa firmy: %-39s Ulica: %-15s Nr telefonu: %-3s-%-20s\n", nazwa, adres, telefon.getNrKierunkowy(), telefon.getNrTelefonu());
    }
}
