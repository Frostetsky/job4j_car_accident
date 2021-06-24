package car_accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        List<String> list = List.of("Nikita Nesterenko",
                                    "Petr Arsentev",
                                    "Andrey Borchenko");
        model.addAttribute("list", list);
        return "index";
    }
}