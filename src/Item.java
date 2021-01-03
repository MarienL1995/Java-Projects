public class Item {
    private String naam;
    private String omschrijving;

    public Item(String naam, String omschrijving) {
        this.naam = naam;
        this.omschrijving = omschrijving;
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

    @Override
    public String toString() {
        return "Item{" +
                "naam='" + naam + '\'' +
                ", omschrijving='" + omschrijving + '\'' +
                '}';
    }

}
