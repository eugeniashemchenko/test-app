package com.aionys.testapp.service;

import com.aionys.testapp.domain.Person;
import com.aionys.testapp.repository.PeopleRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService  {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

//    public Person findById(Long id){
//        return peopleRepository.findById(id).orElse(null);
//    }

    public List<Person> allPeople(){
        Gson gson = new Gson();

        List<Person> people = new ArrayList<>();
        peopleRepository.findAll().forEach(person ->{
            people.add(person);

//            System.out.println(person);
        });
        String jsonList = gson.toJson(people);
        System.out.println(jsonList);
        return people;
    }

    public Person saveNew(Person person){
        return peopleRepository.save(person);
    }

    public void delete(Long id){ peopleRepository.deleteById(id);}
}
