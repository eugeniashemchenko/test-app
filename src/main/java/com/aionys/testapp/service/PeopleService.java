package com.aionys.testapp.service;

import com.aionys.testapp.domain.Person;
import com.aionys.testapp.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Person saveNew(Person person){
        return peopleRepository.save(person);
    }

}
