package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Artist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import be.thomasmore.party.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
public class AnimalController {
    @GetMapping({"/animaldetails","/animaldetails/{index}"})
    public String animaldetails(Model model){
        return "animaldetails";
    }
}
