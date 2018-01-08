package com.Julian.PruebaJulian;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.Julian.PruebaJulian.Entities.PersonEntity;
import com.opencsv.CSVReader;
import com.sun.javafx.iio.ios.IosDescriptor;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReaderPersons {

    public static void main(String args[])throws IOException{
        ReaderPersons read=new ReaderPersons("src/main/java/com/Julian/PruebaJulian/listPersons.csv");
        for(PersonEntity person:read.listPersons){
            System.out.println(person);
        }
    }


    ArrayList<PersonEntity>listPersons;

    public ReaderPersons(String file) throws IOException {

        listPersons=new ArrayList<PersonEntity>();
        CSVReader reader = new CSVReader(new FileReader(file));
        String []record=reader.readNext();
        while(record!=null){
            if(record.length==1) {
                //input have ""
                record = record[0].split(",");
            }
            PersonEntity person=new PersonEntity();
            if(record.length==4){
                //(firstname lastname, color,zipcode, phone number)
                String firstLast[]=record[0].split(" ");
                person.setFirstname(firstLast[0]);
                person.setLastname(firstLast[1]);
                person.setColor(record[1]);
                person.setZipcode(record[2]);
                person.setPhonenumber(record[3]);
                listPersons.add(person);
            }else if(record.length==5) {
                String firstLast[]=record[0].split(" ");
                if(firstLast.length==1){
                    person.setFirstname(record[0]);
                    person.setLastname(record[1]);
                    if(record[2].contains("(") || record[2].contains(" ")){
                        //is phone number
                        //(firstname, lastname, zipcode, phone number, color)
                        person.setZipcode(record[2]);
                        person.setPhonenumber(record[3]);
                        person.setColor(record[4]);
                    }else{
                        //is zipcode
                        //(firstname, lastname, number, color,zipcode)
                        person.setPhonenumber(record[2]);
                        person.setColor(record[3]);
                        person.setZipcode(record[4]);
                    }
                }else if(firstLast.length==2){
                    //(firstname lastname,address, zipcode, phone number, color)
                    person.setFirstname(firstLast[0]);
                    person.setLastname(firstLast[1]);
                    person.setAddress(record[1]);
                    person.setZipcode(record[2]);
                    person.setPhonenumber(record[3]);
                    person.setColor(record[4]);
                }
                listPersons.add(person);
            }else{
                //error
            }
            record=reader.readNext();
        }

    }
}
