import java.util.Arrays;

public class Gang extends Kamer {
    private String type = "gang";
    private int[] aangrenzend;

    public Gang(int index, int[] locaties) {
        super(index);
        this.aangrenzend = locaties;

    }

    @Override
    public String toString() {
        return "Gang{" +
                "type='" + type + '\'' +
                ", aangrenzend=" + Arrays.toString(aangrenzend) +
                '}';
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int[] getAangrenzend() {
        return aangrenzend;
    }

    @Override
    public void setAangrenzend(int[] aangrenzend) {
        this.aangrenzend = aangrenzend;
    }
}
