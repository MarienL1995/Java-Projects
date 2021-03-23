package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Party;
import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.PartyRepository;
import be.thomasmore.party.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired

    private PartyRepository partyRepo;

    @Autowired
    private VenueRepository venueRepo;

    @ModelAttribute("party")
    public Party findParty(@PathVariable(required = false) Integer id) {
        Party nieuweparty = new Party();
        if (id != null) {
            Optional<Party> optionalParty = partyRepo.findById(id);
            if (optionalParty.isPresent()) {
                return optionalParty.get();

            }
        } else if (id == null){
            return nieuweparty;
        }
        return null;
    }
    @ModelAttribute("venues")
    public List<Venue> listVenues(){
        List<Venue> venueLijst = venueRepo.findAll();
        return venueLijst;
    }
    @GetMapping("/partyedit/{id}")

    public String partyedit(Model model, @PathVariable(required = false)Integer id) {
        return "admin/partyedit";
    }
    @GetMapping("/partynew")
    public String partynew (Model model){
        Party nieuweparty = new Party();
        model.addAttribute("nieuweparty",nieuweparty);
        return "admin/partynew";
    }

    @PostMapping({"/partyedit","/partyedit/{id}"})

    public String partyeditPost(Model model, @PathVariable(required = false)Integer id,
                                @Valid@ModelAttribute("party")Party party,
                                BindingResult bindingResult,
                                @RequestParam(required = false) Integer venue){
        if (bindingResult.hasErrors()){
            return "admin/partyedit";
        }
        if (party.getVenue().getId() != venue){
            Venue venue1 = new Venue();
            venue1.setId(venue);
            party.setVenue(venue1);
        }
        partyRepo.save(party);
        return "redirect:/partydetails/" + id;
    }
    @PostMapping("/partynew")
    public String partyNewPost(Model model,
                               @Valid @ModelAttribute("party") Party party,
                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "admin/partyedit";
        }
        partyRepo.save(party);
        return "redirect:/partylist/";
    }
}
