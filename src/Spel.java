import javax.swing.*;
import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Spel {
    private Player speler;
    private Map plattegrond;
    private int score;
    private boolean GameOver = false;

    public Spel(Player speler, Map plattegrond) {
        this.speler = speler;
        this.plattegrond = plattegrond;
    }

    public void gevecht() {

    }

    public void verhoogScore() {

    }

    public void ControleerGameOver() {

    }

    public void GeefOpties() { // Initialiseert waneer een kamer wordt betreedt. Geeft eerst alle mogelijke richtingen en dan het beschikbare meubilair.
        plattegrond.getBeschrijvingHuidigeLocatie();
        beschikbareRichtingen();
        if (plattegrond.getHuidigelocatie().getMeubilair().size() > 0) {
            System.out.println("Wat wil je doen? (1 om de kamer te doorzoeken, 2 om te navigeren)");
            maakKeuze();
        } else {
            plattegrond.Verplaats();
            GeefOpties();
        }
    }

    public void beschikbareRichtingen() { // Controleert welke indexen vanuit de huidige locatie beschikbaar zijn.
        int[] mogelijkeRichtingen = plattegrond.getHuidigelocatie().getAangrenzend();
        for (int i = 0; i < mogelijkeRichtingen.length - 1; i++) {
            if (mogelijkeRichtingen[i] >= 0) {
                zetRichtingenOm(i);
            }
        }
    }

    public void zetRichtingenOm(int richting) { // Zet de beschikbare indexen om naar richtingen

        switch (richting) {
            case 0:
                System.out.println("Je kan naar het noorden");
                break;
            case 1:
                System.out.println("Je kan naar het oosten");
                break;
            case 2:
                System.out.println("Je kan naar het zuiden");
                break;
            case 3:
                System.out.println("Je kan naar het westen");
                break;
        }
    }

    public void maakKeuze() { // Vraagt een keuze te maken aan de gebruiker 1 voor meubilair te doorzoeken ( WIP ) en 2 voor te navigeren  naar een andere kamer.
        int keuze = 0;
        boolean keuzeOk = false;
        while (!keuzeOk) {
            try {
                String s = JOptionPane.showInputDialog(null, "Geef je keuze");
                keuze = Integer.parseInt(s);
            } catch (NumberFormatException ignore) {
            } catch (InputMismatchException ignore) {
            }
            if (keuze == 1 || keuze == 2) {
                keuzeOk = true;
            }
        }
        if (keuze == 1) {
            plattegrond.Verplaats();
            GeefOpties();
        } else {
            plattegrond.Verplaats();
            GeefOpties();
        }
    }
}
