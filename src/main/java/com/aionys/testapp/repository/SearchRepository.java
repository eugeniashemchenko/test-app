package com.aionys.testapp.repository;

import com.aionys.testapp.dto.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<PersonDto, Long> {


}
