package be.thomasmore.party.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Artist {
    @Id
    private int Id;
    @Column(length = 500)
    private String artistName;
    @Column(length = 500)
    private String linkMoreInfo;
    @Column(length = 500)
    private String genre;
    @Column(length = 500)
    private String bio;
    @Column(length = 500)
    private String portfolio;

    public Artist() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getLinkMoreInfo() {
        return linkMoreInfo;
    }

    public void setLinkMoreInfo(String linkMoreInfo) {
        this.linkMoreInfo = linkMoreInfo;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "Id=" + Id +
                ", artistName='" + artistName + '\'' +
                ", linkMoreInfo='" + linkMoreInfo + '\'' +
                ", genre='" + genre + '\'' +
                ", bio='" + bio + '\'' +
                ", portfolio='" + portfolio + '\'' +
                '}';
    }
}
