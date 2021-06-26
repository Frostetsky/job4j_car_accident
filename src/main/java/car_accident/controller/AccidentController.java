package car_accident.controller;

import car_accident.entity.Accident;
import car_accident.repository.AccidentMem;
import car_accident.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccidentController {

    @Autowired
    private AccidentService accidentService;

    @RequestMapping("/create")
    public String create(Model model) {

        Accident accident = new Accident();
        model.addAttribute("accident", accident);

        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("accident") Accident accident) {
        accidentService.saveAccident(accident);
        return "redirect:/";
    }
}
