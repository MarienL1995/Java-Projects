package be.thomasmore.party.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Venue {
    @Id
    private int id;
    private String venueName;
    private String linkMoreInfo;
    private int capacity;
    private double kostprijsPA;
    private double oppervlakteinMM;

    public Venue(String venueName, String linkMoreInfo, int capaciteit, double kostprijsPA, double oppervlakteinMM) {
        this.venueName = venueName;
        this.linkMoreInfo = linkMoreInfo;
        this.capacity = capaciteit;
        this.kostprijsPA = kostprijsPA;
        this.oppervlakteinMM = oppervlakteinMM;
    }

    public Venue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
        return capacity;
    }

    public void setCapaciteit(int capaciteit) {
        this.capacity = capaciteit;
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
                ", capaciteit=" + capacity +
                ", kostprijsPA=" + kostprijsPA +
                ", oppervlakteinMM=" + oppervlakteinMM +
                '}';
    }


}
