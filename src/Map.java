import javax.swing.*;
import java.util.*;
import java.util.Map.Entry;

public class Map {
    private String naam;
    private HashMap<Integer, Kamer> plattegrondRuw = new HashMap<>();
    private Kamer huidigelocatie;

    public Map(String naam) {
        this.naam = naam;
    }

    public void GenereerMap(ArrayList<Kamer> lijstLocaties) { // Functie voor het vullen van de plattegrond met meerdere kamers //
        ArrayList<Kamer> hulpLijst = lijstLocaties;
        System.out.println(hulpLijst);

     /*   ArrayList<Integer> hulpArray = new ArrayList<>(); // Hier heb ik de hoop opgegeven om mijn Kamers random te plaatsen op de Map //
        Kamer k = lijstLocaties.get(0);
        hulpArray = k.getAangrenzend();
        Kamer k2 = lijstLocaties.get(1);
        k2.setAangrenzend(k.getAangrenzend());
        for (int i = 2; i < lijstLocaties.size(); i++) {
            for (int j = 0; j < lijstLocaties.get(i).getAangrenzend().size(); j++) {
                System.out.println(lijstLocaties.get(i).getAangrenzend().get(j));
                if (lijstLocaties.get(i).getAangrenzend().get(j) == 0){

                }
            }
        }*/
        for (int i = 0; i < hulpLijst.size(); i++) {
            plattegrondRuw.put(i, hulpLijst.get(i));
        }
    }

    public void Verplaats() { // Om zich te verplaatsen over de plattegrond //

        boolean nietbeschikbaar = true;
        while (nietbeschikbaar) {

            System.out.println("Geef een richting");
            String gekozenrichting = JOptionPane.showInputDialog("welke richting ?");
            System.out.println(gekozenrichting);
            int richting = controleerToegelaten(gekozenrichting);
            while (richting <= 0) {
                System.out.println("Geen geldige richting");
                gekozenrichting = JOptionPane.showInputDialog("Geef een richting in");
                try {
                    richting = controleerToegelaten(gekozenrichting);
                } catch (Exception e){
                    System.out.println("Ongeldige input.");
                }
            }
            try {
                nietbeschikbaar = controleerBeschikbaar(richting);
            } catch (Exception e){
                System.out.println("Ongeldig gegeven.");
            }
        }
        System.out.println("//----------------------------------------------------------------------------//");

    }


    @Override
    public String toString() {
        return "Map{" +
                "naam='" + naam + '\'' +
                ", plattegrond=" + plattegrondRuw +
                '}';
    }

    public int controleerToegelaten(String richting) { // controleert of de input correct is om dan Kamer volgens de richting aan te duiden.
        int[] mogelijkeRichtingen = getHuidigelocatie().getAangrenzend();
        int gekozenrichting;
        if (richting != null) {
            String lowercase = richting.toLowerCase();
            switch (lowercase) {
                case "no":
                    gekozenrichting = mogelijkeRichtingen[0];
                    break;
                case "noord":
                    gekozenrichting = mogelijkeRichtingen[0];
                    break;
                case "n":
                    gekozenrichting = mogelijkeRichtingen[0];
                    break;
                case "zuid":
                    gekozenrichting = mogelijkeRichtingen[2];
                    break;
                case "z":
                    gekozenrichting = mogelijkeRichtingen[2];
                    break;
                case "west":
                    gekozenrichting = mogelijkeRichtingen[3];
                    break;
                case "w":
                    gekozenrichting = mogelijkeRichtingen[3];
                    break;
                case "oost":
                    gekozenrichting = mogelijkeRichtingen[1];
                    break;
                case "o":
                    gekozenrichting = mogelijkeRichtingen[1];
                    break;
                default:
                    gekozenrichting = 0;

            }
        } else {
            gekozenrichting = 0;
        }
        return gekozenrichting;
    }

    public boolean controleerBeschikbaar(int richting) { // controleert of de aangeduide kamer wel beschikbaar is vanuit de huidige positie
        boolean nietbeschikbaar = true;
        boolean gevonden = false;
        int[] mogelijkeRichtingen = getHuidigelocatie().getAangrenzend();
        for (int cijfer : mogelijkeRichtingen) {
            if (richting == cijfer) {
                nietbeschikbaar = false;
                gevonden = true;
                Iterator lijst = plattegrondRuw.entrySet().iterator();
                while (lijst.hasNext()) {
                    Entry pair = (Entry) lijst.next();
                    Kamer k = (Kamer) pair.getValue();
                    int locatie = k.getIndex();
                    if (richting == locatie) {
                        setHuidigelocatie(k);
                    }
                }
            }
        }
        if (!gevonden) {
            System.out.println("Ongeldige richting");
        }
        return nietbeschikbaar;
    }

    public Kamer getHuidigelocatie() {
        return huidigelocatie;
    }

    public void setHuidigelocatie(Kamer huidigelocatie) {
        this.huidigelocatie = huidigelocatie;
    }

    public void getBeschrijvingHuidigeLocatie() { // beschrijft de huidige positie met de naam van de kamer en het aanwezige meubilair.
        System.out.println(huidigelocatie.getType() + ".");
        int teller = 1;
        if (huidigelocatie.getMeubilair().size() > 0) {
            String s = "";
            for (Meubel m : huidigelocatie.getMeubilair()) {
                s += teller + ":" + " " + "Er staat een " + m.getOmschrijving();
                System.out.println(s);
                s = "";
                teller++;
            }
        }
    }
}

