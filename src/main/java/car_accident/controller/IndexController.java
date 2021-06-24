package car_accident.controller;

import car_accident.entity.Accident;
import car_accident.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class IndexController {

    @Autowired
    private AccidentService accidentService;

    @GetMapping("/")
    public String index(Model model) {
        Collection<Accident> accidents = accidentService.findAllAccident();
        model.addAttribute("accidents", accidents);
        return "index";
    }
}