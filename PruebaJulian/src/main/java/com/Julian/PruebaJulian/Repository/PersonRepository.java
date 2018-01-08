package com.Julian.PruebaJulian.Repository;

import com.Julian.PruebaJulian.Entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {

}
