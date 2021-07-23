package com.aionys.testapp.controller;

import com.aionys.testapp.domain.Person;
import com.aionys.testapp.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

//    @GetMapping("/{id}")
//    public String findById(@PathVariable("id") long id, Model model) {
//        model.addAttribute("person", peopleService.findById(id));
//        return "people/main";
//    }

    @GetMapping()
    public String newPerson(@ModelAttribute("person") Person person){
        return "people/main";
    }

    @PostMapping
    public String createNew(@ModelAttribute("person") Person person){
        peopleService.save(person);
        return "redirect:/people";
    }
}
