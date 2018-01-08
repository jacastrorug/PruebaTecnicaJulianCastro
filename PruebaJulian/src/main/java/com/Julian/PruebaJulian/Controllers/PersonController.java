package com.Julian.PruebaJulian.Controllers;

import com.Julian.PruebaJulian.CountColor;
import com.Julian.PruebaJulian.Entities.PersonEntity;
import com.Julian.PruebaJulian.PersonColor;
import com.Julian.PruebaJulian.ServicesImplementation.PersonServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@CrossOrigin
@RestController
public class PersonController {

    @Autowired
    private PersonServiceImplementation personServiceImplementation;


    @RequestMapping(value="/addPerson",method= RequestMethod.GET)
    public PersonEntity addPerson(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, @RequestParam("address") String address, @RequestParam("zipcode") String zipcode, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("color") String color){
        PersonEntity pe = new PersonEntity(firstname,lastname,address,zipcode,phoneNumber,color.trim());
        return personServiceImplementation.savePerson(pe);
    }

    @RequestMapping(value="/listAll", method=RequestMethod.GET)
    public List<PersonEntity> findAll(){
        return personServiceImplementation.findAll();
    }

    @RequestMapping(value="/listColor", method=RequestMethod.GET)
    public List<CountColor> findByColor(){
        List<CountColor>personColors=new ArrayList<>();
        TreeMap<String,CountColor>map=new TreeMap<>();
        List<PersonEntity>listPerons= personServiceImplementation.findAll();
        for(PersonEntity p:listPerons){
            CountColor pc=null;
          if(map.containsKey(p.getColor())) {
              pc=map.get(p.getColor());
              map.get(p.getColor()).increment();
          }else{
              pc=new CountColor(p.getColor());
              pc.increment();
              map.put(p.getColor(),pc);
          }
        }
        for(Map.Entry<String,CountColor> et:map.entrySet()){
            personColors.add(et.getValue());
        }
        return personColors;
    }

    @RequestMapping(value="/listPersonColor", method=RequestMethod.GET)
    public List<PersonColor> findByPersonColor(){
        List<PersonColor>personColors=new ArrayList<>();
        TreeMap<String,PersonColor>map=new TreeMap<>();
        List<PersonEntity>listPerons= personServiceImplementation.findAll();
        for(PersonEntity p:listPerons){
            PersonColor pc=null;
            if(map.containsKey(p.getColor())) {
                pc=map.get(p.getColor());
                map.get(p.getColor()).increment();
                map.get(p.getColor()).addPerson(p.getFirstname());
            }else{
                pc=new PersonColor(p.getColor());
                pc.increment();
                pc.addPerson(p.getFirstname());
                map.put(p.getColor(),pc);
            }
        }
        for(Map.Entry<String,PersonColor> et:map.entrySet()){
            personColors.add(et.getValue());
        }
        return personColors;
    }



}
