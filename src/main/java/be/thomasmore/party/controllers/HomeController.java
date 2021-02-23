package be.thomasmore.party.controllers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    private final String[] venueNames = {"De Loods", "De Club", "De Hangar", "Zapoi", "Kuub", "Cuba Libre"};

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
        if (index!=null && index>=0 && index<venueNames.length ) {
            model.addAttribute("venueName", venueNames[index]);
            model.addAttribute("prevIndex", index>0 ? index-1 : venueNames.length-1);
            model.addAttribute("nextIndex", index<venueNames.length-1 ? index+1 : 0);
        }
        return "venuedetails";
    }

    @GetMapping("/venuelist")
    public String venueList(Model model) {
        model.addAttribute("venueNames", venueNames);
        return "venuelist";
    }
}
