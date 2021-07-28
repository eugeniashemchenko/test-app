package com.aionys.testapp.repository;

import com.aionys.testapp.domain.Person;
import com.aionys.testapp.dto.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Person, Long> {


}
