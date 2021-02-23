package be.thomasmore.party.model;

public class Venue {
    private String venueName;
    private String linkMoreInfo;
    private int capaciteit;
    private double kostprijsPA;
    private double oppervlakteinMM;

    public Venue(String venueName, String linkMoreInfo, int capaciteit, double kostprijsPA, double oppervlakteinMM) {
        this.venueName = venueName;
        this.linkMoreInfo = linkMoreInfo;
        this.capaciteit = capaciteit;
        this.kostprijsPA = kostprijsPA;
        this.oppervlakteinMM = oppervlakteinMM;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getLinkMoreInfo() {
        return linkMoreInfo;
    }

    public void setLinkMoreInfo(String linkMoreInfo) {
        this.linkMoreInfo = linkMoreInfo;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    public double getKostprijsPA() {
        return kostprijsPA;
    }

    public void setKostprijsPA(double kostprijsPA) {
        this.kostprijsPA = kostprijsPA;
    }

    public double getOppervlakteinMM() {
        return oppervlakteinMM;
    }

    public void setOppervlakteinMM(double oppervlakteinMM) {
        this.oppervlakteinMM = oppervlakteinMM;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueName='" + venueName + '\'' +
                ", linkMoreInfo='" + linkMoreInfo + '\'' +
                ", capaciteit=" + capaciteit +
                ", kostprijsPA=" + kostprijsPA +
                ", oppervlakteinMM=" + oppervlakteinMM +
                '}';
    }
}
