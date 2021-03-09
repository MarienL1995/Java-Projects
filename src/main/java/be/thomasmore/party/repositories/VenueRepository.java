package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface VenueRepository extends CrudRepository<Venue, Integer> {
    Iterable<Venue> findByOutdoor(boolean isOutdoor);

    Iterable<Venue> findByIndoor(boolean isIndoor);

    @Query("select v from Venue v where (?1 is null or v.capacity >= ?1) "
            + "and(?2 is null or v.capacity <= ?2) "
            + "and(?3 is null or v.distanceFromPublicTransportInKm <= ?3)"
            + "and(?4 is null or v.foodProvided = ?4) "
            + "and(?5 is null or v.indoor = ?5) "
            + "and(?6 is null or v.outdoor = ?6) ")
    ArrayList<Venue> findByQuery(Integer min, Integer max, Integer distance,boolean food, boolean indoor, boolean outdoor);

    @Query("select v from Venue v where v.capacity is null or v.capacity >= ?1")
    ArrayList<Venue> findByCapacityGreaterThanEqualQuery(Integer min);
}
