package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
    @Query("select a from Artist a where ?1 is null or upper( a.portfolio) like concat( '%', upper(?1),'%') " +
            "or(upper(a.bio) like concat( '%', upper(?1),'%'))" +
            "or(upper(a.portfolio) like concat( '%', upper( ?1),'%'))")
    ArrayList<Artist> findArtistByArtistNameContainsIgnoreCase(String s);

}

