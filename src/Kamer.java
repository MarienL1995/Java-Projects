import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Kamer {
    private String type = "kamer";
    private ArrayList<Meubel> meubilair = new ArrayList<>();
    private int index;
    private int[] aangrenzend;
    private Event event;
    private Vijand vijand;

    public Kamer(int index) {
        this.index = index;
    }

    public Kamer(String type, int index,int[]locaties ) {
        this.type = type;
        this.index = index;
        this.aangrenzend = locaties;
    }

    public ArrayList<Meubel> getMeubilair() {
        return meubilair;
    }

    public void setMeubilair(ArrayList<Meubel> meubilair) {
        this.meubilair = meubilair;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Kamer{" +
                "type='" + type + '\'' +
                ", meubilair=" + meubilair +
                ", index=" + index +
                ", aangrenzend=" + Arrays.toString(aangrenzend) +
                '}';
    }

    public void vulKamerMeubels(ArrayList<Meubel>lijstMeubels){ // De kamer wordt random van een aantal ( of geen ) meubels voorzien
        Random r1 = new Random();
        int getal = r1.nextInt(12);
        int teller = 0;
        for (int i = 0; i <4 ; i++) {
            if (getal > 7){
                meubilair.add(lijstMeubels.get(teller));
                teller ++;
            }
            getal = r1.nextInt(12);

        }
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int[] getAangrenzend() {
        return aangrenzend;
    }

    public void setAangrenzend(int[] aangrenzend) {
        this.aangrenzend = aangrenzend;
    }
}
