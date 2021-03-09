package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Party;
import be.thomasmore.party.model.Venue;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PartyRepository extends CrudRepository<Party,Integer> {
    ArrayList<Party> findByVenue(Venue venue);
}
