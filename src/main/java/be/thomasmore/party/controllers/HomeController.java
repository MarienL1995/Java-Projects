package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Controller

public class HomeController {
    private final int mySpecialNumber = 729;
    private Date date = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private LocalDateTime date2 = LocalDateTime.now().plusDays(30);
    @GetMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("mySpecialNumber",mySpecialNumber);
        return "Home";
    }
    @GetMapping("/about")
    public String about(){
        return "About";
    }
    @GetMapping("/pay")
    public String pay(Model model){
        model.addAttribute("Huidedatumentijd",formatter.format(date));
        model.addAttribute("nieuweTijd",date2);
        return "pay";
    }
    @GetMapping({"/venuedetails","/venuedetails/{venueName}"})
    public String venueDetails(Model model , @PathVariable(required = false) String venueName){
        model.addAttribute("venueName",(venueName != null) ? venueName : "--no venue chosen --");
        return "venuedetails";
    }
    @GetMapping("/venuelist")
        public String venueList(Model model){
        return "venuelist";
    }
}
