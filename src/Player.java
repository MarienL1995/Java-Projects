import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Player {
    private String naam;
    private Rol klasse;
    private int levenspunten = 100;
    private int geestpunten = 100;
    private Item uitgerust;
    private Kamer locatie;
    private int aanvalsKracht = 0;
    private HashMap<Integer, Item> inventaris = new HashMap<>();
    private int tellerInventaris = 1;

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

    public void doorzoekKamer(){
        int teller  = 1;
        for (Meubel m : locatie.getMeubilair()) {
            System.out.println(teller + ": " + m.getOmschrijving());
            teller ++ ;
        }
        if (locatie.getMeubilair().size() > 0){
            kiesMeubel();
        }
    }
    public void kiesMeubel(){
       try {
           int keuze = Integer.parseInt(JOptionPane.showInputDialog(null, "Welke meubel ?"));
           Meubel m = locatie.getMeubilair().get(keuze);
           doorzoekMeubel(m);
       } catch (Exception e){
           System.out.println("Geen geldige keuze");
           kiesMeubel();
       }
    }

    public void doorzoekMeubel(Meubel m) { // gaat alle containers van het gekozen meubelStuk af.
        if (m.getContainers().size() > 0) {
            Iterator it = m.getContainers().values().iterator();
            int teller = 1;
            while (it.hasNext()) {
                Container c = (Container) it.next();
                System.out.println(teller + ": " + c.getNaam());
                teller++;
            }
            kiesContainer(m);
        } else {
            System.out.println("Meubel is leeg , kies een andere.");
            doorzoekKamer();
        }

    }

    public void kiesContainer(Meubel meubel) { // Vraagt naar de gekozen Container en gaat deze dan openen ( WIP )
        try {
            int keuze = Integer.parseInt(JOptionPane.showInputDialog(null, "Welke container ?"));
            Container c = meubel.getContainers().get(keuze);
            doorzoekContainer(c,meubel);
        } catch (Exception e){
            System.out.println("Geen geldige keuze");
            doorzoekMeubel(meubel);
        }
    }
    public void doorzoekContainer(Container container,Meubel meubel){
        if (container.inhoud.size()>0) {
            Iterator it = container.inhoud.values().iterator();
            int teller = 1;
            while (it.hasNext()) {
                Item i = (Item) it.next();
                System.out.println(teller + ": " + i.getNaam() + ": " + i.getOmschrijving());
                teller++;
            }
            maakKeuzeItem(container,meubel);
        } else {
            System.out.println("Container is leeg, kies een andere.");
            doorzoekMeubel(meubel);
        }
    }

    public void maakKeuzeItem(Container container,Meubel meubel) {
        try {
            int keuze = Integer.parseInt(JOptionPane.showInputDialog(null, "Welk item ?"));
            if (container.inhoud.size() > 0) {
                naarInvetaris(keuze, container,meubel);
            }

        } catch (Exception e){
            System.out.println("Geen geldige keuze");
            doorzoekContainer(container,meubel);
        }
    }
    public void naarInvetaris(Integer keuze,Container container,Meubel meubel){
        Iterator iteratorItems = container.inhoud.entrySet().iterator();
        while (iteratorItems.hasNext()){
            Map.Entry paar =(Map.Entry) iteratorItems.next();
            int sleutel = (int)paar.getKey();
            Item i = (Item) paar.getValue();
            System.out.println(sleutel);
            System.out.println(i);
            if (keuze == sleutel){
                inventaris.put(sleutel, (Item) paar.getValue());
                iteratorItems.remove();
            }
        }
        System.out.println(inventaris);
        doorzoekContainer(container,meubel);

    }

    @Override
    public String toString() {
        return "Player{" +
                "naam='" + naam + '\'' +
                ", klasse=" + klasse +
                ", levenspunten=" + levenspunten +
                ", geestpunten=" + geestpunten +
                ", uitgerust=" + uitgerust +
                ", locatie=" + locatie +
                ", aanvalsKracht=" + aanvalsKracht +
                ", inventaris=" + inventaris +
                ", tellerInventaris=" + tellerInventaris +
                '}';
    }
}
