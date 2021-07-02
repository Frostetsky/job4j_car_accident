package car_accident.controller;

import car_accident.entity.Accident;
import car_accident.entity.AccidentType;
import car_accident.entity.Rule;
import car_accident.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

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
        Collection<Rule> rules = accidentService.findAllRulesType();
        accident.setRules(rules);
        model.addAttribute("rules", rules);
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest request) {
        accident.setAccidentType(getAccidentType(request));
        accident.setRules(getRules(request));
        accidentService.saveAccident(accident);
        return "redirect:/";
    }

    @ModelAttribute("accident")
    public AccidentType getAccidentType(HttpServletRequest request) {
        return (AccidentType) request.getAttribute("accidents");
    }

    @ModelAttribute("accident")
    @SuppressWarnings("unchecked")
    public Collection<Rule> getRules(HttpServletRequest request) {
        return (Collection<Rule>) request.getAttribute("rules");
    }
    
    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Collection<Rule> rules = accidentService.findAllRulesType();
        Optional<Accident> updateAccident = accidentService.findByID(id);
        updateAccident.ifPresent(accident -> model.addAttribute("accident", accident));
        Collection<AccidentType> accidentTypes = accidentService.findAllAccidentTypes();
        model.addAttribute("accidents", accidentTypes);
        model.addAttribute("rules", rules);
        return "create";
    }


}
