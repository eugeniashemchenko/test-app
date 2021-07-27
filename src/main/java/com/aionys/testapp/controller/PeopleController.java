package com.aionys.testapp.controller;

import com.aionys.testapp.domain.Person;
import com.aionys.testapp.dto.PersonDto;
import com.aionys.testapp.service.PeopleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/people")
public class PeopleController {

    private final ModelMapper modelMapper;
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService, ModelMapper modelMapper) {
        this.peopleService = peopleService;
        this.modelMapper = modelMapper;
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

//    @PostMapping("/main")
//    public void createNew(@RequestBody Person person){
//        peopleService.save(person);
//    }

    @PostMapping("/main")
    public ResponseEntity<PersonDto> createNew(@RequestBody PersonDto dto){

        // convert DTO to Entity
        Person postRequest = modelMapper.map(dto, Person.class);

        Person person = peopleService.saveNew(postRequest);

        // entity to DTO
        PersonDto postResponse = modelMapper.map(person, PersonDto.class);

        return ResponseEntity.ok().body(postResponse);
    }
}
