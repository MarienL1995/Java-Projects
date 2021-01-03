public class Wapen extends Item {
    private boolean isUitrustbaar = true;
    private int xAanvalspunten;
    private int Duurzaamheid;
    public Wapen(String naam, String omschrijving, int xAanvalspunten) {
        super(naam, omschrijving);
        this.xAanvalspunten = xAanvalspunten;
    }

    public String toString() {
        return super.toString() + "Wapen{" +
                "isUitrustbaar=" + isUitrustbaar +
                ", xAanvalspunten=" + xAanvalspunten +
                ", Duurzaamheid=" + Duurzaamheid +
                '}';
    }
}
