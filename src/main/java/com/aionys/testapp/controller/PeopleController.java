package com.aionys.testapp.controller;

import com.aionys.testapp.domain.Person;
import com.aionys.testapp.dto.PersonDto;
import com.aionys.testapp.service.PeopleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    @ResponseBody
    public List<Person> allPeople(){

        return peopleService.allPeople();

    }

    @PostMapping("/main")
    public ResponseEntity<PersonDto> createNew(@RequestBody PersonDto dto){

        // convert DTO to Entity
        Person postRequest = modelMapper.map(dto, Person.class);

        Person person = peopleService.saveNew(postRequest);

        // entity to DTO
        PersonDto postResponse = modelMapper.map(person, PersonDto.class);

        return ResponseEntity.ok().body(postResponse);
    }

    @GetMapping("/all/{id}")
    @ResponseBody
    public void delete(@PathVariable(value = "id") Long id) {
        peopleService.delete(id);
    }

}
