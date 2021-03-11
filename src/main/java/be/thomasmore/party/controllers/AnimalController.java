package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Animal;
import be.thomasmore.party.model.Artist;
import be.thomasmore.party.repositories.AnimalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import be.thomasmore.party.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;
@Controller
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping({"/animaldetails","/animaldetails/{index}"})
    public String animaldetails(Model model,
                                @PathVariable (required = false) Integer index){
        if(index != null){
            Optional<Animal> optionalAnimal = animalRepository.findById(index);
            if (optionalAnimal.isPresent()) {
                model.addAttribute("animal",optionalAnimal.get());
            }
        }
        return "animaldetails";
    }
}
