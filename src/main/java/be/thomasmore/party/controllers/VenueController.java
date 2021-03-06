package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.VenueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class VenueController {
    private Logger logger = LoggerFactory.getLogger(VenueController.class);


    @Autowired
    private VenueRepository venueRepository;

    @GetMapping({"/venuedetails", "/venuedetails/{id}"})
    public String venueDetails(Model model,
                               @PathVariable(required = false) Integer id) {
        if (id == null) return "venuedetails";

        Optional<Venue> optionalVenue = venueRepository.findById(id);
        if (optionalVenue.isPresent()) {
            long nrOfVenues = venueRepository.count();
            model.addAttribute("venue", optionalVenue.get());
            model.addAttribute("prevId", id > 1 ? id - 1 : nrOfVenues);
            model.addAttribute("nextId", id < nrOfVenues ? id + 1 : 1);
        }
        return "venuedetails";
    }

    @GetMapping("/venuelist")
    public String venueList(Model model) {
        boolean filter = false;
        Iterable<Venue> venues = venueRepository.findAll();
        long telVenues = venueRepository.count();
        model.addAttribute("venues", venues);
        model.addAttribute("filter", filter);
        model.addAttribute("aantalVenues", telVenues);
        return "venuelist";
    }

    @GetMapping("/venuelist/filter")
    public String venueListFilter(Model model, @RequestParam(required = false) Integer minCapacity, @RequestParam(required = false) Integer maxCapacity,
                                  @RequestParam(required = false) String food, @RequestParam(required = false) String indoor,
                                  @RequestParam(required = false) String outdoor, @RequestParam(required = false) Integer distance) {
        logger.info(String.format("venueListFilter -- min%d", minCapacity));
        ArrayList<Venue> venues2 = venueRepository.findByQuery(minCapacity, maxCapacity,distance,food,indoor,outdoor);
        int aantalVenues = venues2.size();
        model.addAttribute("venues", venues2);
        model.addAttribute("aantalVenues", aantalVenues);
        model.addAttribute("filter", true);
        return "venuelist";
    }

}
