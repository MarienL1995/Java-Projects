package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Artist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import be.thomasmore.party.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ArtistController {
    private Logger logger = LoggerFactory.getLogger(ArtistController.class);
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping({"/artistdetails", "/artistdetails/{id}"})
    public String artistDetails(Model model,
                                @PathVariable(required = false) Integer id) {
        if (id == null) return "artistdetails";

        Optional<Artist> optionalArtist = artistRepository.findById(id);
        if (optionalArtist.isPresent()) {
            long nrOfArtists = artistRepository.count();
            model.addAttribute("artist", optionalArtist.get());
            model.addAttribute("prevId", id > 1 ? id - 1 : nrOfArtists);
            model.addAttribute("nextId", id < nrOfArtists ? id + 1 : 1);
        }
        return "artistdetails";
    }

    @GetMapping("/artistlist")
    public String artistList(Model model, @RequestParam(required = false)String search) {
        logger.info(String.format("artistList--search%S",search));
        if(search != null){
            ArrayList<Artist> artists2 = artistRepository.findArtistByArtistNameContainsIgnoreCase(search);
            model.addAttribute("artists",artists2);
        } else {
            Iterable<Artist> artists = artistRepository.findAll();
            model.addAttribute("artists", artists);
        }
        return "artistlist";
    }
}
