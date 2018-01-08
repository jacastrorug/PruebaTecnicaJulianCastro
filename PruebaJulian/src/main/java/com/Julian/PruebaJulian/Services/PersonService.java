package com.Julian.PruebaJulian.Services;

import com.Julian.PruebaJulian.Entities.PersonEntity;

import java.util.List;

public interface PersonService {
    PersonEntity savePerson(PersonEntity personEntity);
    List<PersonEntity>findAll();
}
