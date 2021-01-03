import java.util.ArrayList;

public class Rol {
    private String naam;
    private String omschrijving;
    private int xLevenspunten;
    private int xGeestpunten;
    private int xAanvalskracht;

    public Rol(String naam, String omschrijving, int xLevenspunten, int xGeestpunten, int xAanvalskracht) {
        this.naam = naam;
        this.omschrijving = omschrijving;
        this.xLevenspunten = xLevenspunten;
        this.xGeestpunten = xGeestpunten;
        this.xAanvalskracht = xAanvalskracht;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }


    public int getxLevenspunten() {
        return xLevenspunten;
    }

    public void setxLevenspunten(int xLevenspunten) {
        this.xLevenspunten = xLevenspunten;
    }

    public int getxGeestpunten() {
        return xGeestpunten;
    }

    public void setxGeestpunten(int xGeestpunten) {
        this.xGeestpunten = xGeestpunten;
    }

    public int getxAanvalskracht() {
        return xAanvalskracht;
    }

    public void setxAanvalskracht(int xAanvalskracht) {
        this.xAanvalskracht = xAanvalskracht;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "naam='" + naam + '\'' +
                ", omschrijving='" + omschrijving + '\'' +
                ", xLevenspunten=" + xLevenspunten +
                ", xGeestpunten=" + xGeestpunten +
                ", xAanvalskracht=" + xAanvalskracht +
                '}';
    }
}
