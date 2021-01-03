public class GeestUsable extends Item {
    private boolean isUitrustbaar = false;
    private int xGeestToestand;
    public GeestUsable(String naam, String omschrijving,int xGeestToestand) {
        super(naam, omschrijving);
        this.xGeestToestand = xGeestToestand;
    }

    public boolean isUitrustbaar() {
        return isUitrustbaar;
    }

    public void setUitrustbaar(boolean uitrustbaar) {
        isUitrustbaar = uitrustbaar;
    }

    public int getxGeestToestand() {
        return xGeestToestand;
    }

    public void setxGeestToestand(int xGeestToestand) {
        this.xGeestToestand = xGeestToestand;
    }

    @Override
    public String toString() {
        return super.toString() + "GeestUsable{" +
                "isUitrustbaar=" + isUitrustbaar +
                ", xGeestToestand=" + xGeestToestand +
                '}';
    }
}
