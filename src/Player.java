import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;

public class Player {
    private String naam;
    private Rol klasse;
    private int levenspunten = 100;
    private int geestpunten = 100;
    private Item uitgerust;
    private Kamer locatie;
    private int aanvalsKracht = 0;
    private HashMap<Integer, Item> inventaris = new HashMap<>();

    public Player(String naam, Rol klasse, Kamer locatie) {
        this.naam = naam;
        this.klasse = klasse;
        this.locatie = locatie;
    }

    public void VoegRolToe(Rol klasse) {
        levenspunten = levenspunten + klasse.getxLevenspunten();
        geestpunten = geestpunten + klasse.getxGeestpunten();
        aanvalsKracht = klasse.getxAanvalskracht();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Rol getKlasse() {
        return klasse;
    }

    public void setKlasse(Rol klasse) {
        this.klasse = klasse;
    }

    public int getLevenspunten() {
        return levenspunten;
    }

    public void setLevenspunten(int levenspunten) {
        this.levenspunten = levenspunten;
    }

    public int getGeestpunten() {
        return geestpunten;
    }

    public void setGeestpunten(int geestpunten) {
        this.geestpunten = geestpunten;
    }

    public Item getUitgerust() {
        return uitgerust;
    }

    public void setUitgerust(Item uitgerust) {
        this.uitgerust = uitgerust;
    }

    public Kamer getLocatie() {
        return locatie;
    }

    public void setLocatie(Kamer locatie) {
        this.locatie = locatie;
    }

    public void doorzoekMeubel(Meubel m) { // gaat alle containers van het gekozen meubelStuk af.
        Iterator it = m.getContainers().values().iterator();
        int teller = 0;
        while (it.hasNext()) {
            Container c = (Container) it.next();
            System.out.println(teller + ": " + c.getNaam());
            teller++;
        }

    }

    public void maakKeuzeContainer(Meubel meubel) { // Vraagt naar de gekozen Container en gaat deze dan openen ( WIP )
        boolean keuzeOk = false;
        int teller = 1;
        while (!keuzeOk)
            try {
                System.out.println("Voor test redenen de volledige container met spaties ingeven");
                String keuze = JOptionPane.showInputDialog(null, "Welke container ?");
                Iterator it = meubel.getContainers().values().iterator();
                while (it.hasNext()) {
                    Container c = (Container) it.next();
                    System.out.println(teller + ": " + c.getNaam());
                    keuzeOk = true;
                    if (keuze.toLowerCase() == c.getNaam().toLowerCase()) {
                        //  maakKeuzeItem(c.getNaam());
                    }
                }
            } catch (NullPointerException ignore) {
                System.out.println("Ongeldige keuze");
            }
    }

    public void maakKeuzeItem() {

    }
}
