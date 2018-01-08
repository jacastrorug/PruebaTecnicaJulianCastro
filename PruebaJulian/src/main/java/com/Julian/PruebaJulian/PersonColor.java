package com.Julian.PruebaJulian;

import java.util.ArrayList;
import java.util.List;

public class PersonColor {

    String color;
    int count;
    List<String>names;

    public PersonColor(String color){
        this.color=color;
        count=0;
        names=new ArrayList<>();
    }

    public void addPerson(String firstname){
        names.add(firstname);
    }

    public void increment(){
        count++;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> persons) {
        this.names = persons;
    }
}
