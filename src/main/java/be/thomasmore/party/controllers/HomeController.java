package be.thomasmore.party.controllers;
import be.thomasmore.party.model.Artist;
import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.ArtistRepository;
import be.thomasmore.party.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    private final String[] venueNames = {"De Loods", "De Club", "De Hangar", "Zapoi", "Kuub", "Cuba Libre"};
    private final Venue[] venues = {new Venue("De Loods","Meer info ?",50,500,400),
                                    new Venue("De Club","Meer info",40,250,300)};
    @Autowired
    private VenueRepository venueRepository;
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "Home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }


    @GetMapping({"/venuedetails","venuedetails/{id}"})
    public String venueDetailsById(Model m1,@PathVariable (required = false) Integer id){
        if(id != null) {
            long lengte = venueRepository.count();
            if (venueRepository.findById(id).isPresent()) {
                m1.addAttribute("venue", venueRepository.findById(id).get());
                m1.addAttribute("nextId", id + 1 < lengte ? id + 1 : 1);
                m1.addAttribute("prevId", id - 1 > 0 ? id - 1 : lengte);
            }
        }
        return "venuedetails";
    }

    @GetMapping("/venuelist")
    public String venueList(Model model) {
        Iterable<Venue> venues = venueRepository.findAll();
        model.addAttribute("venues",venues);
        return "venuelist";
    }
    @GetMapping("/artistlist")
    public String artistList(Model model){
        Iterable<Artist> artists = artistRepository.findAll();
        model.addAttribute("artists",artists);
        return "artistlist";
    }
    @GetMapping({"/artistdetails","/artistdetails/{id}"})
    public String artistdetails(Model model, @PathVariable (required = false)Integer id){
        if (id != null){
            long lengte = artistRepository.count();
            if (artistRepository.findById(id).isPresent()){
                model.addAttribute("artist",artistRepository.findById(id).get());
                model.addAttribute("prevArtist",id - 1 < 1 ? lengte : id-1);
                model.addAttribute("nextArtist",id + 1 > lengte ? 1 : id +1 );
            }
        }
        return "artistdetails";
    }

}
