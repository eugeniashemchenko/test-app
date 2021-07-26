package com.aionys.testapp.controller;

import com.aionys.testapp.domain.Person;
import com.aionys.testapp.dto.PersonDto;
import com.aionys.testapp.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
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
    public String newPerson(@ModelAttribute("person") PersonDto person){
return "Test";
    }

    @PostMapping
    public void createNew(@RequestBody PersonDto person){
        Person p = new Person();
        p.setName(person.name);
        p.setSurname(person.surname);
        p.setPatronymic(person.patronymic);
        p.setDateOfBirth(person.dateOfBirth);

        peopleService.save(p);
    }
}
