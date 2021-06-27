package car_accident.controller;

import car_accident.entity.Accident;
import car_accident.entity.AccidentType;
import car_accident.entity.Rule;
import car_accident.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
public class AccidentController {

    @Autowired
    private AccidentService accidentService;

    @RequestMapping("/create")
    public String create(Model model) {
        Accident accident = new Accident();
        model.addAttribute("accident", accident);
        Collection<AccidentType> accidentsTypes =  accidentService.findAllAccidentTypes();
        model.addAttribute("accidents", accidentsTypes);
        Collection<Rule> rules = accident.getRules();
        model.addAttribute("rules", rules);
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("accident") Accident accident) {
        accidentService.saveAccident(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Collection<Rule> rules = new Accident().getRules();
        Optional<Accident> updateAccident = accidentService.findByID(id);
        updateAccident.ifPresent(accident -> model.addAttribute("accident", accident));
        Collection<AccidentType> accidentTypes = accidentService.findAllAccidentTypes();
        model.addAttribute("accidents", accidentTypes);
        model.addAttribute("rules", rules);
        return "create";
    }


}
