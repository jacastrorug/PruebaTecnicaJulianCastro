package com.Julian.PruebaJulian;

public class CountColor {

    String color;
    int count;

    public CountColor(String color){
        this.color=color;
        count=0;
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
}
