package gb.khavdey.hw6.controller;

import gb.khavdey.hw6.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;


    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("person", personService.findAll());
        return "person";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return "person";
    }
}
