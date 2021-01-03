import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Container {
    private String naam;
    public HashMap<Integer, Item> inhoud = new HashMap<>();

    public Container(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "Container{" +
                "naam='" + naam + '\'' +
                ", inhoud=" + inhoud +
                '}';
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public HashMap<Integer, Item> getInhoud() {
        return inhoud;
    }

    public void setInhoud(HashMap<Integer, Item> inhoud) {
        this.inhoud = inhoud;
    }
}
