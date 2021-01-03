public class GezondheidUsable extends Item {
    private boolean isUitrustbaar = false;
    private int xLevenspunten;
    public GezondheidUsable(String naam, String omschrijving,int xLevenspunten) {
        super(naam, omschrijving);
        this.xLevenspunten = xLevenspunten;
    }

    public boolean isUitrustbaar() {
        return isUitrustbaar;
    }

    public void setUitrustbaar(boolean uitrustbaar) {
        isUitrustbaar = uitrustbaar;
    }

    public int getxLevenspunten() {
        return xLevenspunten;
    }

    public void setxLevenspunten(int xLevenspunten) {
        this.xLevenspunten = xLevenspunten;
    }

    @Override
    public String toString() {
        return super.toString() + "GezondheidUsable{" +
                "isUitrustbaar=" + isUitrustbaar +
                ", xLevenspunten=" + xLevenspunten +
                '}';
    }
}
