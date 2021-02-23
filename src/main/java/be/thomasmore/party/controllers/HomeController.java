package be.thomasmore.party.controllers;
import be.thomasmore.party.model.Venue;
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

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "Home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping({"/venuedetails", "/venuedetails/{index}"})
    public String venueDetails(Model model,
                               @PathVariable(required = false)  Integer index) {
        if (index!=null && index>=0 && index<venues.length ) {
            model.addAttribute("venue",venues[index]);
            model.addAttribute("vorigeVenue", index>0 ? index -1: venues.length-1);
            model.addAttribute("volgendeVenue",index<venues.length-1 ? index + 1 : 0);
        }
        return "venuedetails";
    }

    @GetMapping("/venuelist")
    public String venueList(Model model) {
        model.addAttribute("venueNames", venueNames);
        model.addAttribute("venues",venues);
        return "venuelist";
    }
}
