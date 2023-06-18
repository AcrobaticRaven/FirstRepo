package org.example.WT03;

public class Car {
    private String color;
    private String type;

    public Car(String color,String type){
        this.color = color;
        this.type = type;
    }
    @Override
    public String toString(){
        return "Car{" +
                "color='" + color + '\'' +
                ", type=" + type +
                '}';

    }
}
