import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Meubel {
    private String omschrijving;
    private int grootte;
    private HashMap<Integer, Container> containers = new HashMap<>();

    public Meubel(String omschrijving) {
        Random r1 = new Random();
        int getal = r1.nextInt(5);
        this.omschrijving = omschrijving;
        this.grootte = getal;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public int getGrootte() {
        return grootte;
    }

    public void setGrootte(int grootte) {
        this.grootte = grootte;
    }

    public HashMap<Integer, Container> getContainers() {
        return containers;
    }

    public void setContainers(HashMap<Integer, Container> containers) {
        this.containers = containers;
    }

    @Override
    public String toString() {
        return "Meubel{" +
                "omschrijving='" + omschrijving + '\'' +
                ", containers=" + containers +
                '}';
    }

    public int vulContainerNiveau1(ArrayList<Item> basicItems, ArrayList<Item> sleutelItems, ArrayList<Container> lijstContainers, int plaatsingspercentage) {
        Random r1 = new Random();
        Random r2 = new Random();
        int getal = r1.nextInt(91 + plaatsingspercentage);
        int getal2 = r2.nextInt(basicItems.size() - 1);
        int teller = 1;
        for (int i = 0; i < lijstContainers.size(); i++) {
            for (int j = 0; j < 5; j++) {
                if (getal >= 50) {
                    if (getal >= 90 && sleutelItems.size() == 3) {
                        lijstContainers.get(i).inhoud.put(teller, sleutelItems.get(0));
                        sleutelItems.remove(0);
                        plaatsingspercentage = 0;
                    } else {
                        lijstContainers.get(i).inhoud.put(teller, basicItems.get(getal2));
                        if (basicItems.get(getal2) instanceof Wapen) {
                            basicItems.remove(getal2);
                        }
                        plaatsingspercentage += 1;
                    }
                }
                getal2 = r2.nextInt(basicItems.size() - 1);
            }
        }
        return plaatsingspercentage;
    }

    public void vulMeubel(ArrayList<Container> componenten) { // vult het meubel met een random aantal containers waarbij het max aantal containers de capaciteit van het meubel is.
        Random r2 = new Random();
        int getal2 = r2.nextInt(2) + 1;
        int teller = 1;
        for (int i = 0; i < grootte; i++) {
            containers.put(teller, componenten.get(getal2));
            getal2 = r2.nextInt(2) + 1;
            teller++;
        }
    }

}
