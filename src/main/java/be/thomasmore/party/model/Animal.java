package be.thomasmore.party.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Animal {
    @Id
    private int id;
    private String name;
    private String city;
    private String bio;
    @ManyToMany
    private Collection<Party>feestjes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    public Collection<Party> getFeestjes() {
        return feestjes;
    }

    public void setFeestjes(Collection<Party> feestjes) {
        this.feestjes = feestjes;
    }
}
