package com.Julian.PruebaJulian.ServicesImplementation;

import com.Julian.PruebaJulian.Entities.PersonEntity;
import com.Julian.PruebaJulian.Repository.PersonRepository;
import com.Julian.PruebaJulian.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImplementation implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonEntity savePerson(PersonEntity personEntity) {
        return personRepository.saveAndFlush(personEntity);
    }

    public List<PersonEntity>findAll(){
        return personRepository.findAll();
    }
}
