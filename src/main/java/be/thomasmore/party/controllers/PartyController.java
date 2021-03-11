package be.thomasmore.party.controllers;

import be.thomasmore.party.repositories.PartyRepository;
import be.thomasmore.party.model.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PartyController {

    @Autowired
    private PartyRepository parties;

    @GetMapping("/partylist")
    public String partylist(Model model) {
        Iterable<Party> lijstfeesten = parties.findAll();
        long lengte = parties.count();
        System.out.println(lengte);
        model.addAttribute("parties", lijstfeesten);
        return "partylist";
    }

    @GetMapping({"/partydetails", "partydetails/{index}"})
    public String partydetails(Model model,
                               @PathVariable(required = false) Integer index) {
        System.out.println("Hoi");
        System.out.println(index);
        if (index == null) return "partydetails";

        Optional<Party> zoekParty = parties.findById(index);
        long lengte = parties.count();
        if (zoekParty.isPresent()) {
            model.addAttribute("party", zoekParty.get());
            model.addAttribute("prevId", index > 1 ? index - 1 : lengte);
            model.addAttribute("nextId", index < lengte ? index + 1 : 1);
            }
            return "partydetails";

    }
}
